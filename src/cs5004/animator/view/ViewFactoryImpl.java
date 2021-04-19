package cs5004.animator.view;

import cs5004.animator.model.canvas.ICanvas;

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
      if (viewType.equals("text")) {
        return new Text(this.canvas, outFile);
      } else if (viewType.equals("svg")) {
        return new SVG(this.canvas, outFile, delay);
      } else if (viewType.equals("visual")) {
        return new VisualView(this.canvas, delay);
      }
      throw new IllegalArgumentException("No view was specified!");
    } catch (NullPointerException e) {
      System.out.println("Error creating view");
      e.printStackTrace();
      return null;
    }
  }
}
