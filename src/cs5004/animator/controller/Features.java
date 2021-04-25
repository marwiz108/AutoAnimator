package cs5004.animator.controller;

/** Features that the controller for the animator should support. */
public interface Features {

  /** Play or pause the animation. */
  void playPauseEvent();

  /** Reset the animation to its original state. */
  void resetEvent();

  /** Tell the animation to loop (or stop looping). */
  void loopEvent();

  /** Show the speed controls panel. */
  void showSpeedControls();

  /**
   * Change the speed of the animation.
   *
   * @param fps the speed to set the animation to.
   */
  void changeSpeed(int fps);

  void showSaveControls();
}
