package cs5004.animator.view.visual;

import cs5004.animator.view.IView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.naming.OperationNotSupportedException;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

public class GUIPanel extends JPanel implements ActionListener {
  // TODO get these buttons to do something
  private final JButton playPause = new JButton("Play/Pause");
  private final JButton reset = new JButton("Reset");
  private final JButton increaseSpeed = new JButton("( + )");
  private final JButton decreaseSpeed = new JButton("( - )");
  private final JCheckBox loop = new JCheckBox("Loop");
  private IView v;

  private final JButton[] buttons = {playPause, reset, increaseSpeed, decreaseSpeed};

  public GUIPanel(IView view, int x, int y, int borderWidth) {
    super();
    this.v = view;
    this.setBounds(x, y, borderWidth, 100);
    int initialOffset = (int) ((borderWidth * 0.9) / 5);
    int offset = initialOffset;
    int width = (int) (offset * 0.9);
    for (JButton b : this.buttons) {
      b.setOpaque(true);
      b.setBounds(x + offset, y - 25, width, 50);
      offset = offset + initialOffset;
    }
    loop.setBounds(x + offset, y - 25, width, 50);

    playPauseEvent();
    resetEvent();
    increaseSpeedEvent();
    decreaseSpeedEvent();

    add(reset);
    add(decreaseSpeed);
    add(playPause);
    add(increaseSpeed);
    add(loop);
    setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {}

  private void playPauseEvent() {
    playPause.addActionListener(new ActionListener() {
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
    reset.addActionListener(new ActionListener() {
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

  private void increaseSpeedEvent() {
    increaseSpeed.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        try {
          v.increaseSpeed();
        } catch (OperationNotSupportedException exception) {
          exception.printStackTrace();
        }
      }
    });
  }

  private void decreaseSpeedEvent() {
    decreaseSpeed.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        try {
          v.decreaseSpeed();
        } catch (OperationNotSupportedException exception) {
          exception.printStackTrace();
        }
      }
    });
  }
}
