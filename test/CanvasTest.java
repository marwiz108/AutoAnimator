import static org.junit.Assert.assertEquals;

import model.canvas.Canvas;
import model.shape.Oval;
import model.shape.Rectangle;
import model.shape.Shape;
import org.junit.Before;
import org.junit.Test;

public class CanvasTest {

  private Canvas canvas;
  private Shape oval1;
  private Shape rectangle1;

  @Before
  public void setUp() {
    this.canvas = new Canvas();
    this.oval1 = new Oval("o",
        50, 150, 60, 30,
        255, 178, 102);
    this.rectangle1 = new Rectangle("r",
        200, 80, 50, 10,
        51, 153, 255);
  }

  @Test
  public void testAddShape() {
    this.canvas.addShape(oval1);
    assertEquals("Shapes:\n"
        + "Name: o\n"
        + "Type: oval\n"
        + "Position: (50.0, 150.0), Base: 60.0, Height: 30.0\n"
        + "Color: (255, 178, 102)\n\n", this.canvas.toString());

    this.canvas.addShape(rectangle1);
    assertEquals("Shapes:\n"
        + "Name: o\n"
        + "Type: oval\n"
        + "Position: (50.0, 150.0), Base: 60.0, Height: 30.0\n"
        + "Color: (255, 178, 102)\n\n"
        + "Name: r\n"
        + "Type: rectangle\n"
        + "Position: (200.0, 80.0), Base: 50.0, Height: 10.0\n"
        + "Color: (51, 153, 255)\n\n", this.canvas.toString());
  }

  @Test
  public void testAddTransformation() {
  }

  @Test
  public void testGetShapesAtFrame() {
  }

  @Test
  public void testToString() {
    this.canvas.addShape(rectangle1);
    this.canvas.addShape(oval1);

    assertEquals("Shapes:\n"
        + "Name: r\n"
        + "Type: rectangle\n"
        + "Position: (200.0, 80.0), Base: 50.0, Height: 10.0\n"
        + "Color: (51, 153, 255)\n\n"
        + "Name: o\n"
        + "Type: oval\n"
        + "Position: (50.0, 150.0), Base: 60.0, Height: 30.0\n"
        + "Color: (255, 178, 102)\n\n", this.canvas.toString());
  }
}