public abstract class AbstractShape implements IShape {

  protected int base;
  protected int height;
  protected Point2D reference;
  Color color;

  @Override
  public Point2D getPosition() {
    return this.reference;
  }

  @Override
  public void setPosition(int x, int y) {
    this.reference = new Point2D(x, y);
  }

  @Override
  public IShape resize(int factor) {
    return this;
  }

  @Override
  public void setColor(int r, int g, int b) {
    return;
  }

  @Override
  public void appear() {
    return;
  }

  @Override
  public void disappear() {
    return;
  }
}
