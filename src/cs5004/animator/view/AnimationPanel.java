package cs5004.animator.view;

import java.awt.*;

import javax.swing.*;

public class AnimationPanel extends JPanel {

  public AnimationPanel() {}

  public void paintComponent(Graphics g) {
    Graphics2D g2 = (Graphics2D) g;
    g.setColor(Color.red);
    g.fillRect(100, 100, 40, 30);
  }
}
