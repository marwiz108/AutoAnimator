package model.shape;

import java.awt.Color;

/**
 * Abstract class for a Shape object that stores
 * common functionality for all shapes.
 */
public abstract class AbstractShape implements Shape {

  protected int base;
  protected int height;
  protected Point2D reference;
  Color color;

  public AbstractShape(int x, int y, int base, int height) {
    this.reference = new Point2D(x, y);
    this.base = base;
    this.height = height;
  }

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
    this.color = new Color(r, g, b);
  }

  @Override
  public void appear() {
    return;
  }

  @Override
  public void disappear() {
    return;
  }

  @Override
  public Shape copy() {
    return this;
  }
}
