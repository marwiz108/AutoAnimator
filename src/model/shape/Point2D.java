package model.shape;

/**
 * This class represents a 2D point. This stores the position as coordinates x and y.
 */
public class Point2D {

  private float x;
  private float y;

  public Point2D(float x, float y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public String toString() {
    return String.format("(%s, %s)", this.x, this.y);
  }

  public float getX() {
    return this.x;
  }

  public float getY() {
    return this.y;
  }

  public void updatePosition(float x, float y) {
    this.x = x;
    this.y = y;
  }

}
