package cs5004.animator.view;

import cs5004.animator.model.canvas.ICanvas;

public class SVGView extends AbstractTextualView {
  /**
   * Constructor for an SVGView view.
   *
   * @param canvas the canvas object with data to be animated.
   * @param outFile the name of the eventual .SVGView file.
   * @param delay the delay (in ms) between each frame.
   */
  public SVGView(ICanvas canvas, String outFile, float delay) {
    super(canvas, outFile, delay);
  }

  @Override
  public String generateText(float delay) {
    return this.canvas.toSVGString(this.delay);
  }
}
