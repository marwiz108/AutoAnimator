package model.shape;

/**
 * This class represents an model.shape.Oval shape.
 * An oval has a center, base and height.
 */
public class Oval extends AbstractShape {

  // x and y position is the center of the oval
  public Oval(String identifier, float x, float y, float base, float height, int r, int g, int b) {
    super(identifier, x, y, base, height, r, g, b);
  }

  @Override
  public String toString() {
    return super.toString("oval");
  }

  @Override
  public Shape copy() {
    float x = this.reference.getX();
    float y = this.reference.getY();
    return new Oval(this.identifier, x, y, this.base, this.height,
            this.color.getRed(),
            this.color.getGreen(),
            this.color.getBlue());
  }

}
