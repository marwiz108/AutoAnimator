package cs5004.animator.view.visual;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.naming.OperationNotSupportedException;
import javax.swing.*;

import cs5004.animator.view.IView;

public class GUIPanel extends JPanel {
  // TODO get these buttons to do something
  private final JButton playPause = new JButton("Play/Pause");
  private final JButton reset = new JButton("Reset");
  private final JButton changeSpeed = new JButton("Change Speed");
  private final JCheckBox loop = new JCheckBox("Loop");
  private IView v;

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

  private void playPauseEvent() {
    playPause.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            try {
              v.playPause();
            } catch (OperationNotSupportedException exception) {
              exception.printStackTrace();
            }
          }
        });
  }

  private void resetEvent() {
    reset.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            try {
              v.reset();
            } catch (OperationNotSupportedException exception) {
              exception.printStackTrace();
            }
          }
        });
  }

  //  private void increaseSpeedEvent() {
  //    increaseSpeed.addActionListener(new ActionListener() {
  //      @Override
  //      public void actionPerformed(ActionEvent e) {
  //        try {
  //          v.increaseSpeed();
  //        } catch (OperationNotSupportedException exception) {
  //          exception.printStackTrace();
  //        }
  //      }
  //    });
  //  }
  //
  //  private void decreaseSpeedEvent() {
  //    decreaseSpeed.addActionListener(new ActionListener() {
  //      @Override
  //      public void actionPerformed(ActionEvent e) {
  //        try {
  //          v.decreaseSpeed();
  //        } catch (OperationNotSupportedException exception) {
  //          exception.printStackTrace();
  //        }
  //      }
  //    });

  public void setListeners(ActionListener l) {
    playPause.addActionListener(l);
    reset.addActionListener(l);
    changeSpeed.addActionListener(l);
    loop.addActionListener(l);
  }
}
