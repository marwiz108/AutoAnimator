package cs5004.animator.view;

import javax.swing.*;

import cs5004.animator.model.canvas.ICanvas;
import cs5004.animator.model.canvas.ICanvasModel;
import cs5004.animator.model.shape.Oval;
import cs5004.animator.model.shape.Rectangle;
import cs5004.animator.model.shape.Shape;

public class Animation extends JPanel implements AnimationView {

  public Animation(ICanvas c, int w, int h) {
    // TODO create constructor for Animation
  }

  public static void main(String[] args) {
    ICanvas c = new ICanvasModel();
    Shape oval1 = new Oval("o", 50, 150, 60, 30, 255, 178, 102);
    Shape rectangle1 = new Rectangle("r", 200, 80, 50, 10, 51, 153, 255);
    c.addShape(oval1);
    c.addShape(rectangle1);
    Animation a = new Animation(c, 1000, 700);
  }

  @Override
  public void renderAtFrame(float frame) {
    return;
  }

  @Override
  public void reset() {
    return;
  }

  @Override
  public void play() {
    return;
  }

  @Override
  public void pause() {
    return;
  }

  @Override
  public void playFromFrame(float frame, float speed, boolean reverse) {
    return;
  }
}
