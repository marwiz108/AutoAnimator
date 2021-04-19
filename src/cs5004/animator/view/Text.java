package cs5004.animator.view;

import cs5004.animator.model.canvas.ICanvas;

/** Text view class. */
public class Text extends AbstractTextView {

  /**
   * Constructor for a text view.
   *
   * @param canvas the canvas the view will render.
   * @param outFile the filename of the output file.
   */
  public Text(ICanvas canvas, String outFile) {
    super(canvas, outFile, 1000);
  }

  @Override
  public String generateText(float delay) {
    return this.canvas.toString();
  }
}
