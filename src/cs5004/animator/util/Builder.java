package cs5004.animator.util;

import java.io.FileNotFoundException;
import java.io.FileReader;

import cs5004.animator.model.canvas.ICanvas;
import cs5004.animator.model.canvas.ICanvasModel;

public final class Builder implements AnimationBuilder<ICanvas> {

  @Override
  public ICanvas build() throws FileNotFoundException {
    Readable r = new FileReader("src/cs5004/animator/view/examples/smalldemo.txt");
    return AnimationReader.parseFile(r, this);
  }

  @Override
  public AnimationBuilder<ICanvas> setBounds(int x, int y, int width, int height) {
    return null;
  }

  @Override
  public AnimationBuilder<ICanvas> declareShape(String name, String type) {
    return null;
  }

  @Override
  public AnimationBuilder<ICanvas> addMotion(
      String name,
      int t1,
      int x1,
      int y1,
      int w1,
      int h1,
      int r1,
      int g1,
      int b1,
      int t2,
      int x2,
      int y2,
      int w2,
      int h2,
      int r2,
      int g2,
      int b2) {
    return null;
  }
}
