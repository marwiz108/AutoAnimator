package cs5004.animator.view;

import cs5004.animator.controller.Features;
import cs5004.animator.view.visual.AnimationPanel;

/** Interface for a view that supports user interaction through a GUI. */
public interface GUIView {

  /**
   * Returns the animation panel object.
   *
   * @return animation panel
   */
  AnimationPanel getAnimationPanel();

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

  void showSaveControls();

  /**
   * Sets the speed (in fps) of the animation.
   *
   * @param fps frames per second.
   */
  void setSpeed(int fps);

  void saveFile(String ext);
}
