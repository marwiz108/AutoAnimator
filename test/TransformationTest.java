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
  Shape ref;
  Transformation move;
  Transformation changeColor;
  Transformation changeVis;
  Transformation resize;

  @Before
  public void setUp() {
    ref = new Rectangle("rectangle", 0, 0, 50,
            30, 255, 0, 0);
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

  @Test (expected = IllegalArgumentException.class)
  public void testGetValueAtFrameInvalid() {
    move.getValueAtFrame(-1,
            0, 100);
  }

  @Test
  public void testToStringColor() {
    assertEquals("Shape rectangle changes color from (255, 0, 0) " +
            "to (0, 0, 255) from t=5 to t=15", changeColor.toString());
  }

  @Test
  public void testToStringVis() {
    assertEquals("Shape rectangle appears at t=5 and disappears at t=15",
            changeVis.toString());
  }

  @Test
  public void testToStringMove() {
    assertEquals("Shape rectangle moves from (0, 0) " +
            "to (100, 0) from t=5 to t=15", move.toString());
  }

  @Test
  public void testToStringResize() {
    assertEquals("Shape rectangle Scales from Base: 50, Height: 30 " +
            "to Base: 75, Height: 30 from t=5 to t=15", resize.toString());
  }

  @Test
  public void testExecuteAtFrameColor() {
    assertEquals("java.awt.Color[r=255,g=0,b=0]",
            changeColor.executeAtFrame(0).getColor().toString());
    assertEquals("java.awt.Color[r=0,g=0,b=255]",
            changeColor.executeAtFrame(15).getColor().toString());

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