/**
 * This class represents a Rectangle shape.
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

}
