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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
    float frame0 = move.getValueAtFrame(0, 0, 100);
    float frame5 = move.getValueAtFrame(5, 0, 100);
    float frame10 = move.getValueAtFrame(10, 0, 100);
    float frame15 = move.getValueAtFrame(15, 0, 100);
    float frame20 = move.getValueAtFrame(20, 0, 100);

    assertEquals(0, frame0, 0);
    assertEquals(10, frame5, 0);
    assertEquals(60, frame10, 0);
    assertEquals(100, frame15, 0);
    assertEquals(100, frame20, 0);

    float yFrame0 = move.getValueAtFrame(0, 0, 0);
    float yFrame15 = move.getValueAtFrame(20, 0, 0);

    assertEquals(0, yFrame0, 0);
    assertEquals(0, yFrame15, 0);
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
    assertEquals("Shape rectangle moves from (0.0, 0.0) " +
            "to (100.0, 0.0) from t=5 to t=15", move.toString());
  }

  @Test
  public void testToStringResize() {
    assertEquals("Shape rectangle Scales from Base: 50.0, Height: 30.0 " +
            "to Base: 75.0, Height: 30.0 from t=5 to t=15", resize.toString());
  }

  @Test
  public void testExecuteAtFrameColor() {
    int[] cAt0 = (int[]) this.changeColor.executeAtFrame(0);
    int[] cAt5 = (int[]) this.changeColor.executeAtFrame(5);
    int[] cAt10 = (int[]) this.changeColor.executeAtFrame(10);
    int[] cAt15 = (int[]) this.changeColor.executeAtFrame(15);
    int[] cAt20 = (int[]) this.changeColor.executeAtFrame(20);

    assertEquals(255, cAt0[0]);
    assertEquals(0, cAt0[1]);
    assertEquals(0, cAt0[2]);

    assertEquals(229, cAt5[0]);
    assertEquals(0, cAt5[1]);
    assertEquals(25, cAt5[2]);

    assertEquals(102, cAt10[0]);
    assertEquals(0, cAt10[1]);
    assertEquals(153, cAt10[2]);

    assertEquals(0, cAt15[0]);
    assertEquals(0, cAt15[1]);
    assertEquals(255, cAt15[2]);

    assertEquals(0, cAt20[0]);
    assertEquals(0, cAt20[1]);
    assertEquals(255, cAt20[2]);

  }

  @Test
  public void testExecuteAtFrameVis() {
    assertFalse((Boolean) changeVis.executeAtFrame(0));
    assertTrue((Boolean) changeVis.executeAtFrame(5));
    assertTrue((Boolean) changeVis.executeAtFrame(14));
    assertFalse((Boolean) changeVis.executeAtFrame(15));
    assertFalse((Boolean) changeVis.executeAtFrame(20));
  }
//
//  @Test
//  public void testExecuteAtFrameMove() {
//    assertEquals("(0.0, 0.0)", move.executeAtFrame(0).getPosition().toString());
//    assertEquals("(10.0, 0.0)", move.executeAtFrame(5).getPosition().toString());
//    assertEquals("(60.0, 0.0)", move.executeAtFrame(10).getPosition().toString());
//    assertEquals("(100.0, 0.0)", move.executeAtFrame(15).getPosition().toString());
//    assertEquals("(100.0, 0.0)", move.executeAtFrame(20).getPosition().toString());
//  }
//
//  @Test
//  public void testExecuteAtFrameResize() {
//    assertEquals(50, resize.executeAtFrame(0).getBase(), 0);
//    assertEquals(30, resize.executeAtFrame(0).getHeight(), 0);
//
//    assertEquals(52, resize.executeAtFrame(5).getBase(), 0);
//    assertEquals(30, resize.executeAtFrame(5).getHeight(), 0);
//
//    assertEquals(65, resize.executeAtFrame(10).getBase(), 0);
//    assertEquals(30, resize.executeAtFrame(10).getHeight(), 0);
//
//    assertEquals(75, resize.executeAtFrame(15).getBase(), 0);
//    assertEquals(30, resize.executeAtFrame(15).getHeight(), 0);
//
//    assertEquals(75, resize.executeAtFrame(20).getBase(), 0);
//    assertEquals(30, resize.executeAtFrame(20).getHeight(), 0);
//  }
}