import static org.junit.Assert.assertEquals;

import cs5004.animator.model.canvas.Canvas;
import cs5004.animator.model.canvas.CanvasModel;
import cs5004.animator.model.shape.Oval;
import cs5004.animator.model.shape.Point2D;
import cs5004.animator.model.shape.Rectangle;
import cs5004.animator.model.shape.Shape;
import cs5004.animator.model.transformation.ChangeColorT;
import cs5004.animator.model.transformation.ChangeVisibilityT;
import cs5004.animator.model.transformation.MoveT;
import cs5004.animator.model.transformation.ResizeT;
import cs5004.animator.model.transformation.dimension;
import java.awt.Color;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests for the Canvas class.
 */
public class CanvasTest {

  private Canvas canvas;
  private Shape oval1;
  private Shape rectangle1;
  private ChangeVisibilityT changeRVis;
  private ChangeVisibilityT changeOVis;
  private ChangeColorT changeRColor;
  private ChangeColorT changeOColor;
  private MoveT move;
  private ResizeT resize;

  @Before
  public void setUp() {
    Point2D p1 = new Point2D(50, 150);
    Point2D p2 = new Point2D(200, 80);
    Point2D p3 = new Point2D(25, 100);
    Point2D p4 = new Point2D(150, 200);
    this.canvas = new CanvasModel();
    this.oval1 = new Oval("o", 50, 150, 60, 30, 255, 178, 102);
    this.rectangle1 = new Rectangle("r",
            200,
            80,
            50,
            10,
            51,
            153,
            255);
    this.changeRVis = new ChangeVisibilityT(rectangle1, 5, 15);
    this.changeOVis = new ChangeVisibilityT(oval1, 0, 10);

    this.changeRColor =
            new ChangeColorT(rectangle1, 7, 12, this.rectangle1.getColor(),
                    new Color(51, 153, 255));
    this.changeOColor =
            new ChangeColorT(
                    oval1,
                    2,
                    6,
                    this.oval1.getColor().getRed(),
                    this.oval1.getColor().getGreen(),
                    this.oval1.getColor().getBlue(),
                    255,
                    255,
                    153);

    this.move = new MoveT(rectangle1, 10, 20, p2, p3);
    this.resize = new ResizeT(oval1,
            15,
            20,
            dimension.BASE,
            60,
            80);
  }

  // Test for getShapesAtFrame is not yet implemented.

  @Test
  public void testAddShape() {
    this.canvas.addShape(oval1);
    assertEquals(
            "Shapes:\n"
                    + "Name: o\n"
                    + "Type: oval\n"
                    + "Position: (50.0, 150.0), Base: 60.0, Height: 30.0\n"
                    + "Color: (255, 178, 102)\n\n"
                    + "No transformations in the animation.\n",
            this.canvas.toString());

    this.canvas.addShape(rectangle1);
    assertEquals(
            "Shapes:\n"
                    + "Name: o\n"
                    + "Type: oval\n"
                    + "Position: (50.0, 150.0), Base: 60.0, Height: 30.0\n"
                    + "Color: (255, 178, 102)\n\n"
                    + "Name: r\n"
                    + "Type: rectangle\n"
                    + "Position: (200.0, 80.0), Base: 50.0, Height: 10.0\n"
                    + "Color: (51, 153, 255)\n\n"
                    + "No transformations in the animation.\n",
            this.canvas.toString());
  }

  @Test
  public void testRemoveShape() {
    this.canvas.addShape(rectangle1);
    this.canvas.addShape(oval1);
    this.canvas.removeShape("o");
    assertEquals(
            "Shapes:\n"
                    + "Name: r\n"
                    + "Type: rectangle\n"
                    + "Position: (200.0, 80.0), Base: 50.0, Height: 10.0\n"
                    + "Color: (51, 153, 255)\n"
                    + "\n"
                    + "No transformations in the animation.\n",
            this.canvas.toString());
  }

  // TODO add tests for conflicting transformations

  @Test
  public void testAddTransformation() {
    this.canvas.addShape(rectangle1);
    this.canvas.addShape(oval1);
    this.canvas.addTransformation("r", changeRVis);
    this.canvas.addTransformation("o", changeOVis);
    this.canvas.addTransformation("o", resize);
    this.canvas.addTransformation("r", move);

    assertEquals(
            "Shapes:\n"
                    + "Name: r\n"
                    + "Type: rectangle\n"
                    + "Position: (200.0, 80.0), Base: 50.0, Height: 10.0\n"
                    + "Color: (51, 153, 255)\n"
                    + "\n"
                    + "Name: o\n"
                    + "Type: oval\n"
                    + "Position: (50.0, 150.0), Base: 60.0, Height: 30.0\n"
                    + "Color: (255, 178, 102)\n"
                    + "\n"
                    + "Transformations:\n"
                    + "Shape o appears at t=0 and disappears at t=10\n"
                    + "Shape r appears at t=5 and disappears at t=15\n"
                    + "Shape r moves from (200.0, 80.0) to (25.0, 100.0) from t=10 to t=20\n"
                    + "Shape o Scales from Base: 60.0, Height: 30.0 to Base: 80.0, "
                    + "Height: 30.0 from t=15 to t=20\n",
            this.canvas.toString());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddTransformationWithInvalidShape() {
    this.canvas.addTransformation("t", resize);
  }

  @Test
  public void testToStringWithTransformations() {
    this.canvas.addShape(rectangle1);
    this.canvas.addShape(oval1);
    this.canvas.addTransformation("r", changeRVis);
    this.canvas.addTransformation("r", changeRColor);
    this.canvas.addTransformation("r", move);

    assertEquals(
            "Shapes:\n"
                    + "Name: r\n"
                    + "Type: rectangle\n"
                    + "Position: (200.0, 80.0), Base: 50.0, Height: 10.0\n"
                    + "Color: (51, 153, 255)\n\n"
                    + "Name: o\n"
                    + "Type: oval\n"
                    + "Position: (50.0, 150.0), Base: 60.0, Height: 30.0\n"
                    + "Color: (255, 178, 102)\n\n"
                    + "Transformations:\n"
                    + "Shape r appears at t=5 and disappears at t=15\n"
                    + "Shape r changes color from (51, 153, 255) to "
                    + "(51, 153, 255) from t=7 to t=12\n"
                    + "Shape r moves from (200.0, 80.0) to (25.0, 100.0) from t=10 to t=20\n",
            this.canvas.toString());

    this.canvas.addTransformation("o", changeOVis);
    this.canvas.addTransformation("o", changeOColor);
    this.canvas.addTransformation("o", resize);

    assertEquals(
            "Shapes:\n"
                    + "Name: r\n"
                    + "Type: rectangle\n"
                    + "Position: (200.0, 80.0), Base: 50.0, Height: 10.0\n"
                    + "Color: (51, 153, 255)\n\n"
                    + "Name: o\n"
                    + "Type: oval\n"
                    + "Position: (50.0, 150.0), Base: 60.0, Height: 30.0\n"
                    + "Color: (255, 178, 102)\n\n"
                    + "Transformations:\n"
                    + "Shape o appears at t=0 and disappears at t=10\n"
                    + "Shape o changes color from (255, 178, 102) to "
                    + "(255, 255, 153) from t=2 to t=6\n"
                    + "Shape r appears at t=5 and disappears at t=15\n"
                    + "Shape r changes color from (51, 153, 255) to (51, 153, 255) "
                    + "from t=7 to t=12\n"
                    + "Shape r moves from (200.0, 80.0) to (25.0, 100.0) from t=10 to t=20\n"
                    + "Shape o Scales from Base: 60.0, Height: 30.0 to Base: 80.0, "
                    + "Height: 30.0 from t=15 to t=20\n",
            this.canvas.toString());
  }

  @Test
  public void testToStringNoTransformations() {
    this.canvas.addShape(rectangle1);
    this.canvas.addShape(oval1);

    assertEquals(
            "Shapes:\n"
                    + "Name: r\n"
                    + "Type: rectangle\n"
                    + "Position: (200.0, 80.0), Base: 50.0, Height: 10.0\n"
                    + "Color: (51, 153, 255)\n\n"
                    + "Name: o\n"
                    + "Type: oval\n"
                    + "Position: (50.0, 150.0), Base: 60.0, Height: 30.0\n"
                    + "Color: (255, 178, 102)\n\n"
                    + "No transformations in the animation.\n",
            this.canvas.toString());
  }

  @Test
  public void testToStringNoShapes() {
    assertEquals(
            "No shapes in the animation.\n" + "No transformations in the animation.\n",
            this.canvas.toString());
  }
}
