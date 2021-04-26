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
  private int fps;
  private int frame;
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
    this.fps = 1000 / delay;
    this.frame = 0;
    for (Shape s : this.canvas.getInitialShapes()) {
      if (s.getEndFrame() > this.finalFrame) {
        this.finalFrame = (int) s.getEndFrame();
      }
    }
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("Animation Panel: ");
    s.append("Initial Delay=");
    s.append(initialDelay);
    s.append(" Current fps=");
    s.append(fps);
    s.append(" Current Frame=");
    s.append(frame);
    s.append(" Final Frame=");
    s.append(finalFrame);
    s.append(" Repeating=");
    s.append(repeat);
    s.append(" Paused=");
    s.append(paused);
    return s.toString();
  }

  /**
   * Set the frame to a given value.
   *
   * @param frame the frame to render.
   */
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
        this.frame = 0;
      }
    }
    repaint();
  }

  /**
   * Determine if the view is paused.
   *
   * @return true if paused.
   */
  public boolean isPaused() {
    return this.paused;
  }

  /**
   * Set the paused state without interfering with the timer (used for reset).
   *
   * @param p true if the animation should be paused.
   */
  public void setPaused(boolean p) {
    this.paused = p;
  }

  /** Start the timer if stopped, pause the timer if it is running. */
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
   * Update the speed of the animation.
   *
   * @param fps frames per second to set the animation to.
   */
  public void setSpeed(int fps) {
    this.fps = fps;
    this.timer.setDelay(1000 / fps);
  }

  /** Reset the speed of the animation to the original value that was passed in. */
  public void resetSpeed() {
    this.timer.setDelay(initialDelay);
  }
}
