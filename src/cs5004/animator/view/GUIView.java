package cs5004.animator.view;

import cs5004.animator.controller.Features;

public interface GUIView {
  /** Reset the animation to the first frame. */
  void reset();

  /**
   * Add ActionListeners to buttons and hook up the controller.
   *
   * @param features Controller object that handles the GUI.
   */
  void addFeatures(Features features);

  /** Toggles looping in the animation. */
  void toggleLoop();

  /** Plays or pauses the animation. */
  void playPause();

  /** Shows the speed control panel. */
  void showSpeedControls();

  /**
   * Sets the speed (in fps) of the animation.
   *
   * @param fps frames per second.
   */
  void setSpeed(int fps);
}
