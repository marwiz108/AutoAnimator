package cs5004.animator.view;

import cs5004.animator.model.canvas.ICanvas;

public class SVG extends AbstractTextView {

  public SVG(ICanvas canvas) {
    super(canvas);
  }

  @Override
  public String generateText() {
    return "";
  }

  @Override
  public void createFile(String filename) {
    // this.text goes in a xml file
    return;
  }
}
