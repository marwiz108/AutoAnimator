import static org.junit.Assert.assertEquals;

import cs5004.animator.model.canvas.ICanvasModel;
import cs5004.animator.view.GUIView;
import cs5004.animator.view.IView;
import cs5004.animator.view.ViewFactory;
import cs5004.animator.view.ViewFactoryImpl;
import java.io.FileNotFoundException;
import java.util.Objects;
import org.junit.Before;
import org.junit.Test;

/** Tests for the GUIView interface. */
public class GUIViewTest {

  private ICanvasModel.Builder builder;
  private GUIView interactiveGUI;

  @Before
  public void setUp() {
    builder = null;
    try {
      builder = new ICanvasModel.Builder("resources/input/toh-3.txt");
    } catch (FileNotFoundException | NullPointerException e) {
      System.out.println("Input file not found!");
      e.printStackTrace();
    }
    ViewFactory factory = new ViewFactoryImpl(Objects.requireNonNull(builder).getCanvas());
    IView interactive = factory.create("playback", null, 20);
    this.interactiveGUI = (GUIView) interactive;
  }

  @Test
  public void reset() {
    this.interactiveGUI.reset();
    assertEquals("Shapes:\n"
            + "Name: disk1\n"
            + "Type: rectangle\n"
            + "Position: (190.0, 180.0), Base: 20.0, Height: 30.0\n"
            + "Color: (0, 49, 90)\n"
            + "\n"
            + "Name: disk2\n"
            + "Type: rectangle\n"
            + "Position: (167.0, 210.0), Base: 65.0, Height: 30.0\n"
            + "Color: (6, 247, 41)\n"
            + "\n"
            + "Name: disk3\n"
            + "Type: rectangle\n"
            + "Position: (145.0, 240.0), Base: 110.0, Height: 30.0\n"
            + "Color: (11, 45, 175)\n"
            + "\n"
            + "Transformations:\n"
            + "Shape disk3 appears at t=1.00 and disappears at t=302.00\n"
            + "Shape disk2 appears at t=1.00 and disappears at t=302.00\n"
            + "Shape disk1 appears at t=1.00 and disappears at t=302.00\n"
            + "Shape disk1 moves from (190.0, 180.0) to (190.0, 50.0) from t=25.00 to t=35.00\n"
            + "Shape disk1 moves from (190.0, 50.0) to (490.0, 50.0) from t=36.00 to t=46.00\n"
            + "Shape disk1 moves from (490.0, 50.0) to (490.0, 240.0) from t=47.00 to t=57.00\n"
            + "Shape disk2 moves from (167.0, 210.0) to (167.0, 50.0) from t=57.00 to t=67.00\n"
            + "Shape disk2 moves from (167.0, 50.0) to (317.0, 50.0) from t=68.00 to t=78.00\n"
            + "Shape disk2 moves from (317.0, 50.0) to (317.0, 240.0) from t=79.00 to t=89.00\n"
            + "Shape disk1 moves from (490.0, 240.0) to (490.0, 50.0) from t=89.00 to t=99.00\n"
            + "Shape disk1 moves from (490.0, 50.0) to (340.0, 50.0) from t=100.00 to t=110.00\n"
            + "Shape disk1 moves from (340.0, 50.0) to (340.0, 210.0) from t=111.00 to t=121.00\n"
            + "Shape disk3 moves from (145.0, 240.0) to (145.0, 50.0) from t=121.00 to t=131.00\n"
            + "Shape disk3 moves from (145.0, 50.0) to (445.0, 50.0) from t=132.00 to t=142.00\n"
            + "Shape disk3 moves from (445.0, 50.0) to (445.0, 240.0) from t=143.00 to t=153.00\n"
            + "Shape disk3 changes color from (11, 45, 175) to (0, 255, 0) from t=153.00 "
            + "to t=161.00\n"
            + "Shape disk1 moves from (340.0, 210.0) to (340.0, 50.0) from t=153.00 to t=163.00\n"
            + "Shape disk1 moves from (340.0, 50.0) to (190.0, 50.0) from t=164.00 to t=174.00\n"
            + "Shape disk1 moves from (190.0, 50.0) to (190.0, 240.0) from t=175.00 to t=185.00\n"
            + "Shape disk2 moves from (317.0, 240.0) to (317.0, 50.0) from t=185.00 to t=195.00\n"
            + "Shape disk2 moves from (317.0, 50.0) to (467.0, 50.0) from t=196.00 to t=206.00\n"
            + "Shape disk2 moves from (467.0, 50.0) to (467.0, 210.0) from t=207.00 to t=217.00\n"
            + "Shape disk2 changes color from (6, 247, 41) to (0, 255, 0) from t=217.00 "
            + "to t=225.00\n"
            + "Shape disk1 moves from (190.0, 240.0) to (190.0, 50.0) from t=217.00 to t=227.00\n"
            + "Shape disk1 moves from (190.0, 50.0) to (490.0, 50.0) from t=228.00 to t=238.00\n"
            + "Shape disk1 moves from (490.0, 50.0) to (490.0, 180.0) from t=239.00 to t=249.00\n"
            + "Shape disk1 changes color from (0, 49, 90) to (0, 255, 0) from t=249.00 "
            + "to t=257.00\n",
        builder.getCanvas().toString());
  }

  //  @Test
  //  public void addFeatures() {
  //  }

  @Test
  public void toggleLoop() {
    assertEquals("Animation Panel: Initial Delay=20 Current fps=50 Current Frame=0 "
            + "Final Frame=302 Repeating=false Paused=false",
        this.interactiveGUI.getAnimationPanel().toString());
    this.interactiveGUI.toggleLoop();
    assertEquals("Animation Panel: Initial Delay=20 Current fps=50 Current Frame=0 "
            + "Final Frame=302 Repeating=true Paused=false",
        this.interactiveGUI.getAnimationPanel().toString());
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

  @Test
  public void setSpeed() {
    assertEquals("Animation Panel: Initial Delay=20 Current fps=50 Current Frame=0 "
            + "Final Frame=302 Repeating=false Paused=false",
        this.interactiveGUI.getAnimationPanel().toString());
    this.interactiveGUI.setSpeed(80);
    assertEquals("Animation Panel: Initial Delay=20 Current fps=80 Current Frame=0 "
            + "Final Frame=302 Repeating=false Paused=false",
        this.interactiveGUI.getAnimationPanel().toString());
  }
}