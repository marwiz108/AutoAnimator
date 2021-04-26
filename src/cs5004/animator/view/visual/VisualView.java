package cs5004.animator.view.visual;

import java.awt.Dimension;
import java.awt.BorderLayout;

import javax.naming.OperationNotSupportedException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

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
    panel.setVisible(true);
  }

  @Override
  public void createFile(String filename) throws OperationNotSupportedException {
    throw new OperationNotSupportedException("Operation not supported");
  }

  @Override
  public String generateText(float delay) throws OperationNotSupportedException {
    throw new OperationNotSupportedException("Operation not supported");
  }
}
