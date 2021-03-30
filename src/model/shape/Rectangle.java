package model.shape;

/**
 * This class represents a model.shape.Rectangle shape.
 * A rectangle has a corner, base and height.
 */
public class Rectangle extends AbstractShape {

  public Rectangle(int x, int y, int base, int height, int r, int g, int b) {
    super(x, y, base, height, r, g, b);
  }

  @Override
  public Shape resize(int factor) {
    return this;
  }

}
