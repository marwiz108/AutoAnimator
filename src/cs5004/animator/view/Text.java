package cs5004.animator.view;

import cs5004.animator.model.canvas.ICanvas;

public class Text extends AbstractTextView {

  public Text(ICanvas canvas, String outFile) {
    super(canvas, outFile, 1000);
  }

  @Override
  public String generateText(float delay) {
    return this.canvas.toString();
  }
}
