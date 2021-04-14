package cs5004.animator;

import java.io.FileNotFoundException;

import cs5004.animator.model.canvas.ICanvas;
import cs5004.animator.model.canvas.ICanvasModel;

public final class EasyAnimator {
  public static void main(String[] args) throws FileNotFoundException {
    ICanvasModel.Builder builder =
        new ICanvasModel.Builder("src/cs5004/animator/view/examples/smalldemo.txt");
    System.out.println(builder.getCanvas().toString());
  }
}
