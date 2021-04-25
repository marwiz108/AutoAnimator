package cs5004.animator.view.controls;

import javax.naming.OperationNotSupportedException;
import javax.swing.*;

import cs5004.animator.controller.Features;

/** Class that represents the GUI controls for the interactive view. */
public class GUIPanel extends JPanel implements Controls {
  private final JButton playPause = new JButton("Pause");
  private final JButton reset = new JButton("Reset");
  private final JButton changeSpeed = new JButton("Change Speed");
  private final JCheckBox loop = new JCheckBox("Loop");

  /**
   * Constructor for a GUIPanel object that adds buttons to the frame.
   *
   * @param x the leftmost x value of the gui.
   * @param y the topmost y value of the gui.
   * @param borderWidth the width of the gui.
   */
  public GUIPanel(int x, int y, int borderWidth) {
    super();
    this.setBounds(x, y, borderWidth, 100);
    add(reset);
    add(playPause);
    add(changeSpeed);
    add(loop);
    setVisible(true);
    loop.isSelected();
  }

  @Override
  public void updatePlayPauseTitle(String title) {
    this.playPause.setText(title);
  }

  @Override
  public void addFeatures(Features features) {
    playPause.addActionListener(l -> features.playPauseEvent());
    reset.addActionListener(l -> features.resetEvent());
    loop.addActionListener(l -> features.loopEvent());
    changeSpeed.addActionListener(l -> features.showSpeedControls());
  }

  @Override
  public void setFps(int newFPS) throws OperationNotSupportedException {
    throw new OperationNotSupportedException("Operation not supported");
  }

  @Override
  public void showSpeedControls() throws OperationNotSupportedException {
    throw new OperationNotSupportedException("Operation not supported");
  }
}
