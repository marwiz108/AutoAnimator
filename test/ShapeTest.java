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
    this.oval = new Oval(500, 100, 60, 30, 255, 0, 0);
    this.rectangle = new Rectangle(200, 200, 50, 100, 0, 0, 255);
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
    this.rectangle.setPosition(250, 150);
    assertEquals(250, this.rectangle.getPosition().getX());
    assertEquals(150, this.rectangle.getPosition().getY());
  }

  @Test
  public void testResize() {
    this.oval.resize(90, 60);
    assertEquals(90, this.oval.getBase());
    assertEquals(60, this.oval.getHeight());
  }

  @Test
  public void testSetColor() {
  }

  @Test
  public void testAppear() {
  }

  @Test
  public void testDisappear() {
  }
}