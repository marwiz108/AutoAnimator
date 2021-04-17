package cs5004.animator;

import java.io.FileNotFoundException;
import java.util.Objects;

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
    String inFile = null;
    String viewType = null;
    int delay = 1000;
    String outFile = null;

    for (int i = 0; i < args.length; i++) {
      if (args[i].equals("-in")) {
        inFile = "src/cs5004/animator/view/examples/" + args[i + 1];
      } else if (args[i].equals("-view")) {
        viewType = args[i + 1];
      } else if (args[i].equals("-out")) {
        outFile = "src/cs5004/animator/view/output/" + args[i + 1];
      } else if (args[i].equals("-speed")) {
        delay = 1000 / Integer.parseInt(args[i + 1]);
      }
    }
    System.out.print("Passed: ");
    System.out.println(delay);
    ICanvasModel.Builder builder = null;
    try {
      builder = new ICanvasModel.Builder(inFile);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    ViewFactory factory = new ViewFactoryImpl(Objects.requireNonNull(builder).getCanvas());
    factory.create(viewType, outFile, delay);
  }
}
