import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.shape.Point2D;
import model.shape.Rectangle;
import model.shape.Shape;
import model.transformation.MoveT;
import model.transformation.Transformation;

public class TransformationTest {
  Transformation move;

  @Before
  public void setUp() {
    Shape ref = new Rectangle("rectangle", 0, 0, 50, 30, 255, 0, 0);
    Point2D start = new Point2D(0, 0);
    Point2D end = new Point2D(100, 0);
    move = new MoveT(ref, 5, 15, start, end);
  }

  @Test
  public void testGetValueAtFrame() {
    // TODO Add tests for other frames
    int frame15 = move.getValueAtFrame(15, 0, 100);
    assertEquals(100, frame15);
  }

  @Test
  public void executeAtFrame() {
  }
}