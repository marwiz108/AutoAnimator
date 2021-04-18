import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import cs5004.animator.model.canvas.ICanvas;
import cs5004.animator.model.canvas.ICanvasModel;
import cs5004.animator.view.SVG;
import cs5004.animator.view.Text;
import cs5004.animator.view.TextView;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.Before;
import org.junit.Test;

public class TextViewTest {

  private TextView text;
  private TextView svg;

  @Before
  public void setUp() {
    ICanvas c = new ICanvasModel();
    this.text = new Text(c, "test-text.txt");
    this.svg = new SVG(c, "test-svg.svg", 1000);
  }

  @Test
  public void generateText() {
    assertEquals("No shapes in the animation.\n"
        + "No transformations in the animation.\n",
        this.text.generateText(1000));

    assertEquals("<svg viewBox=\"0 0 0 0\" xmlns=\"http://www.w3.org/2000/svg\">\n"
        + "</svg>", this.svg.generateText(1000));
  }

  @Test
  public void createFile() {
    this.text.createFile("text-file.txt");
    Path textPath = Paths.get("text-file.txt");
    assertTrue(Files.exists(textPath));

    this.svg.createFile("svg-file.svg");
    Path svgPath = Paths.get("svg-file.svg");
    assertTrue(Files.exists(svgPath));
  }
}