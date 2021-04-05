package model.canvas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

import model.shape.Shape;
import model.transformation.Transformation;

/**
 * Represents the canvas for the animation. Contains the initial shape objects and all
 * all transformations that will be applied throughout the animation. Can return the state of
 * all shape objects at a given frame.
 */
public class Canvas {
  private final HashMap<String, Shape> initialShapes;
  private final ArrayList<Transformation> transformations;

  public Canvas() {
    this.initialShapes = new HashMap<>();
    this.transformations = new ArrayList<>();
  }

  /**
   * Adds a Shape object and its identifier to the map of initial shapes.
   * @param key string identifier/name of the shape
   * @param shape the Shape object
   */
  public void addShape(String key, Shape shape) {
    this.initialShapes.put(key, shape);
  }

  /**
   * Adds a Transformation object to the list of transformations.
   * @param transformation the Transformation object
   */
  public void addTransformation(Transformation transformation) {
    this.transformations.add(transformation);
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
    canvasStr.append("Shapes:\n");
    initialShapes.forEach((k, v) -> canvasStr.append(v.toString() + "\n\n"));
    transformations.forEach(transformation -> canvasStr.append(transformation.toString() + "\n"));
    return canvasStr.toString();
  }

  /**
   * Sort the transformations in the list by their starting frame.
   */
  private void sortTransformations() {
    Comparator<Transformation> c = (o1, o2) -> o1.getStartFrame() - o2.getStartFrame();
    this.transformations.sort(c);
  }
}
