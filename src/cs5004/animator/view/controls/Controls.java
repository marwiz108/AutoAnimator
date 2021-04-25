package cs5004.animator.view.controls;

import javax.naming.OperationNotSupportedException;

import cs5004.animator.controller.Features;

/** Interface for animation controls. */
public interface Controls {
  /**
   * Set the speed of the animation in frames per second.
   *
   * @param newFPS the frames per second of the animaiton.
   * @throws OperationNotSupportedException if the method is called by a class that does not support
   *     this operation.
   */
  void setFps(int newFPS) throws OperationNotSupportedException;

  /**
   * Show the speed control panel.
   *
   * @throws OperationNotSupportedException if the method is called by a class that does not support
   *     this operation.
   */
  void showSpeedControls() throws OperationNotSupportedException;

  /**
   * Change the title of the play/pause button depending on the state of the animation.
   *
   * @param title title of the play/pause button (Play or Pause).
   * @throws OperationNotSupportedException if the method is called by a class that does not support
   *     this operation.
   */
  void updatePlayPauseTitle(String title) throws OperationNotSupportedException;

  /**
   * Add action listeners that tell the controller to call the corresponding function in the view.
   *
   * @param features Controller object that handles the GUI.
   */
  void addFeatures(Features features);
}
