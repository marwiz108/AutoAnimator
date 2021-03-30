package model.shape;

/**
 * This class represents an model.shape.Oval shape.
 * An oval has a center, base and height.
 */
public class Oval extends AbstractShape {

  public Oval(int x, int y, int base, int height) {
    super(x, y, base, height);
  }

  @Override
  public Shape resize(int factor) {
    return this;
  }

}
