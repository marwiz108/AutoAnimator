package cs5004.animator.view;

import java.awt.*;

import javax.swing.*;

import cs5004.animator.model.canvas.Canvas;
import cs5004.animator.model.canvas.CanvasModel;
import cs5004.animator.model.shape.Oval;
import cs5004.animator.model.shape.Rectangle;
import cs5004.animator.model.shape.Shape;

public class Animation implements AnimationView {
  private final JFrame f;
  private final JPanel panel;
  private final JScrollPane pane;

  public Animation(Canvas c, int width, int height) {
    this.f = new JFrame("Animation View");
    this.f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.f.setPreferredSize(new Dimension(width, height));
    this.panel = new JPanel();
    this.pane = new JScrollPane(this.panel);
    this.f.getContentPane().add(this.pane, BorderLayout.CENTER);
    this.f.pack();
    this.f.setVisible(true);
  }

  public static void main(String[] args) {
    Canvas c = new CanvasModel();
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
