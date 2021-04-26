package cs5004.animator.view.controls;

import java.awt.FlowLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.naming.OperationNotSupportedException;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;

import cs5004.animator.controller.Features;

/** Window that allows a user to save an animation. */
public class SaveControls extends JFrame implements Controls {
  private final JButton saveSVG = new JButton("Save as .SVG");
  private final JButton saveTxt = new JButton("Save as .txt");
  private final JTextField filename = new JTextField("Enter filename");
  private String name;

  public SaveControls() {
    setLayout(new FlowLayout());
    add(filename);
    add(saveSVG);
    add(saveTxt);
    pack();
    setDefaultCloseOperation(HIDE_ON_CLOSE);
    setVisible(false);
  }

  @Override
  public String getFilename() {
    return name;
  }

  @Override
  public void addFeatures(Features features) {
    filename.addFocusListener(
        new FocusListener() {
          @Override
          public void focusGained(FocusEvent e) {}

          @Override
          public void focusLost(FocusEvent e) {
            name = filename.getText();
          }
        });
    saveSVG.addActionListener(l -> features.saveAsSVG());
    saveTxt.addActionListener(l -> features.saveAsTxt());
  }

  @Override
  public void setFps(int newFPS) throws OperationNotSupportedException {
    throw new OperationNotSupportedException("Not supported");
  }

  @Override
  public void showSpeedControls() throws OperationNotSupportedException {
    throw new OperationNotSupportedException("Not supported");
  }

  @Override
  public void updatePlayPauseTitle(String title) throws OperationNotSupportedException {
    throw new OperationNotSupportedException("Not supported");
  }
}
