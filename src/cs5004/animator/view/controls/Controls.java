package cs5004.animator.view.controls;

import javax.naming.OperationNotSupportedException;

import cs5004.animator.controller.Features;

public interface Controls {
  void setFps(int newFPS) throws OperationNotSupportedException;

  void showSpeedControls() throws OperationNotSupportedException;

  void updatePlayPauseTitle(String title) throws OperationNotSupportedException;

  void addFeatures(Features features);
}
