package cs5004.animator.view;

import javax.naming.OperationNotSupportedException;

import cs5004.animator.controller.Features;

/** General interface for a view that supports both visual and textual behavior. */
public interface IView {
  /**
   * Set up the frame.
   *
   * @param delay the delay in milliseconds between each frame.
   * @throws OperationNotSupportedException if the operation is called on a view type that does not
   *     support this functionality.
   */
  void createAndShow(int delay) throws OperationNotSupportedException;

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

  /**
   * Returns the string representation of the text to be outputted.
   *
   * @param delay the delay (in ms) between each frame.
   * @return text to output.
   * @throws OperationNotSupportedException if the operation is called on a view type that does not
   *     support this functionality.
   */
  String generateText(float delay) throws OperationNotSupportedException;

  /**
   * Creates the JFrame and JPanel for the view.
   *
   * @throws OperationNotSupportedException if the operation is called on a view type that does not
   *     support this functionality.
   */
  void createFile(String filename) throws OperationNotSupportedException;
}
