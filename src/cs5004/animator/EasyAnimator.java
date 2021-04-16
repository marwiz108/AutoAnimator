package cs5004.animator;

import java.io.FileNotFoundException;

import javax.swing.text.View;

import cs5004.animator.model.canvas.ICanvasModel;
import cs5004.animator.view.AnimationFrame;
import cs5004.animator.view.AnimationView;
import cs5004.animator.view.ViewFactory;
import cs5004.animator.view.ViewFactoryImpl;

public final class EasyAnimator {
  public static void main(String[] args) throws FileNotFoundException {
    String inFile = "src/cs5004/animator/view/examples/buildings.txt";
    String viewType = "visual";
    int tps = 20;
    int delay = 1000 / tps;
    String outFile = "";

    ICanvasModel.Builder builder = new ICanvasModel.Builder(inFile);
    ViewFactory factory = new ViewFactoryImpl(builder.getCanvas());
    factory.create(viewType, delay);

    System.out.println(builder.getCanvas().toString());
  }
}
