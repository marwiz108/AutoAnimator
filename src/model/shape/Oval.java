package model.shape;

/**
 * This class represents an model.shape.Oval shape.
 * An oval has a center, base and height.
 */
public class Oval extends AbstractShape {

  public Oval(int x, int y, int base, int height, int r, int g, int b) {
    super(x, y, base, height, r, g, b);
  }

  @Override
  public Shape resize(int factor) {
    return this;
  }

}
