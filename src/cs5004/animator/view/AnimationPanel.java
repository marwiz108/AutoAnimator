package cs5004.animator.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import cs5004.animator.model.canvas.ICanvas;
import cs5004.animator.model.shape.Shape;

public class AnimationPanel extends JPanel implements ActionListener {
  private final ICanvas canvas;
  private final Timer timer;
  private int tick;

  public AnimationPanel(ICanvas c, int delay) {
    this.canvas = c;
    this.timer = new Timer(delay, this);
    this.tick = 0;
  }

  @Override
  public void paintComponent(Graphics g) {
    Graphics2D g2 = (Graphics2D) g;
    super.paintComponent(g2);
    for (Shape s : this.canvas.getShapesAtFrame(this.tick)) {
      g.setColor(s.getColor());
      s.fill(g2);
    }
    this.timer.start();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    this.tick = this.tick + 1;
    repaint();
  }
}
