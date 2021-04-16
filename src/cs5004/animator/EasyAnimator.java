package cs5004.animator;

import java.io.FileNotFoundException;

import cs5004.animator.model.canvas.ICanvasModel;
import cs5004.animator.view.AnimationFrame;
import cs5004.animator.view.AnimationView;

public final class EasyAnimator {
  public static void main(String[] args) throws FileNotFoundException {
    ICanvasModel.Builder builder =
        new ICanvasModel.Builder("src/cs5004/animator/view/examples/big-bang-big-crunch.txt");
    AnimationView aView = new AnimationFrame(builder.getCanvas(), 100);
    //    TextView svgView = new SVG(builder.getCanvas());
    //    TextView txtView = new Text(builder.getCanvas());
    System.out.println(builder.getCanvas().toString());
  }
}
