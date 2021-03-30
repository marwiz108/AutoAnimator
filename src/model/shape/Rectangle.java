package model.shape;

/**
 * This class represents a model.shape.Rectangle shape.
 * A rectangle has a corner, base and height.
 */
public class Rectangle extends AbstractShape {

  private Point2D corner;
  private int base;
  private int height;

  public Rectangle(int x, int y, int base, int height) {
    this.corner = new Point2D(x, y);
    this.base = base;
    this.height = height;
  }

  @Override
  public Shape resize(int factor) {
    return this;
  }

}
