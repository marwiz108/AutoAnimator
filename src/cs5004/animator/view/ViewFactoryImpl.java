package cs5004.animator.view;

import cs5004.animator.model.canvas.ICanvas;

public class ViewFactoryImpl implements ViewFactory {

  private final ICanvas canvas;

  public ViewFactoryImpl(ICanvas c) {
    this.canvas = c;
  }

  @Override
  public IView create(String viewType) {
    return create(viewType, 1000);
  }

  @Override
  public IView create(String viewType, int delay) {
    if (viewType.equals("text")) {
      return new Text(this.canvas);
    } else if (viewType.equals("svg")) {
      return new SVG(this.canvas);
    } else if (viewType.equals("visual")) {
      return new AnimationFrame(this.canvas, delay);
    }
    throw new IllegalArgumentException("No view was specified!");
  }
}
