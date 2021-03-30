package model.shape;

/**
 * This class represents a 2D point.
 * This stores the position as coordinates x and y.
 */
public class Point2D {

  private int x;
  private int y;

  public Point2D(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return this.x;
  }

  public int getY() {
    return this.y;
  }

  public void updatePosition(int x, int y) {
    this.x = x;
    this.y = y;
  }

}
