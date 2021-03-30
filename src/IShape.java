/**
 * This interface represents a shape.
 * TODO
 */
public interface IShape {

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
   * Resizes the shape by the given factor.
   * @return a copy of the shape resized by the factor
   */
  IShape resize(int factor);

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
