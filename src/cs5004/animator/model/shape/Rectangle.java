package cs5004.animator.model.shape;

/**
 * This class represents a cs5004.animator.controller.model.shape.Rectangle shape. A rectangle has a
 * corner, base and height.
 */
public class Rectangle extends AbstractShape {

  /**
   * Constructor for a Rectangle. Note that the reference point for a Rectangle is the top left
   * corner.
   *
   * @param identifier the identifier used to reference this shape.
   * @param x the x-coordinate of the reference point of this shape.
   * @param y the y-coordinate of the reference point of this shape.
   * @param base the magnitude of the base of this shape.
   * @param height the magnitude of the height of this shape.
   * @param r the red value of this shape (0 - 255).
   * @param g the green value of this shape (0 - 255).
   * @param b the blue value of this shape (0 - 255).
   */
  public Rectangle(
          String identifier, float x, float y, float base, float height, int r, int g, int b) {
    super(identifier, x, y, base, height, r, g, b);
  }

  @Override
  public String toString() {
    return super.toString("rectangle");
  }

  @Override
  public Shape copy() {
    float x = this.reference.getX();
    float y = this.reference.getY();
    return new Rectangle(
            this.identifier,
            x,
            y,
            this.base,
            this.height,
            this.color.getRed(),
            this.color.getGreen(),
            this.color.getBlue());
  }
}
