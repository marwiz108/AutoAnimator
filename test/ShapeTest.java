import org.junit.Before;
import org.junit.Test;

import model.shape.Shape;
import model.shape.Oval;
import model.shape.Rectangle;

import static org.junit.Assert.assertEquals;

/**
 * JUnit test class for the Shape interface.
 */
public class ShapeTest {

  private Shape oval;
  private Shape rectangle;

  @Before
  public void setUp() {
    this.oval = new Oval("o",
                      500, 100, 60, 30,
                      255, 0, 0
    );
    this.rectangle = new Rectangle("r",
                      200, 200, 50, 100,
                      0, 0, 255
    );
  }

  @Test (expected = IllegalArgumentException.class)
  public void testConstructorWithInvalidBase() {
    Shape newOval = new Oval("oval", 100, 50,
        0, 50, 0, 0, 255);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testConstructorWithInvalidHeight() {
    Shape newRect = new Rectangle("rectangle", 80, 260,
        5, -3, 0, 0, 255);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testConstructorWithInvalidColorR() {
    Shape newOval = new Oval("oval", 100, 50,
        50, 20, 321, 0, 255);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testConstructorWithInvalidColorG() {
    Shape newRect = new Rectangle("rectangle", 80, 260,
        5, 12, 0, -4, 255);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testConstructorWithInvalidColorB() {
    Shape newRect = new Rectangle("rectangle", 80, 260,
        5, 12, 0, 72, 256);
  }

  @Test
  public void testGetPosition() {
    assertEquals(500, this.oval.getPosition().getX());
    assertEquals(100, this.oval.getPosition().getY());

    assertEquals(200, this.rectangle.getPosition().getY());
    assertEquals(200, this.rectangle.getPosition().getY());
  }

  @Test
  public void testSetPosition() {
    this.oval.setPosition(320, 100);
    assertEquals(320, this.oval.getPosition().getX());
    assertEquals(100, this.oval.getPosition().getY());

    this.rectangle.setPosition(250, 150);
    assertEquals(250, this.rectangle.getPosition().getX());
    assertEquals(150, this.rectangle.getPosition().getY());
  }

  @Test
  public void getBase() {
    assertEquals(60, this.oval.getBase());
    assertEquals(50, this.rectangle.getBase());
  }

  @Test
  public void getHeight() {
    assertEquals(30, this.oval.getHeight());
    assertEquals(100, this.rectangle.getHeight());
  }

  @Test
  public void testGetColour() {
    assertEquals(255, this.oval.getColor().getRed());
    assertEquals(0, this.oval.getColor().getGreen());
    assertEquals(0, this.oval.getColor().getBlue());

    assertEquals(0, this.rectangle.getColor().getRed());
    assertEquals(0, this.rectangle.getColor().getGreen());
    assertEquals(255, this.rectangle.getColor().getBlue());
  }

  @Test
  public void testSetColor() {
    this.oval.setColor(255, 178, 102);
    assertEquals(255, this.oval.getColor().getRed());
    assertEquals(178, this.oval.getColor().getGreen());
    assertEquals(102, this.oval.getColor().getBlue());

    this.rectangle.setColor(51, 153, 255);
    assertEquals(51, this.rectangle.getColor().getRed());
    assertEquals(153, this.rectangle.getColor().getGreen());
    assertEquals(255, this.rectangle.getColor().getBlue());
  }

  @Test
  public void testCopy() {
    Shape ovalCopy = this.oval.copy();
    assertEquals(this.oval.getBase(), ovalCopy.getBase());
    assertEquals(this.oval.getHeight(), ovalCopy.getHeight());
    assertEquals(this.oval.getPosition().toString(), ovalCopy.getPosition().toString());
    assertEquals(this.oval.getColor(), ovalCopy.getColor());

    Shape rectangleCopy = this.rectangle.copy();
    assertEquals(this.rectangle.getBase(), rectangleCopy.getBase());
    assertEquals(this.rectangle.getHeight(), rectangleCopy.getHeight());
    assertEquals(this.rectangle.getPosition().toString(), rectangleCopy.getPosition().toString());
    assertEquals(this.rectangle.getColor(), rectangleCopy.getColor());
  }

  @Test
  public void testResize() {
    this.oval.resize(90, 60);
    assertEquals(90, this.oval.getBase());
    assertEquals(60, this.oval.getHeight());

    this.rectangle.resize(180, 80);
    assertEquals(180, this.rectangle.getBase());
    assertEquals(80, this.rectangle.getHeight());
  }

  @Test (expected = IllegalArgumentException.class)
  public void testResizeWithInvalidBase() {
    this.oval.resize(-10, 30);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testResizeWithInvalidHeight() {
    this.rectangle.resize(50, 0);
  }

  @Test
  public void testSetVisibility() {
    assertEquals(false, this.oval.isVisible());
    this.oval.setVisibility(true);
    assertEquals(true, this.oval.isVisible());
    this.oval.setVisibility(false);
    assertEquals(false, this.oval.isVisible());
  }
}