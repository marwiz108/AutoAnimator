package model.shape;

/**
 * This class represents an model.shape.Oval shape.
 * An oval has a center, base and height.
 */
public class Oval extends AbstractShape {

  public Oval(String identifier, int x, int y, int base, int height, int r, int g, int b) {
    super(identifier, x, y, base, height, r, g, b);
  }

  @Override
  public Shape copy() {
    int x = this.reference.getX();
    int y = this.reference.getY();
    return new Oval(this.identifier, x, y, this.base, this.height,
            this.color.getRed(),
            this.color.getGreen(),
            this.color.getBlue());
  }

}
