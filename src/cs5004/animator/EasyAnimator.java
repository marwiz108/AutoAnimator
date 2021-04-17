package cs5004.animator;

import java.io.FileNotFoundException;

import cs5004.animator.model.canvas.ICanvasModel;
import cs5004.animator.view.ViewFactory;
import cs5004.animator.view.ViewFactoryImpl;

/**
 * the entry point for EasyAnimator. This class defines all parameters needed to run an animation.
 */
public final class EasyAnimator {

  /**
   * Main method that parses args and runs an animation view.
   *
   * @param args the user defined arguments passed to the animation.
   */
  public static void main(String[] args) {
    // TODO get this working using args
    String inFile = null;
    String viewType = null;
    int delay = 1000;
    String outFile = null;

    // -in buildings.txt -view visual -speed 24
    inFile = "src/cs5004/animator/view/examples/buildings.txt";
    viewType = "visual";
    int fps = 24;
    delay = 1000 / fps;
    outFile = "";

    for (String s : args) {
      System.out.println(s);
    }

    ICanvasModel.Builder builder = null;
    try {
      builder = new ICanvasModel.Builder(inFile);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    ViewFactory factory = new ViewFactoryImpl(builder.getCanvas());
    factory.create(viewType, outFile, delay);

    //    System.out.println(builder.getCanvas().toString());
  }
}
