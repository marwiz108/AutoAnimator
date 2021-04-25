import cs5004.animator.controller.AnimationController;
import cs5004.animator.controller.Features;
import cs5004.animator.model.canvas.ICanvasModel;
import cs5004.animator.view.IView;
import cs5004.animator.view.ViewFactory;
import cs5004.animator.view.ViewFactoryImpl;
import cs5004.animator.view.visual.InteractiveView;
import java.io.FileNotFoundException;
import java.util.Objects;
import org.junit.Before;
import org.junit.Test;

public class AnimationControllerTest {

  private IView view;
  private Features controller;

  @Before
  public void setUp() {
    ICanvasModel.Builder builder = null;
    try {
      builder = new ICanvasModel.Builder("resources/input/smalldemo.txt");
    } catch (FileNotFoundException | NullPointerException e) {
      System.out.println("Input file not found!");
      e.printStackTrace();
    }
    ViewFactory factory = new ViewFactoryImpl(Objects.requireNonNull(builder).getCanvas());
    this.view = factory.create("playback", null, 20);
    this.controller = new AnimationController((InteractiveView) this.view);
  }

  @Test
  public void testPlayPauseEvent() {
//    assertEquals(this.controller.playPauseEvent());
  }

  @Test
  public void testResetEvent() {
  }

  @Test
  public void testLoopEvent() {
  }

  @Test
  public void testShowSpeedControls() {
  }

  @Test
  public void testChangeSpeed() {
  }
}