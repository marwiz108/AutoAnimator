package model.canvas;

import java.util.ArrayList;
import java.util.HashMap;

import model.shape.Shape;
import model.transformation.Transformation;

/**
 * Represents the canvas for the animation. Contains the initial shape objects and all
 * all transformations that will be applied throughout the animation. Can return the state of
 * all shape objects at a given frame.
 */
public class Canvas {
  private HashMap<String, Shape> initialShapes;
  private ArrayList<Transformation> transformations;

  /**
   * Get the state of all shapes at a given frame.
   * @param frame the frame that will eventually be rendered in the view.
   * @return A list of all shape objects to be rendered in the frame.
   */
  public ArrayList<Shape> getShapesAtFrame(int frame) {
    return null;
  }
}
