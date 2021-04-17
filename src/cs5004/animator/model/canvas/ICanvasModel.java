package cs5004.animator.model.canvas;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;

import cs5004.animator.model.shape.Oval;
import cs5004.animator.model.shape.Point2D;
import cs5004.animator.model.shape.Rectangle;
import cs5004.animator.model.shape.Shape;
import cs5004.animator.model.transformation.ChangeColorT;
import cs5004.animator.model.transformation.MoveT;
import cs5004.animator.model.transformation.ResizeT;
import cs5004.animator.model.transformation.Transformation;
import cs5004.animator.model.transformation.TransformationType;
import cs5004.animator.model.transformation.dimension;
import cs5004.animator.util.AnimationBuilder;
import cs5004.animator.util.AnimationReader;

/**
 * Represents the canvas for the animation. Contains the initial shape objects and all
 * transformations that will be applied throughout the animation. Can return the state of all shape
 * objects at a given frame.
 */
public final class ICanvasModel implements ICanvas {
  private final LinkedHashMap<String, Shape> initialShapes;
  private final LinkedHashMap<String, Shape> dynamicShapes;
  private int leftMostX;
  private int topMostY;
  private int borderWidth;
  private int borderHeight;

  /** Constructor for a ICanvas that creates an empty list of transformations. */
  public ICanvasModel() {
    this.initialShapes = new LinkedHashMap<>();
    dynamicShapes = new LinkedHashMap<>();
  }

  @Override
  public void setAllFrames() {
    for (Shape s : this.initialShapes.values()) {
      s.setFrames();
    }
  }

  @Override
  public void setCanvasBounds(int leftMostX, int topMostY, int borderWidth, int borderHeight) {
    this.leftMostX = leftMostX;
    this.topMostY = topMostY;
    this.borderWidth = borderWidth;
    this.borderHeight = borderHeight;
  }

  @Override
  public String toString() {
    StringBuilder canvasStr = new StringBuilder();
    if (!this.initialShapes.isEmpty()) {
      canvasStr.append("Shapes:\n");
      initialShapes.forEach((k, v) -> canvasStr.append(v.toString() + "\n\n"));
    } else {
      canvasStr.append("No shapes in the animation.\n");
    }
    ArrayList<Transformation> transformations = new ArrayList<>();
    for (Shape shape : this.initialShapes.values()) {
      if (!shape.getTransformations().isEmpty()) {
        transformations.addAll(0, shape.getTransformations());
      }
    }
    if (!transformations.isEmpty()) {
      this.sortTransformations(transformations);
      canvasStr.append("Transformations:\n");
      transformations.forEach(transformation -> canvasStr.append(transformation.toString() + "\n"));
    } else {
      canvasStr.append("No transformations in the animation.\n");
    }
    return canvasStr.toString();
  }

  @Override
  public String toSVGString(float delay) {
    StringBuilder svgStr = new StringBuilder();
    svgStr.append(
        String.format(
            "<svg viewBox=\"%d %d %d %d\" xmlns=\"http://www.w3.org/2000/svg\">\n",
            this.leftMostX, this.topMostY, this.borderWidth, this.borderHeight));
    if (!this.initialShapes.isEmpty()) {
      this.initialShapes.forEach((k, v) -> svgStr.append(v.toSVGString(delay)));
    }
    svgStr.append("</svg>");

    return svgStr.toString();
  }

  @Override
  public void resetDynamicShapes() {
    for (String id : this.initialShapes.keySet()) {
      this.dynamicShapes.replace(id, this.initialShapes.get(id));
    }
  }

  @Override
  public ArrayList<Shape> getShapesAtFrame(float frame) {
    ArrayList<Shape> shapes = new ArrayList<>();
    for (String id : this.initialShapes.keySet()) {
      Shape initial = this.initialShapes.get(id);
      Shape s = this.dynamicShapes.get(id);

      for (Transformation t : initial.getTransformations()) {
        TransformationType type = t.getType();
        if (type == TransformationType.ChangeColor) {
          int[] newColor = (int[]) t.executeAtFrame(s, frame);
          s.setColor(newColor[0], newColor[1], newColor[2]);
        } else if (type == TransformationType.ChangeVis) {
          boolean vis = (boolean) t.executeAtFrame(s, frame);
          s.setVisibility(vis);
        } else if (type == TransformationType.Move) {
          float[] newPos = (float[]) t.executeAtFrame(s, frame);
          s.setPosition(newPos[0], newPos[1]);
        } else if (type == TransformationType.Resize) {
          float newValue = (float) t.executeAtFrame(s, frame);
          if (t.getDimension() == dimension.BASE) {
            s.resize(newValue, s.getHeight());
          } else {
            s.resize(s.getBase(), newValue);
          }
        }
      }
      shapes.add(s);
    }
    return shapes;
  }

  @Override
  public Shape getShapeById(String id) {
    return this.initialShapes.get(id);
  }

  @Override
  public void addShape(Shape shape) {
    this.initialShapes.put(shape.getIdentifier(), shape);
    this.dynamicShapes.put(shape.getIdentifier(), shape);
  }

  @Override
  public void removeShape(String id) {
    this.initialShapes.remove(id);
  }

  @Override
  public void addTransformation(String shapeID, Transformation transformation)
      throws IllegalArgumentException {
    Shape shape = this.initialShapes.get(shapeID);
    if (shape == null) {
      throw new IllegalArgumentException("Shape not found.");
    }
    shape.addTransformation(transformation);
  }

  /**
   * Sort the transformations in the list by their starting frame.
   *
   * @param transformations a list of transformations to sort.
   */
  private void sortTransformations(ArrayList<Transformation> transformations) {
    Comparator<Transformation> c = (o1, o2) -> (int) (o1.getStartFrame() - o2.getStartFrame());
    transformations.sort(c);
  }

  @Override
  public int getLeftMostX() {
    return leftMostX;
  }

  @Override
  public int getTopMostY() {
    return topMostY;
  }

  @Override
  public int getBorderWidth() {
    return borderWidth;
  }

  @Override
  public int getBorderHeight() {
    return borderHeight;
  }

  /** Class that builds a canvas object by reading from an input file. */
  public static final class Builder implements AnimationBuilder<ICanvas> {
    ICanvas c;

    /**
     * Constructor for the Builder class.
     *
     * @param inFile the input file to read from.
     * @throws FileNotFoundException if the file is not found.
     */
    public Builder(String inFile) throws FileNotFoundException {
      this.c = new ICanvasModel();
      Readable r = new FileReader(inFile);
      AnimationReader.parseFile(r, this);
    }

    /**
     * Retruns the ICanvas that was built.
     *
     * @return the ICanvas object.
     */
    public ICanvas getCanvas() {
      return this.c;
    }

    @Override
    public ICanvas build() throws FileNotFoundException {
      this.c.setAllFrames();
      return this.c;
    }

    @Override
    public AnimationBuilder<ICanvas> setBounds(int x, int y, int width, int height) {
      this.c.setCanvasBounds(x, y, width, height);
      return this;
    }

    @Override
    public AnimationBuilder<ICanvas> declareShape(String name, String type) {
      if (type.equals("rectangle")) {
        this.c.addShape(new Rectangle(name));
      } else if (type.equals("ellipse")) {
        this.c.addShape(new Oval(name));
      } // add other shapes here if needed
      return this;
    }

    @Override
    public AnimationBuilder<ICanvas> addMotion(
        String name,
        int t1,
        int x1,
        int y1,
        int w1,
        int h1,
        int r1,
        int g1,
        int b1,
        int t2,
        int x2,
        int y2,
        int w2,
        int h2,
        int r2,
        int g2,
        int b2) {
      Shape thisShape = this.c.getShapeById(name);
      if (!thisShape.isInitialized()) {
        thisShape.setPosition(x1, y1);
        thisShape.setColor(r1, g1, b1);
        thisShape.resize(w1, h1);
        thisShape.initialize();
      }

      Color c1 = new Color(r1, g1, b1);
      Color c2 = new Color(r2, g2, b2);
      if (!(c1.equals(c2))) {
        Transformation color = new ChangeColorT(thisShape, t1, t2, c1, c2);
        this.c.addTransformation(name, color);
      }
      if (!(x1 == x2 && y1 == y2)) {
        Transformation move =
            new MoveT(thisShape, t1, t2, new Point2D(x1, y1), new Point2D(x2, y2));
        this.c.addTransformation(name, move);
      }
      if (w1 != w2) {
        Transformation resizeBase = new ResizeT(thisShape, t1, t2, dimension.BASE, w1, w2);
        this.c.addTransformation(name, resizeBase);
      }
      if (h1 != h2) {
        Transformation resizeHeight = new ResizeT(thisShape, t1, t2, dimension.HEIGHT, h1, h2);
        this.c.addTransformation(name, resizeHeight);
      }
      return null;
    }
  }
}
