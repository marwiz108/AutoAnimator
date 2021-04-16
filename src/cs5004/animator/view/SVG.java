package cs5004.animator.view;

import javax.swing.*;

import cs5004.animator.model.canvas.ICanvas;
import cs5004.animator.model.canvas.ICanvasModel;
import cs5004.animator.model.shape.Oval;
import cs5004.animator.model.shape.Shape;
import cs5004.animator.model.transformation.MoveT;

public class SVG extends AbstractTextView {

  /**
   * Constructor for an SVG view.
   *
   * @param canvas the canvas object with data to be animated.
   * @param outFile the name of the eventual .SVG file.
   */
  public SVG(ICanvas canvas, String outFile) {
    super(canvas);
    this.createFile(outFile);
  }

  // TODO remove main method
  public static void main(String[] args) {
    ICanvas canvas = new ICanvasModel();
    Shape oval = new Oval("o", 50, 50, 30, 60, 255, 0, 0);
    canvas.addShape(oval);
    canvas.addTransformation(oval.getIdentifier(), new MoveT(oval, 2, 6, 50, 50, 100, 100));

    SwingUtilities.invokeLater(
        new Runnable() {
          @Override
          public void run() {
            SVG svgview = new SVG(canvas, "test-svg.svg");
            //            svgview.createFile("test-svg.svg");
          }
        });
  }

  @Override
  public String generateText() {
    return this.canvas.toSVGString();
  }
}
