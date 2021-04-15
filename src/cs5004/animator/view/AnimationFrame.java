package cs5004.animator.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import cs5004.animator.model.canvas.ICanvas;
import cs5004.animator.model.canvas.ICanvasModel;
import cs5004.animator.model.shape.Oval;
import cs5004.animator.model.shape.Rectangle;
import cs5004.animator.model.shape.Shape;
import cs5004.animator.model.transformation.MoveT;

public class AnimationFrame extends JFrame implements AnimationView, ActionListener {

  private final ICanvas canvas;

  public AnimationFrame(ICanvas c) {
    this.canvas = c;
    createAndShowGUI();
  }

  private void createAndShowGUI() {
    JPanel panel = new AnimationPanel(this.canvas.getShapesAtFrame(153));
    panel.setPreferredSize(
        new Dimension(this.canvas.getBorderWidth(), this.canvas.getBorderHeight()));
    JScrollPane scroll = new JScrollPane(panel);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLayout(new BorderLayout());
    add(scroll, BorderLayout.CENTER);
    setSize(new Dimension(this.canvas.getBorderWidth(), this.canvas.getBorderHeight()));
    setVisible(true);
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

  @Override
  public void actionPerformed(ActionEvent e) {}
}
