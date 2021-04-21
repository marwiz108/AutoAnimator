package cs5004.animator.view.visual;

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
  private final int initialDelay;
  private int frame;
  // TODO initialShapes gets mutated somehow when looping - figure out what's going on! (Peter)
  private boolean repeat = false;
  private int finalFrame = 0;
  private boolean paused = false;

  /**
   * Constructor for the AnimationPanel.
   *
   * @param c the canvas that is being rendered.
   * @param delay the delay (in ms) between each frame.
   */
  public AnimationPanel(ICanvas c, int delay) {
    this.canvas = c;
    this.timer = new Timer(delay, this);
    this.initialDelay = delay;
    this.frame = 0;
    for (Shape s : this.canvas.getInitialShapes()) {
      if (s.getEndFrame() > this.finalFrame) {
        this.finalFrame = (int) s.getEndFrame();
      }
    }
  }

  public void setFrame(int frame) {
    this.frame = frame;
  }

  /** Tell the animation to repeat or stop repeating. */
  public void toggleRepeat() {
    this.repeat = !this.repeat;
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
    if (this.repeat) {
      if (this.frame > this.finalFrame) {
        this.canvas.resetDynamicShapes();
        //        System.out.println("HEEERRRREEEEE\n" + this.canvas.getInitialShapes());
        this.frame = 0;
      }
    }
    repaint();
  }

  public boolean isPaused() {
    return this.paused;
  }

  public void toggleTimer() {
    if (paused) {
      this.timer.start();
    } else {
      this.timer.stop();
    }
    paused = !paused;
  }

  /** Pause the animation. */
  public void stopTimer() {
    this.timer.stop();
  }

  /** Play the animation. */
  public void startTimer() {
    this.timer.start();
  }

  /**
   * Update the speed of the animation
   *
   * @param fps frames per second to set the animation to.
   */
  public void setSpeed(int fps) {
    this.timer.setDelay(1000 / fps);
  }

  // TODO javadoc
  public void resetSpeed() {
    this.timer.setDelay(initialDelay);
  }

  // TODO javadoc
  public void incrementSpeed() {
    this.timer.setDelay((int) (this.timer.getDelay() * 0.9));
  }

  // TODO javadoc
  public void decrementSpeed() {
    this.timer.setDelay((int) (this.timer.getDelay() * 1.1));
  }
}
