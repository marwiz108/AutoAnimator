package cs5004.animator.view;

import javax.naming.OperationNotSupportedException;

import cs5004.animator.controller.Features;

public interface GUIView {
  /**
   * Reset the animation to the first frame.
   *
   * @throws OperationNotSupportedException if the operation is called on a view type that does not
   *     * support this functionality.
   */
  void reset() throws OperationNotSupportedException;

  /**
   * Add ActionListeners to buttons and hook up the controller.
   *
   * @param features Controller object that handles the GUI.
   * @throws OperationNotSupportedException if called by a view that does not support this method.
   */
  void addFeatures(Features features) throws OperationNotSupportedException;

  /**
   * Toggles looping in the animation.
   *
   * @throws OperationNotSupportedException if called by a view that does not support this method.
   */
  void toggleLoop() throws OperationNotSupportedException;

  /**
   * Plays or pauses the animation.
   *
   * @throws OperationNotSupportedException if called by a view that does not support this method.
   */
  void playPause() throws OperationNotSupportedException;

  /**
   * Shows the speed control panel.
   *
   * @throws OperationNotSupportedException if called by a view that does not support this method.
   */
  void showSpeedControls() throws OperationNotSupportedException;

  /**
   * Sets the speed (in fps) of the animation.
   *
   * @param fps frames per second.
   */
  void setSpeed(int fps) throws OperationNotSupportedException;
}
