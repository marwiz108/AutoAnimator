package cs5004.animator.model.canvas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;

import cs5004.animator.model.shape.Shape;
import cs5004.animator.model.transformation.Transformation;

/**
 * Represents the canvas for the animation. Contains the initial shape objects and all
 * transformations that will be applied throughout the animation. Can return the state of all shape
 * objects at a given frame.
 */
public class CanvasModel implements Canvas {
  private final LinkedHashMap<String, Shape> initialShapes;

  /**
   * Constructor for a Canvas that creates an empty list of transformations.
   */
  public CanvasModel() {
    this.initialShapes = new LinkedHashMap<>();
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
  public ArrayList<Shape> getShapesAtFrame(int frame) {
    return null;
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
    Comparator<Transformation> c = (o1, o2) -> o1.getStartFrame() - o2.getStartFrame();
    transformations.sort(c);
  }
}
