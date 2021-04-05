package model.canvas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;

import model.shape.Shape;
import model.transformation.Transformation;

/**
 * Represents the canvas for the animation. Contains the initial shape objects and all
 * all transformations that will be applied throughout the animation. Can return the state of
 * all shape objects at a given frame.
 */
public class Canvas {
  private final LinkedHashMap<String, Shape> initialShapes;

  public Canvas() {
    this.initialShapes = new LinkedHashMap<>();
  }

  /**
   * Adds a Shape object with its identifier as a key to the map of initial shapes.
   *
   * @param shape the Shape object
   */
  public void addShape(Shape shape) {
    this.initialShapes.put(shape.getIdentifier(), shape);
  }

  /**
   * Remove a Shape by id.
   *
   * @param id the identifier of the Shape to be removed.
   */
  public void removeShape(String id) {
    this.initialShapes.remove(id);
  }

  /**
   * Adds a Transformation object to the list of transformations, then sorts the list so all
   * transformations are order of starting frame.
   *
   * @param shapeID the identifier of the shape
   * @param transformation the Transformation object
   */
  public void addTransformation(String shapeID, Transformation transformation) {
    Shape shape = this.initialShapes.get(shapeID);
    shape.addTransformation(transformation);
  }

  /**
   * Get the state of all shapes at a given frame.
   * @param frame the frame that will eventually be rendered in the view.
   * @return A list of all shape objects to be rendered in the frame.
   */
  public ArrayList<Shape> getShapesAtFrame(int frame) {
    return null;
  }

  /**
   * Returns a text description of the shapes and their transformations.
   * @return string representation of each shape and the transformations
   */
  public String toString() {
    StringBuilder canvasStr = new StringBuilder();
    if (!this.initialShapes.isEmpty()) {
      canvasStr.append("Shapes:\n");
      initialShapes.forEach((k, v) -> canvasStr.append(v.toString() + "\n\n"));
    } else {
      canvasStr.append("No shapes in the animation.\n");
    }

    ArrayList<Transformation> transformations = new ArrayList<>();
    for (Shape shape:this.initialShapes.values()) {
      if (!shape.getTransformations().isEmpty()) {
        transformations.addAll(0,shape.getTransformations());
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

  /**
   * Sort the transformations in the list by their starting frame.
   */
  private void sortTransformations(ArrayList transformations) {
    Comparator<Transformation> c = (o1, o2) -> o1.getStartFrame() - o2.getStartFrame();
    transformations.sort(c);
  }
}
