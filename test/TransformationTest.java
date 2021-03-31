import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import model.shape.Point2D;
import model.shape.Rectangle;
import model.shape.Shape;
import model.transformation.ChangeColorT;
import model.transformation.ChangeVisibilityT;
import model.transformation.MoveT;
import model.transformation.ResizeT;
import model.transformation.Transformation;

public class TransformationTest {
  Transformation move;
  Transformation changeColor;
  Transformation changeVis;
  Transformation resize;

  @Before
  public void setUp() {
    Shape ref = new Rectangle(0, 0, 50, 30, 255, 0, 0);
    Point2D start = new Point2D(0, 0);
    Point2D end = new Point2D(100, 0);
    Color c1 = new Color(255, 0, 0);
    Color c2 = new Color(0, 0, 255);
    move = new MoveT(ref, 5, 15, start, end);
    changeColor = new ChangeColorT(ref, 5, 15, c1, c2);
    changeVis = new ChangeVisibilityT(ref, 5, 15);
    resize = new ResizeT(ref, 5, 15, ResizeT.Dimension.BASE,
            50, 75);
  }

  @Test
  public void testGetValueAtFrame() {
    // TODO Add tests for other frames
    int frame0 = move.getValueAtFrame(0, 0, 100);
    int frame5 = move.getValueAtFrame(5, 0, 100);
    int frame10 = move.getValueAtFrame(10, 0, 100);
    int frame15 = move.getValueAtFrame(15, 0, 100);
    int frame20 = move.getValueAtFrame(20, 0, 100);

    assertEquals(0, frame0);
    assertEquals(10, frame5);
    assertEquals(60, frame10);
    assertEquals(100, frame15);
    assertEquals(100, frame20);

    int yFrame0 = move.getValueAtFrame(0, 0, 0);
    int yFrame15 = move.getValueAtFrame(20, 0, 0);

    assertEquals(0, yFrame0);
    assertEquals(0, yFrame15);
  }

  @Test
  public void testExecuteAtFrameColor() {
    changeColor.executeAtFrame(0);

  }

  @Test
  public void testExecuteAtFrameVis() {
  }

  @Test
  public void testExecuteAtFrameMove() {
  }

  @Test
  public void testExecuteAtFrameResize() {
  }
}