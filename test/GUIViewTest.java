import static org.junit.Assert.assertEquals;

import cs5004.animator.model.canvas.ICanvasModel;
import cs5004.animator.view.GUIView;
import cs5004.animator.view.IView;
import cs5004.animator.view.ViewFactory;
import cs5004.animator.view.ViewFactoryImpl;
import java.io.FileNotFoundException;
import java.util.Objects;
import javax.naming.OperationNotSupportedException;
import org.junit.Before;
import org.junit.Test;

public class GUIViewTest {

  private ICanvasModel.Builder builder;
  private IView interactive;
  private GUIView interactiveGUI;

  @Before
  public void setUp() {
    builder = null;
    try {
      builder = new ICanvasModel.Builder("resources/input/smalldemo.txt");
    } catch (FileNotFoundException | NullPointerException e) {
      System.out.println("Input file not found!");
      e.printStackTrace();
    }
    ViewFactory factory = new ViewFactoryImpl(Objects.requireNonNull(builder).getCanvas());
    this.interactive = factory.create("playback", null, 20);
    this.interactiveGUI = (GUIView) this.interactive;
  }

  @Test
  public void reset() {
    this.interactiveGUI.reset();
    assertEquals("Shapes:\n"
        + "Name: R\n"
        + "Type: rectangle\n"
        + "Position: (200.0, 200.0), Base: 50.0, Height: 100.0\n"
        + "Color: (255, 0, 0)\n"
        + "\n"
        + "Name: C\n"
        + "Type: oval\n"
        + "Position: (440.0, 70.0), Base: 120.0, Height: 60.0\n"
        + "Color: (0, 0, 255)\n"
        + "\n"
        + "Transformations:\n"
        + "Shape R appears at t=1.00 and disappears at t=100.00\n"
        + "Shape C appears at t=6.00 and disappears at t=100.00\n"
        + "Shape R moves from (200.0, 200.0) to (300.0, 300.0) from t=10.00 to t=50.00\n"
        + "Shape C moves from (440.0, 70.0) to (440.0, 250.0) from t=20.00 to t=50.00\n"
        + "Shape C changes color from (0, 0, 255) to (0, 170, 85) from t=50.00 to t=70.00\n"
        + "Shape C moves from (440.0, 250.0) to (440.0, 370.0) from t=50.00 to t=70.00\n"
        + "Shape R Scales from Base: 50.0, Height: 100.0 to Base: 25.0, Height: 100.0 from t=51.00 to t=70.00\n"
        + "Shape C changes color from (0, 170, 85) to (0, 255, 0) from t=70.00 to t=80.00\n"
        + "Shape R moves from (300.0, 300.0) to (200.0, 200.0) from t=70.00 to t=100.00\n",
        builder.getCanvas().toString());
  }

//  @Test
//  public void addFeatures() {
//  }

  @Test
  public void toggleLoop() {
//    assertEquals(false, this.interactiveGUI.getAnimationPanel());
    this.interactiveGUI.toggleLoop();
//    assertEquals(true, this.interactiveGUI.getAnimationPanel());
  }

  @Test
  public void playPause() {
    this.interactiveGUI.playPause();
    assertEquals(true, this.interactiveGUI.getAnimationPanel().isPaused());
    this.interactiveGUI.playPause();
    assertEquals(false, this.interactiveGUI.getAnimationPanel().isPaused());
  }

//  @Test
//  public void showSpeedControls() {
//  }
//
//  @Test
//  public void setSpeed() {
//  }
}