package cs5004.animator.view.visual;

import java.awt.*;

import javax.swing.*;

public class speedControls extends JFrame {
  private final int delay;
  private final JButton increaseSpeed = new JButton("+");
  private final JButton decreaseSpeed = new JButton("-");

  public speedControls(int delay) {
    this.delay = delay;
    setPreferredSize(new Dimension(200, 100));
    setLayout(new BorderLayout());
    add(decreaseSpeed, BorderLayout.WEST);
    add(increaseSpeed, BorderLayout.EAST);
    pack();
    setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
    setVisible(false);
  }

  public void showSpeedControls() {
    setVisible(true);
  }
}
