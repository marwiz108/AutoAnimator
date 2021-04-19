package cs5004.animator.view.text;

import cs5004.animator.model.canvas.ICanvas;

/** TextView view class. */
public class TextView extends AbstractTextualView {

  /**
   * Constructor for a text view.
   *
   * @param canvas the canvas the view will render.
   * @param outFile the filename of the output file.
   */
  public TextView(ICanvas canvas, String outFile) {
    super(canvas, outFile, 1000);
  }

  @Override
  public String generateText(float delay) {
    return this.canvas.toString();
  }
}
