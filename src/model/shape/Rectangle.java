package model.shape;

/**
 * This class represents a model.shape.Rectangle shape.
 * A rectangle has a corner, base and height.
 */
public class Rectangle extends AbstractShape {

  // x and y position is the top left corner
  public Rectangle(String identifier, float x, float y, float base, float height,
                   int r, int g, int b) {
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
    return new Rectangle(this.identifier, x, y, this.base, this.height,
            this.color.getRed(),
            this.color.getGreen(),
            this.color.getBlue());
  }

}
