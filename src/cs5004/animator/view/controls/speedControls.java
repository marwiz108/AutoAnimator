package cs5004.animator.view.controls;

import java.awt.*;

import javax.naming.OperationNotSupportedException;
import javax.swing.*;

import cs5004.animator.controller.Features;

public class speedControls extends JFrame implements Controls {
  private int fps;
  private final JButton increaseSpeed = new JButton("+");
  private final JButton decreaseSpeed = new JButton("-");
  private final JTextField currentFPS;

  public speedControls(int fps) {
    this.fps = fps;
    currentFPS = new JTextField(String.valueOf(this.fps), 3);
    currentFPS.setHorizontalAlignment(JTextField.CENTER);
    JTextArea fpsLabel = new JTextArea("Current FPS:");
    setPreferredSize(new Dimension(200, 100));
    setLayout(new BorderLayout());
    add(decreaseSpeed, BorderLayout.WEST);
    add(increaseSpeed, BorderLayout.EAST);
    add(fpsLabel, BorderLayout.NORTH);
    add(currentFPS, BorderLayout.CENTER);
    pack();
    setTitle("Change Speed");
    setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
    setVisible(false);
  }

  @Override
  public void setFps(int newFPS) {
    this.fps = newFPS;
    this.currentFPS.setText(String.valueOf(newFPS));
  }

  @Override
  public void showSpeedControls() {
    setVisible(true);
  }

  @Override
  public void addFeatures(Features features) {
    decreaseSpeed.addActionListener(l -> features.changeSpeed(this.fps - 1));
    increaseSpeed.addActionListener(l -> features.changeSpeed(this.fps + 1));
  }

  @Override
  public void updatePlayPauseTitle(String title) throws OperationNotSupportedException {
    throw new OperationNotSupportedException("Operation not supported");
  }
}
