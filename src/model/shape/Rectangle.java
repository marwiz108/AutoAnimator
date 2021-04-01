package model.shape;

import org.w3c.dom.css.Rect;

/**
 * This class represents a model.shape.Rectangle shape.
 * A rectangle has a corner, base and height.
 */
public class Rectangle extends AbstractShape {

  // x and y position is the min. left corner
  public Rectangle(String identifier, int x, int y, int base, int height, int r, int g, int b) {
    super(identifier, x, y, base, height, r, g, b);
  }

  @Override
  public String toString() {
    return super.toString("rectangle");
  }

  @Override
  public Shape copy() {
    int x = this.reference.getX();
    int y = this.reference.getY();
    return new Rectangle(this.identifier, x, y, this.base, this.height,
            this.color.getRed(),
            this.color.getGreen(),
            this.color.getBlue());
  }

}
