package cs5004.animator.view;

import cs5004.animator.model.canvas.ICanvas;
import cs5004.animator.model.canvas.ICanvasModel;
import cs5004.animator.model.shape.Oval;
import cs5004.animator.model.shape.Shape;
import cs5004.animator.model.transformation.MoveT;
import javax.swing.SwingUtilities;

public class Text extends AbstractTextView {

  public Text(ICanvas canvas) {
    super(canvas);
  }

  @Override
  public String generateText() {
    return this.canvas.toString();
  }

  public static void main(String[] args) {
    ICanvas canvas = new ICanvasModel();
    Shape oval = new Oval("o", 50, 50,
        30, 60, 255, 0, 0);
    canvas.addShape(oval);
    canvas.addTransformation(oval.getIdentifier(),
        new MoveT(oval, 2, 6, 50, 50, 100, 100));

    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        Text textview = new Text(canvas);
        textview.createFile("testing.txt");
      }
    });
  }
}
