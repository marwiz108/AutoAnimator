package cs5004.animator;

import java.io.FileNotFoundException;

import cs5004.animator.model.canvas.ICanvas;
import cs5004.animator.model.canvas.ICanvasModel;
import cs5004.animator.view.AnimationFrame;
import cs5004.animator.view.AnimationView;

public final class EasyAnimator {
  public static void main(String[] args) throws FileNotFoundException {
    ICanvasModel.Builder builder =
        new ICanvasModel.Builder("src/cs5004/animator/view/examples/smalldemo.txt");
    AnimationView aView = new AnimationFrame(builder.getCanvas());
    System.out.println(builder.getCanvas().toString());
  }
}
