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
  // TODO create the .jar files needed - note in readme the directory it must be placed into
  /**
   * Main method that parses args and runs an animation view. Note the .jar file must be placed in
   * the src directory to work correctly.
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
        inFile = "input/" + args[i + 1];
      } else if (args[i].equals("-view")) {
        viewType = args[i + 1];
      } else if (args[i].equals("-out")) {
        outFile = "output/" + args[i + 1];
      } else if (args[i].equals("-speed")) {
        delay = 1000 / Integer.parseInt(args[i + 1]);
      }
    }

    ICanvasModel.Builder builder = null;
    try {
      builder = new ICanvasModel.Builder(inFile);
    } catch (FileNotFoundException | NullPointerException e) {
      System.out.println("Input file not found!");
      e.printStackTrace();
    }
    ViewFactory factory = new ViewFactoryImpl(Objects.requireNonNull(builder).getCanvas());
    factory.create(viewType, outFile, delay);
  }
}
