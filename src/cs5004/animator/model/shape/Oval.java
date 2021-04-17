package cs5004.animator.model.shape;

import java.awt.*;

/**
 * This class represents an cs5004.animator.controller.model.shape.Oval shape. An oval has a center,
 * base and height.
 */
public class Oval extends AbstractShape {

  /**
   * Constructor for an Oval. Note that the reference point for an Oval is the center.
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
  public Oval(String identifier, float x, float y, float base, float height, int r, int g, int b) {
    super(identifier, x, y, base, height, r, g, b);
  }

  /**
   * Constructor for an oval that creates an empty Oval object.
   *
   * @param name the identifier of the Oval.
   */
  public Oval(String name) {
    super(name);
  }

  @Override
  public String toString() {
    return super.toString("oval");
  }

  @Override
  public String toSVGString() {
    return super.toSVGString("ellipse");
  }

  @Override
  public void fill(Graphics2D g) {
    g.fillOval(
        (int) this.reference.getX(),
        (int) this.reference.getY(),
        (int) this.base,
        (int) this.height);
  }

  @Override
  public Shape copy() {
    float x = this.reference.getX();
    float y = this.reference.getY();
    return new Oval(
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
