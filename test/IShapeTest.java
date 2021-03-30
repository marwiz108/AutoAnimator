import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class IShapeTest {

  private IShape oval;
  private IShape rectangle;

  @Before
  public void setUp() throws Exception {
    this.oval = new Oval(500, 100, 60, 30);
    this.rectangle = new Rectangle(200, 200, 50, 100);
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