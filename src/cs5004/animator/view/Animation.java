package cs5004.animator.view;

import java.awt.*;
import java.awt.geom.Rectangle2D;

import javax.swing.*;

import cs5004.animator.model.canvas.ICanvas;
import cs5004.animator.model.canvas.ICanvasModel;
import cs5004.animator.model.shape.Oval;
import cs5004.animator.model.shape.Rectangle;
import cs5004.animator.model.shape.Shape;

public class Animation extends JPanel implements AnimationView {

  private final JFrame frame;
  private final JPanel panel;
  private final JScrollPane scrollPane;
  private ICanvas canvas;

  public Animation(ICanvas c) {
    // TODO create constructor for Animation
    this.canvas = canvas;

    this.frame = new JFrame("Easy Animator Text");
    this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.frame.setBounds(
        this.canvas.getLeftMostX(),
        this.canvas.getTopMostY(),
        this.canvas.getBorderWidth(),
        this.canvas.getBorderHeight());
    this.panel = new JPanel();

    this.scrollPane = new JScrollPane();
    this.frame.add(this.scrollPane);

    this.frame.pack();
    this.frame.setVisible(true);
  }

  public static void main(String[] args) {
    ICanvas c = new ICanvasModel();
    Shape oval1 = new Oval("o", 50, 150, 60, 30, 255, 178, 102);
    Shape rectangle1 = new Rectangle("r", 200, 80, 50, 10, 51, 153, 255);
    c.addShape(oval1);
    c.addShape(rectangle1);
    Animation a = new Animation(c);
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
