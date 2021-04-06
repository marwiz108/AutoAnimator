package model.shape;

/**
 * This class represents a 2D point. This stores the position as coordinates x and y.
 */
public class Point2D {

  private float x;
  private float y;

  /**
   * Constructor for a Point2D.
   *
   * @param x the x-coordinate of the Point2D.
   * @param y the y-coordinate of the Point2D.
   */
  public Point2D(float x, float y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public String toString() {
    return String.format("(%s, %s)", this.x, this.y);
  }

  /**
   * Return the x-coordinate of the Point2D.
   *
   * @return the x-coordinate.
   */
  public float getX() {
    return this.x;
  }

  /**
   * Return the y-coordinate of the Point2D.
   *
   * @return the y-coordinate.
   */
  public float getY() {
    return this.y;
  }

  /**
   * Update the position of the Point2D.
   *
   * @param x new x-coordinate.
   * @param y new y-coordinate.
   */
  public void updatePosition(float x, float y) {
    this.x = x;
    this.y = y;
  }
}
