package cs5004.animator.view;

import java.awt.*;

import javax.swing.*;

import cs5004.animator.model.canvas.ICanvas;

public class AnimationFrame extends JFrame implements AnimationView {

  private final ICanvas canvas;

  /**
   * Constructor for an AnimationFrame.
   *
   * @param c the canvas object that is to be animated.
   * @param timerDelay the delay in milliseconds between frames of the animation.
   */
  public AnimationFrame(ICanvas c, float timerDelay) {
    this.canvas = c;
    createAndShow((int) timerDelay);
  }

  @Override
  public void createAndShow(int delay) {
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
  public void playFromFrame(float frame, boolean reverse) {
    return;
  }
}
