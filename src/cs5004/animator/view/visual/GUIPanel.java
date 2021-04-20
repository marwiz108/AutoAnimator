package cs5004.animator.view.visual;

import java.awt.event.ActionListener;

import javax.swing.*;

public class GUIPanel extends JPanel {
  // TODO get these buttons to do something
  private final JButton playPause = new JButton("Play/Pause");
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

  public void setListeners(ActionListener l) {
    playPause.addActionListener(l);
    reset.addActionListener(l);
    changeSpeed.addActionListener(l);
    loop.addActionListener(l);
  }
}
