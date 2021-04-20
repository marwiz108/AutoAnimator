package cs5004.animator.view.visual;

import java.awt.*;

import javax.naming.OperationNotSupportedException;
import javax.swing.*;

import cs5004.animator.model.canvas.ICanvas;
import cs5004.animator.view.IView;

/** Visual view class. */
public class VisualView extends JFrame implements IView {

  private final ICanvas canvas;

  /**
   * Constructor for a VisualView.
   *
   * @param c the canvas object that is to be animated.
   * @param timerDelay the delay in milliseconds between frames of the animation.
   */
  public VisualView(ICanvas c, float timerDelay) {
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
  public void reset() throws OperationNotSupportedException {
    throw new OperationNotSupportedException("Operation not supported");
  }

  @Override
  public void playPause() throws OperationNotSupportedException {
    throw new OperationNotSupportedException("Operation not supported");
  }

  @Override
  public void pause() throws OperationNotSupportedException {
    throw new OperationNotSupportedException("Operation not supported");
  }

  @Override
  public void playFromFrame(float frame) throws OperationNotSupportedException {
    throw new OperationNotSupportedException("Operation not supported");
  }

  @Override
  public void setSpeed(int fps) throws OperationNotSupportedException {
    throw new OperationNotSupportedException("Operation not supported");
  }

  @Override
  public void increaseSpeed() throws OperationNotSupportedException {
    throw new OperationNotSupportedException("Operation not supported");
  }

  @Override
  public void decreaseSpeed() throws OperationNotSupportedException {
    throw new OperationNotSupportedException("Operation not supported");
  }

  @Override
  public String generateText(float delay) throws OperationNotSupportedException {
    throw new OperationNotSupportedException("Operation not supported");
  }

  @Override
  public void createFile(String filename) throws OperationNotSupportedException {
    throw new OperationNotSupportedException("Operation not supported");
  }
}
