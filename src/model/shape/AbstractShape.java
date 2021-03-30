package model.shape;

public abstract class AbstractShape implements Shape {

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
    this.reference.updatePosition(x, y);
  }

  @Override
  public Shape resize(int factor) {
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
