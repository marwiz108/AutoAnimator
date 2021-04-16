package cs5004.animator;

import java.io.Console;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.text.View;

import cs5004.animator.model.canvas.ICanvasModel;
import cs5004.animator.view.AnimationFrame;
import cs5004.animator.view.AnimationView;
import cs5004.animator.view.ViewFactory;
import cs5004.animator.view.ViewFactoryImpl;

public final class EasyAnimator {
  public static void main(String[] args) throws FileNotFoundException {
    String inFile = null;
    String viewType = null;
    int delay = 1000;
    String outFile = null;

    Scanner sc = new Scanner(System.in);
    while (sc.hasNext()) {
      String input = sc.next();
      System.out.println(input);
      if (input.equals("-in")) {
        inFile = "src/cs5004/animator/view/examples/" + sc.next();
      } else if (input.equals("-view")) {
        viewType = sc.next();
      } else if (input.equals("-speed")) {
        delay = 1000 / Integer.parseInt(sc.next());
      } else if (input.equals("-out")) {
        outFile = "src/cs5004/animator/view/outfiles" + sc.next();
      } else {
        throw new IllegalStateException("Invalid argument.");
      }
      System.out.print(inFile);
      System.out.print(viewType);
      System.out.print(delay);
      System.out.println();
    }
    // -in buildings.txt -view visual -speed 24
    //    inFile = "src/cs5004/animator/view/examples/buildings.txt";
    //    viewType = "visual";
    //    int tps = 20;
    //    delay = 1000 / tps;
    //    outFile = "";

    if (inFile == null || viewType == null) {
      throw new IllegalStateException("Required parameters not specified.");
    }
    ICanvasModel.Builder builder = new ICanvasModel.Builder(inFile);
    ViewFactory factory = new ViewFactoryImpl(builder.getCanvas());
    factory.create(viewType, delay);

    System.out.println(builder.getCanvas().toString());
  }
}
