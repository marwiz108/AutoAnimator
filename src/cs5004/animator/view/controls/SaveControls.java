package cs5004.animator.view.controls;

import javax.naming.OperationNotSupportedException;
import javax.swing.*;

import cs5004.animator.controller.Features;

public class SaveControls extends JFrame implements Controls {
  private final JButton saveSVG = new JButton("Save as .SVG");
  private final JButton saveTxt = new JButton("Save as .txt");
  private final JTextField filename = new JTextField("Enter filename");

  public SaveControls() {
    add(filename);
    add(saveSVG);
    add(saveTxt);
    pack();
    setDefaultCloseOperation(HIDE_ON_CLOSE);
    setVisible(false);
  }

  @Override
  public void addFeatures(Features features) {}

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
