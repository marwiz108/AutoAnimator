import org.junit.Before;
import org.junit.Test;

import java.awt.Color;
import java.util.Arrays;

import cs5004.animator.model.shape.Point2D;
import cs5004.animator.model.shape.Rectangle;
import cs5004.animator.model.shape.Shape;
import cs5004.animator.model.transformation.ChangeColorT;
import cs5004.animator.model.transformation.ChangeVisibilityT;
import cs5004.animator.model.transformation.MoveT;
import cs5004.animator.model.transformation.ResizeT;
import cs5004.animator.model.transformation.Transformation;

import static cs5004.animator.model.transformation.dimension.BASE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/** Tests for the Transformation interface. */
public class TransformationTest {
  Shape ref;
  Transformation move;
  Transformation changeColor;
  Transformation changeVis;
  Transformation resize;

  @Before
  public void setUp() {
    ref = new Rectangle("rectangle", 0, 0, 50, 30, 255, 0, 0);
    Point2D start = new Point2D(0, 0);
    Point2D end = new Point2D(100, 0);
    Color c1 = new Color(255, 0, 0);
    Color c2 = new Color(0, 0, 255);

    move = new MoveT(ref, 5, 15, start, end);
    changeColor = new ChangeColorT(ref, 5, 15, c1, c2);
    changeVis = new ChangeVisibilityT(ref, 5, 15);
    resize = new ResizeT(ref, 5, 15, BASE, 50, 75);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalid1() {
    Transformation tmp = new ChangeVisibilityT(null, 0, 10);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalid2() {
    Transformation tmp = new ChangeVisibilityT(ref, 0, -10);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalid3() {
    Transformation tmp = new ChangeVisibilityT(ref, -1, 10);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalid4() {
    Transformation tmp = new ChangeVisibilityT(ref, 10, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalid5() {
    Transformation tmp = new ChangeVisibilityT(ref, 1, 1);
  }

  @Test
  public void testGetValueAtFrame() {
    float frame0 = move.getValueAtFrame(0, 0, 100);
    float frame5 = move.getValueAtFrame(5, 0, 100);
    float frame10 = move.getValueAtFrame(10, 0, 100);
    float frame15 = move.getValueAtFrame(15, 0, 100);
    float frame20 = move.getValueAtFrame(20, 0, 100);
    //    System.out.println(move.getValueAtFrame(F, 0, 100));
    assertEquals(0, frame0, 0);
    assertEquals(0, frame5, 0);
    assertEquals(50, frame10, 0);
    assertEquals(100, frame15, 0);
    assertEquals(100, frame20, 0);

    float yFrame0 = move.getValueAtFrame(0, 0, 0);
    float yFrame15 = move.getValueAtFrame(20, 0, 0);

    assertEquals(0, yFrame0, 0);
    assertEquals(0, yFrame15, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGetValueAtFrameInvalid() {
    move.getValueAtFrame(-1, 0, 100);
  }

  @Test
  public void testToStringColor() {
    assertEquals(
        "Shape rectangle changes color from (255, 0, 0) " + "to (0, 0, 255) from t=5.00 to t=15.00",
        changeColor.toString());
  }

  @Test
  public void testToStringVis() {
    assertEquals(
        "Shape rectangle appears at t=5.00 and disappears at t=15.00", changeVis.toString());
  }

  @Test
  public void testToStringMove() {
    assertEquals(
        "Shape rectangle moves from (0.0, 0.0) " + "to (100.0, 0.0) " + "from t=5.00 to t=15.00",
        move.toString());
  }

  @Test
  public void testToStringResize() {
    assertEquals(
        "Shape rectangle Scales from Base: 50.0, Height: 30.0 "
            + "to Base: 75.0, Height: 30.0 from t=5.00 to t=15.00",
        resize.toString());
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

    assertEquals(255, cAt5[0]);
    assertEquals(0, cAt5[1]);
    assertEquals(0, cAt5[2]);

    assertEquals(127, cAt10[0]);
    assertEquals(0, cAt10[1]);
    assertEquals(127, cAt10[2]);

    assertEquals(0, cAt15[0]);
    assertEquals(0, cAt15[1]);
    assertEquals(255, cAt15[2]);

    assertEquals(0, cAt20[0]);
    assertEquals(0, cAt20[1]);
    assertEquals(255, cAt20[2]);
  }

  @Test
  public void testExecuteAtFrameVis() {
    assertFalse((boolean) changeVis.executeAtFrame(0));
    assertTrue((boolean) changeVis.executeAtFrame(5));
    assertTrue((boolean) changeVis.executeAtFrame(14));
    assertFalse((boolean) changeVis.executeAtFrame(15));
    assertFalse((boolean) changeVis.executeAtFrame(20));
  }

  //
  @Test
  public void testExecuteAtFrameMove() {
    assertEquals("[0.0, 0.0]", Arrays.toString((float[]) move.executeAtFrame(0)));
    assertEquals("[0.0, 0.0]", Arrays.toString((float[]) move.executeAtFrame(5)));
    assertEquals("[50.0, 0.0]", Arrays.toString((float[]) move.executeAtFrame(10)));
    assertEquals("[100.0, 0.0]", Arrays.toString((float[]) move.executeAtFrame(15)));
    assertEquals("[100.0, 0.0]", Arrays.toString((float[]) move.executeAtFrame(20)));
  }

  @Test
  public void testExecuteAtFrameResize() {
    assertEquals(BASE, ((ResizeT) resize).getDimension());

    assertEquals(50, (float) resize.executeAtFrame(0), 0);

    assertEquals(50, (float) resize.executeAtFrame(5), 0);

    assertEquals(62.5, (float) resize.executeAtFrame(10), 0);

    assertEquals(75, (float) resize.executeAtFrame(15), 0);

    assertEquals(75, (float) resize.executeAtFrame(20), 0);
  }
}
