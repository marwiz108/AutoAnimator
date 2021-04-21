package cs5004.animator.view.visual;

import javax.swing.*;

import cs5004.animator.controller.Features;

public class GUIPanel extends JPanel {
  private final JButton playPause = new JButton("Pause");
  private final JButton reset = new JButton("Reset");
  private final JButton changeSpeed = new JButton("Change Speed");
  private final JCheckBox loop = new JCheckBox("Loop");

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

  public void updatePlayPauseTitle(String title) {
    this.playPause.setText(title);
  }

  public void addFeatures(Features features) {
    playPause.addActionListener(l -> features.playPauseEvent());
    reset.addActionListener(l -> features.resetEvent());
    loop.addActionListener(l -> features.loopEvent());
    //    changeSpeed.addActionListener();
  }
}
