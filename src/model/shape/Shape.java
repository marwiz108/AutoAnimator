package model.shape;

import java.awt.*;

/**
 * This interface represents a shape.
 * A Shape has a 2D reference point for it's position, a base and height.
 */
public interface Shape {

  /**
   * Returns the position of the shape.
   * @return x and y coordinates of shape position
   */
  Point2D getPosition();

  /**
   * Sets the position of the shape.
   */
  void setPosition(int x, int y);

  /**
   * Returns a copy of the shape with the same attributes.
   * @return new Shape copy of the shape
   */
  Shape copy();

  /**
   * Resizes the shape by the given factor.
   * @return a copy of the shape resized by the factor
   * @param newBase the new base of the Shape object.
   * @param newHeight the new height of the Shape object.
   */
  Shape resize(int newBase, int newHeight);

  /**
   * Get the base of the Shape.
   * @return the base.
   */
  int getBase();

  /**
   * Get the height of the Shape.
   * @return the height.
   */
  int getHeight();

  /**
   * Returns colour of the shape to an rgb value.
   */
  Color getColor();

  /**
   * Sets colour of the shape to an rgb value.
   */
  void setColor(int r, int g, int b);

  /**
   * Makes shape visible on the screen.
   */
  void appear();

  /**
   * Removes shape from screen.
   */
  void disappear();

}
