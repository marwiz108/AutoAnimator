package model.shape;

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
   */
  Shape resize(int factor);

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
