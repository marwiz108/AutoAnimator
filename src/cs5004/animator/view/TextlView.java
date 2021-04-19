package cs5004.animator.view;

import cs5004.animator.model.canvas.ICanvas;

/** TextlView view class. */
public class TextlView extends AbstractTextualView {

  /**
   * Constructor for a text view.
   *
   * @param canvas the canvas the view will render.
   * @param outFile the filename of the output file.
   */
  public TextlView(ICanvas canvas, String outFile) {
    super(canvas, outFile, 1000);
  }

  @Override
  public String generateText(float delay) {
    return this.canvas.toString();
  }
}
