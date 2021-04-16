package cs5004.animator.view;

import java.awt.*;

import javax.swing.*;

import cs5004.animator.model.canvas.ICanvas;

public class AnimationFrame extends JFrame implements IView, AnimationView {

  private final ICanvas canvas;

  public AnimationFrame(ICanvas c, int timerDelay) {
    this.canvas = c;
    createAndShowGUI(timerDelay);
  }

  @Override
  public void createAndShowGUI(int delay) {
    JPanel panel = new AnimationPanel(this.canvas, delay);
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
