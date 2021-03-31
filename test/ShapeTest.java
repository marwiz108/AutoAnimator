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
    this.oval = new Oval("oval", 500, 100, 60, 30, 255, 0, 0);
    this.rectangle = new Rectangle("rectangle", 200, 200, 50, 100, 0, 0, 255);
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
  }

  @Test
  public void testSetColor() {
  }

  @Test
  public void testCopy() {
    Shape ovalCopy = this.oval.copy();
    assertEquals(this.oval.getBase(), ovalCopy.getBase());
    assertEquals(this.oval.getHeight(), ovalCopy.getHeight());
    assertEquals(this.oval.getPosition(), ovalCopy.getPosition());
    assertEquals(this.oval.getColor(), ovalCopy.getColor());

    Shape rectangleCopy = this.rectangle.copy();
    assertEquals(this.rectangle.getBase(), rectangleCopy.getBase());
    assertEquals(this.rectangle.getHeight(), rectangleCopy.getHeight());
    assertEquals(this.rectangle.getPosition(), rectangleCopy.getPosition());
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

  @Test
  public void testSetVisibility() {

  }
}