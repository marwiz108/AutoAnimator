package cs5004.animator.view;

import cs5004.animator.model.canvas.ICanvas;
import cs5004.animator.view.text.SVGView;
import cs5004.animator.view.text.TextView;
import cs5004.animator.view.visual.VisualView;

/** Implementation of the ViewFactory interface. */
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
    try {
      switch (viewType) {
        case "text":
          return new TextView(this.canvas, outFile);
        case "svg":
          return new SVGView(this.canvas, outFile, delay);
        case "visual":
          return new VisualView(this.canvas, delay);
        default:
          throw new IllegalArgumentException("Could not parse view argument");
      }
    } catch (NullPointerException e) {
      System.out.println("Error creating view");
      e.printStackTrace();
      return null;
    }
  }
}
