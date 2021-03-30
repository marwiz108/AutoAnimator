import org.junit.Before;
import org.junit.Test;

import model.shape.Shape;
import model.shape.Oval;
import model.shape.Rectangle;

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
  }

  @Test
  public void testSetPosition() {
  }

  @Test
  public void testResize() {
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