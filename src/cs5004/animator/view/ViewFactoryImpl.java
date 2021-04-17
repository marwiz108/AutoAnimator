package cs5004.animator.view;

import cs5004.animator.model.canvas.ICanvas;

public class ViewFactoryImpl implements ViewFactory {

  private final ICanvas canvas;

  /**
   * Constructor for the ViewFactoryImpl.
   *
   * @param c the canvas with all the view information.
   */
  public ViewFactoryImpl(ICanvas c) {
    this.canvas = c;
  }

  @Override
  public IView create(String viewType, String outFile, float delay) {
    if (viewType.equals("text")) {
      return new Text(this.canvas, outFile, delay);
    } else if (viewType.equals("svg")) {
      return new SVG(this.canvas, outFile, delay);
    } else if (viewType.equals("visual")) {
      return new AnimationFrame(this.canvas, delay);
    }
    throw new IllegalArgumentException("No view was specified!");
  }
}
