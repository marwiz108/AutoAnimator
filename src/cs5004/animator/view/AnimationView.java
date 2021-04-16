package cs5004.animator.view;

/** Interface for an animation view. */
public interface AnimationView {

  /**
   * Set up the frame.
   *
   * @param delay the delay in milliseconds between each frame.
   */
  void createAndShow(int delay);

  /** Reset the animation to the first frame. */
  void reset();

  /** Play the animation from the current frame. */
  void play();

  /** Pause the animation. */
  void pause();

  /**
   * Play the animation from a specified frame.
   *
   * @param frame the starting frame.
   * @param reverse true if the animation is to be played in reverse.
   */
  void playFromFrame(float frame, boolean reverse);
}
