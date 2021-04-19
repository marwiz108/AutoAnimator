import org.junit.Before;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.naming.OperationNotSupportedException;

import cs5004.animator.model.canvas.ICanvas;
import cs5004.animator.model.canvas.ICanvasModel;
import cs5004.animator.view.IView;
import cs5004.animator.view.text.SVGView;
import cs5004.animator.view.text.TextView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/** Tests for the IView interface. */
public class IViewTest {
  // TODO add tests after adding transformations
  // TODO add tests that check if methods throw OperationNotSupportedException when called by the
  private IView text;
  private IView svg;

  @Before
  public void setUp() {
    ICanvas c = new ICanvasModel();
    this.text = new TextView(c, "test/output/test-text.txt");
    this.svg = new SVGView(c, "test/output/test-svg.svg", 1000);
  }

  @Test
  public void generateText() throws OperationNotSupportedException {
    assertEquals(
        "No shapes in the animation.\n" + "No transformations in the animation.\n",
        this.text.generateText(1000));

    assertEquals(
        "<svg viewBox=\"0 0 0 0\" xmlns=\"http://www.w3.org/2000/svg\">\n" + "</svg>",
        this.svg.generateText(1000));
  }

  @Test
  public void createFile() throws OperationNotSupportedException {
    this.text.createFile("test/output/text-file.txt");
    Path textPath = Paths.get("test/output/text-file.txt");
    assertTrue(Files.exists(textPath));

    this.svg.createFile("test/output/svg-file.svg");
    Path svgPath = Paths.get("test/output/svg-file.svg");
    assertTrue(Files.exists(svgPath));
  }
}
