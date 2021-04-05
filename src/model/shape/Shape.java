package model.shape;

import java.awt.*;
import java.util.ArrayList;
import model.transformation.Transformation;

/**
 * This interface represents a shape.
 * A Shape has a 2D reference point for it's position, a base and height.
 */
public interface Shape {

  /**
   * Returns the identifier for the shape.
   * @return the identifier.
   */
  String getIdentifier();

  /**
   * Returns the position of the shape.
   * @return x and y coordinates of shape position
   */
  Point2D getPosition();

  /**
   * Sets the position of the shape.
   */
  void setPosition(float x, float y);

  /**
   * Returns a copy of the shape with the same attributes.
   * @return new Shape copy of the shape
   */
  Shape copy();

  /**
   * Resizes the shape by the given factor.
   *
   * @param newBase   the new base of the Shape object.
   * @param newHeight the new height of the Shape object.
   * @return a copy of the shape resized by the factor
   */
  Shape resize(float newBase, float newHeight);

  /**
   * Get the base of the Shape.
   *
   * @return the base.
   */
  float getBase();

  /**
   * Get the height of the Shape.
   *
   * @return the height.
   */
  float getHeight();

  /**
   * Returns colour of the shape to an rgb value.
   */
  Color getColor();

  /**
   * Sets colour of the shape to an rgb value.
   *
   * @param r
   * @param g
   * @param b
   */
  void setColor(int r, int g, int b);

  /**
   * Returns whether the shape is visible on the canvas.
   * @return true if shape appears, false otherwise
   */
  boolean isVisible();

  /**
   * Sets the visibility attribute to true of false.
   * @param val true or false
   */
  void setVisibility(boolean val);

  /**
   * Adds a transformation to the list of transformations for the shape.
   * @param transformation the Transformation object to add
   */
  void addTransformation(Transformation transformation);

  /**
   * Returns the list of transformations for the shape.
   * @return list of Transformation objects
   */
  ArrayList getTransformations();

}
