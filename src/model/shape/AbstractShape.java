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

  public AbstractShape(String identifier, int x, int y, int base, int height, int r, int g, int b)
      throws IllegalArgumentException {
    if (base <=0 || height <= 0) {
      throw new IllegalArgumentException("Shape dimensions must be positive.");
    }
    this.identifier = identifier;
    this.reference = new Point2D(x, y);
    this.base = base;
    this.height = height;
    this.setColor(r, g, b);
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
  public void setColor(int r, int g, int b) throws IllegalArgumentException {
    if (r < 0 || r > 255 || g < 0 || g > 255 || b < 0 || b > 255) {
      throw new IllegalArgumentException("Invalid RGB values.");
    }
    this.color = new Color(r, g, b);
  }

  @Override
  public Shape resize(int newBase, int newHeight) throws IllegalArgumentException {
    if (newBase <= 0 || newHeight <= 0) {
      throw new IllegalArgumentException("Shape dimensions must be positive.");
    }
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

  protected String toString(String shapeType) {
    return String.format(
        "Name: %s\nType: %s\nPosition: %s, Base: %s, Height: %s\nColor: %s",
        this.identifier, shapeType, this.getPosition().toString(),
        this.base, this.height, this.colorToString()
    );
  }

  private String colorToString() {
    return String.format("(%s, %s, %s)",
        this.color.getRed(), this.color.getGreen(), this.color.getBlue());
  }

}
