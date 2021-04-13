package cs5004.animator.model.canvas;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;

import cs5004.animator.model.shape.Oval;
import cs5004.animator.model.shape.Rectangle;
import cs5004.animator.model.shape.Shape;
import cs5004.animator.model.transformation.Transformation;
import cs5004.animator.model.transformation.TransformationType;
import cs5004.animator.model.transformation.dimension;
import cs5004.animator.util.AnimationBuilder;

/**
 * Represents the canvas for the animation. Contains the initial shape objects and all
 * transformations that will be applied throughout the animation. Can return the state of all shape
 * objects at a given frame.
 */
public final class ICanvasModel implements ICanvas {
  private final LinkedHashMap<String, Shape> initialShapes;
  private int leftMostX;
  private int topMostY;
  private int borderWidth;
  private int borderHeight;

  /** Constructor for a ICanvas that creates an empty list of transformations. */
  public ICanvasModel() {
    this.initialShapes = new LinkedHashMap<>();
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
  public ArrayList<Shape> getShapesAtFrame(float frame) {
    // TODO Implement getShapesAtFrame method
    ArrayList<Shape> shapes = new ArrayList<>();
    for (Shape initial : this.initialShapes.values()) {
      Shape s = initial.copy();
      for (Transformation t : initial.getTransformations()) {
        TransformationType type = t.getType();
        if (type == TransformationType.ChangeColor) {
          int[] newColor = (int[]) t.executeAtFrame(frame);
          s.setColor(newColor[0], newColor[1], newColor[2]);
        } else if (type == TransformationType.ChangeVis) {
          boolean vis = (boolean) t.executeAtFrame(frame);
          s.setVisibility(vis);
        } else if (type == TransformationType.Move) {
          float[] newPos = (float[]) t.executeAtFrame(frame);
          s.setPosition(newPos[0], newPos[1]);
        } else if (type == TransformationType.Resize) {
          float newValue = (float) t.executeAtFrame(frame);
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
  public void addShape(Shape shape) {
    this.initialShapes.put(shape.getIdentifier(), shape);
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

  public static final class Builder implements AnimationBuilder<ICanvas> {
    ICanvas c = new ICanvasModel();

    @Override
    public ICanvas build() throws FileNotFoundException {
      return null;
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
      return null;
    }
  }
}
