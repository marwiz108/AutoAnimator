package cs5004.animator.view;

import cs5004.animator.model.canvas.ICanvas;

public class SVG extends AbstractTextView {
  /**
   * Constructor for an SVG view.
   *
   * @param canvas the canvas object with data to be animated.
   * @param outFile the name of the eventual .SVG file.
   * @param delay the delay (in ms) between each frame.
   */
  public SVG(ICanvas canvas, String outFile, float delay) {
    super(canvas, outFile, delay);
  }

  @Override
  public String generateText(float delay) {
    return this.canvas.toSVGString(this.delay);
  }
}
