package cs5004.animator.view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import cs5004.animator.model.canvas.ICanvas;
import cs5004.animator.model.shape.Shape;

/**
 * Paints Graphics2D objects onto a panel, and keeps track of frames per second. Used to render
 * shapes for the VisualView.
 */
public class AnimationPanel extends JPanel implements ActionListener {
  private final ICanvas canvas;
  private final Timer timer;
  private int frame;

  /**
   * Constructor for the AnimationPanel.
   *
   * @param c the canvas that is being rendered.
   * @param delay the delay (in ms) between each frame.
   */
  public AnimationPanel(ICanvas c, int delay) {
    this.canvas = c;
    this.timer = new Timer(delay, this);
    this.frame = 0;
  }

  @Override
  public void paintComponent(Graphics g) {
    Graphics2D g2 = (Graphics2D) g;
    super.paintComponent(g2);
    for (Shape s : this.canvas.getShapesAtFrame(this.frame)) {
      if (s.isVisible()) {
        g.setColor(s.getColor());
        s.fill(g2);
      }
    }
    this.timer.start();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    this.frame = this.frame + 1;
    repaint();
  }
}
