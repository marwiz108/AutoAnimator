import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import cs5004.animator.model.canvas.ICanvas;
import cs5004.animator.model.canvas.ICanvasModel;
import cs5004.animator.model.shape.Oval;
import cs5004.animator.model.shape.Point2D;
import cs5004.animator.model.shape.Rectangle;
import cs5004.animator.model.shape.Shape;
import cs5004.animator.model.transformation.MoveT;
import cs5004.animator.model.transformation.ResizeT;
import cs5004.animator.model.transformation.dimension;
import cs5004.animator.view.IView;
import cs5004.animator.view.text.SVGView;
import cs5004.animator.view.text.TextView;
import cs5004.animator.view.visual.VisualView;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.naming.OperationNotSupportedException;
import org.junit.Before;
import org.junit.Test;

/** Tests for the IView interface. */
public class IViewTest {
  private ICanvas c;
  private IView text;
  private IView svg;
  private IView visual;

  @Before
  public void setUp() {
    this.c = new ICanvasModel();
    this.text = new TextView(c, "test/output/test-text.txt");
    this.svg = new SVGView(c, "test/output/test-svg.svg", 1000);
    this.visual = new VisualView(c, 1000);
  }

  @Test(expected = OperationNotSupportedException.class)
  public void testCreateAndShowThrowsExceptionForSVG() throws OperationNotSupportedException {
    this.svg.createAndShow(1000);
  }

  @Test(expected = OperationNotSupportedException.class)
  public void testCreateAndShowThrowsExceptionForText() throws OperationNotSupportedException {
    this.text.createAndShow(1000);
  }

  @Test (expected = OperationNotSupportedException.class)
  public void testCreateFileThrowsExceptionForVisualView() throws OperationNotSupportedException {
    this.visual.createFile("test-file.txt");
  }

  @Test (expected = OperationNotSupportedException.class)
  public void testGenerateTextThrowsExceptionForVisualView() throws OperationNotSupportedException {
    this.visual.generateText(1000);
  }

  //
  //  @Test (expected = OperationNotSupportedException.class)
  //  public void testResetThrowsExceptionForSVG() throws OperationNotSupportedException {
  //    this.svg.reset();
  //  }
  //
  //  @Test (expected = OperationNotSupportedException.class)
  //  public void testResetThrowsExceptionForText() throws OperationNotSupportedException {
  //    this.text.reset();
  //  }
  //
  //  @Test (expected = OperationNotSupportedException.class)
  //  public void testAddFeaturesThrowsExceptionForSVG() throws OperationNotSupportedException {
  //    Features controller = new AnimationController((InteractiveView) this.interactive);
  //    this.svg.addFeatures(controller);
  //  }
  //
  //  @Test (expected = OperationNotSupportedException.class)
  //  public void testAddFeaturesThrowsExceptionForText() throws OperationNotSupportedException {
  //    Features controller = new AnimationController((InteractiveView) this.interactive);
  //    this.text.addFeatures(controller);
  //  }
  //
  //  @Test (expected = OperationNotSupportedException.class)
  //  public void testToggleLoopThrowsExceptionForSVG() throws OperationNotSupportedException {
  //    this.svg.toggleLoop();
  //  }
  //
  //  @Test (expected = OperationNotSupportedException.class)
  //  public void testToggleLoopThrowsExceptionForText() throws OperationNotSupportedException {
  //    this.text.toggleLoop();
  //  }
  //
  //  @Test (expected = OperationNotSupportedException.class)
  //  public void testPlayPauseThrowsExceptionForSVG() throws OperationNotSupportedException {
  //    this.svg.playPause();
  //  }
  //
  //  @Test (expected = OperationNotSupportedException.class)
  //  public void testPlayPauseThrowsExceptionForText() throws OperationNotSupportedException {
  //    this.text.playPause();
  //  }
  //
  //  @Test (expected = OperationNotSupportedException.class)
  //  public void testShowSpeedControlsThrowsExceptionForSVG() throws OperationNotSupportedException
  // {
  //    this.svg.showSpeedControls();
  //  }
  //
  //  @Test (expected = OperationNotSupportedException.class)
  //  public void testShowSpeedControlsThrowsExceptionForText() throws
  // OperationNotSupportedException {
  //    this.text.showSpeedControls();
  //  }
  //
  //  @Test (expected = OperationNotSupportedException.class)
  //  public void testSetSpeedThrowsExceptionForSVG() throws OperationNotSupportedException {
  //    this.svg.setSpeed(50);
  //  }
  //
  //  @Test (expected = OperationNotSupportedException.class)
  //  public void testSetSpeedThrowsExceptionForText() throws OperationNotSupportedException {
  //    this.text.setSpeed(5);
  //  }

  @Test
  public void testGenerateText() throws OperationNotSupportedException {
    assertEquals(
        "No shapes in the animation.\n" + "No transformations in the animation.\n",
        this.text.generateText(1000));

    assertEquals(
        "<svg viewBox=\"0 0 0 0\" xmlns=\"http://www.w3.org/2000/svg\">\n" + "</svg>",
        this.svg.generateText(1000));
  }

  @Test
  public void testGenerateTextAfterAddingShapes() throws OperationNotSupportedException {
    this.c.addShape(new Oval("o", 500, 100, 60, 30, 255, 0, 0));
    this.c.addShape(new Rectangle("r", 200, 200, 50, 100, 0, 0, 255));

    assertEquals(
        "<svg viewBox=\"0 0 0 0\" xmlns=\"http://www.w3.org/2000/svg\">\n"
            + "\t<ellipse id=\"o\" cx=\"500\" cy=\"100\" rx=\"30\" ry=\"15\" fill=\"rgb(255, 0, 0)\" visibility=\"hidden\">\n"
            + "\t</ellipse>\n"
            + "\t<rect id=\"r\" x=\"200\" y=\"200\" width=\"50\" height=\"100\" fill=\"rgb(0, 0, 255)\" visibility=\"hidden\">\n"
            + "\t</rect>\n"
            + "</svg>",
        this.svg.generateText(1000));

    assertEquals(
        "Shapes:\n"
            + "Name: o\n"
            + "Type: oval\n"
            + "Position: (500.0, 100.0), Base: 60.0, Height: 30.0\n"
            + "Color: (255, 0, 0)\n"
            + "\n"
            + "Name: r\n"
            + "Type: rectangle\n"
            + "Position: (200.0, 200.0), Base: 50.0, Height: 100.0\n"
            + "Color: (0, 0, 255)\n"
            + "\n"
            + "No transformations in the animation.\n",
        this.text.generateText(1000));
  }

  @Test
  public void testGenerateTextAfterAddingShapesAndTransformations()
      throws OperationNotSupportedException {
    Shape oval = new Oval("o", 500, 100, 60, 30, 255, 0, 0);
    this.c.addShape(oval);
    this.c.addTransformation("o", new ResizeT(oval, 8, 20, dimension.HEIGHT, 30, 100));
    this.c.addTransformation("o", new MoveT(oval, 5, 15, new Point2D(0, 0), new Point2D(80, 50)));

    assertEquals(
        "<svg viewBox=\"0 0 0 0\" xmlns=\"http://www.w3.org/2000/svg\">\n"
            + "\t<ellipse id=\"o\" cx=\"500\" cy=\"100\" rx=\"30\" ry=\"15\" fill=\"rgb(255, 0, 0)\" visibility=\"hidden\">\n"
            + "\t\t<animateTransform attributeName=\"ry\" attributeType=\"XML\" from=\"30.0\" to=\"100.0\" begin=\"8000.0ms\" dur=\"12000.0ms\" fill=\"freeze\"/>\n"
            + "\t\t<animate attributeName=\"cx\" attributeType=\"XML\" from=\"0.0\" to=\"80.0\" begin=\"5000.0ms\" dur=\"10000.0ms\" fill=\"freeze\"/>\n"
            + "\t\t<animate attributeName=\"cy\" attributeType=\"XML\" from=\"0.0\" to=\"50.0\" begin=\"5000.0ms\" dur=\"10000.0ms\" fill=\"freeze\"/>\n"
            + "\t</ellipse>\n"
            + "</svg>",
        this.svg.generateText(1000));

    assertEquals(
        "Shapes:\n"
            + "Name: o\n"
            + "Type: oval\n"
            + "Position: (500.0, 100.0), Base: 60.0, Height: 30.0\n"
            + "Color: (255, 0, 0)\n"
            + "\n"
            + "Transformations:\n"
            + "Shape o moves from (0.0, 0.0) to (80.0, 50.0) from t=5.00 to t=15.00\n"
            + "Shape o Scales from Base: 60.0, Height: 30.0 to Base: 60.0, Height: 100.0 from t=8.00 to t=20.00\n",
        this.text.generateText(1000));
  }

  @Test
  public void testCreateFile() throws OperationNotSupportedException {
    this.text.createFile("test/output/text-file.txt");
    Path textPath = Paths.get("test/output/text-file.txt");
    assertTrue(Files.exists(textPath));

    this.svg.createFile("test/output/svg-file.svg");
    Path svgPath = Paths.get("test/output/svg-file.svg");
    assertTrue(Files.exists(svgPath));
  }
}
