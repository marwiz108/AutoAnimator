/**
 * This class represents an Oval shape.
 * An oval has a center, base and height.
 */
public class Oval extends AbstractShape {

  private Point2D center;
  private int base;
  private int height;

  public Oval(int x, int y, int base, int height) {
    this.center = new Point2D(x, y);
    this.base = base;
    this.height = height;
  }

  @Override
  public IShape resize(int factor) {
    return this;
  }

}
