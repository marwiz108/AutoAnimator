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

  /**
   * Constructor that is used to create an abstract shape. Is called by children of the
   * AbstractShape class.
   * @param identifier The identifier that is used to find the Shape.
   * @param x the x coordinate of the reference point.
   * @param y the y coordinate of the reference point.
   * @param base the magnitude of the base of the shape.
   * @param height the magnitude of the height of the shape.
   * @param r the red value of the shape's color (0 <= r <= 255)
   * @param g the green value of the shape's color (0 <= g <= 255)
   * @param b the blue value of the shape's color (0 <= b <= 255)
   * @throws IllegalArgumentException if the base or height is negative, or if r, g, b are outside
   * the allowed range.
   */
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
    if (base <= 0 || height <= 0) {
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

  @Override
  public String toString(String shapeType) {
    return String.format(
        "Name: %s\nType: %s\nPosition: %s, Width: %s, Height: %s\nColor: %s",
        this.identifier, shapeType, this.getPosition().toString(),
        this.base, this.height, this.colorToString()
    );
  }

  private String colorToString() {
    return String.format("(%s, %s, %s)",
        this.color.getRed(), this.color.getGreen(), this.color.getBlue());
  }

}
