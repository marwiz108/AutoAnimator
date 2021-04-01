package model.shape;

import java.awt.Color;

/**
 * Abstract class for a Shape object that stores
 * common functionality for all shapes.
 */
public abstract class AbstractShape implements Shape {

  protected final String identifier;
  protected int base;
  protected int height;
  protected Point2D reference;
  Color color;
  boolean visible;

  public AbstractShape(String identifier, int x, int y, int base, int height, int r, int g, int b) {
    this.identifier = identifier;
    this.reference = new Point2D(x, y);
    this.base = base;
    this.height = height;
    this.color = new Color(r, g, b);
    this.visible = false;
  }

  @Override
  public String getIdentifier() { return this.identifier; }

  @Override
  public Point2D getPosition() {
    return this.reference;
  }

  @Override
  public void setPosition(int x, int y) {
    this.reference.updatePosition(x, y);
  }

  @Override
  public int getBase() {
    return this.base;
  }

  @Override
  public int getHeight() {
    return this.height;
  }

  @Override
  public Color getColor() {
    return this.color;
  }

  @Override
  public void setColor(int r, int g, int b) {
    this.color = new Color(r, g, b);
  }

  @Override
  public Shape resize(int newBase, int newHeight) {
    this.base = newBase;
    this.height = newHeight;
    return this;
  }

  @Override
  public boolean isVisible() {
    return this.visible;
  }

  @Override
  public void setVisibility(boolean val) {
    this.visible = val;
  }

  @Override
  public String toString() {
    return "";
  }

  private String colorToString() {
    return String.format("(%s, %s, %s)",
        this.color.getRed(), this.color.getGreen(), this.color.getBlue());
  }

}
