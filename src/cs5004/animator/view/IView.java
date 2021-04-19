package cs5004.animator.view;

import javax.naming.OperationNotSupportedException;

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
   * Play the animation from the current frame.
   *
   * @throws OperationNotSupportedException if the operation is called on a view type that does not
   *     support this functionality.
   */
  void play() throws OperationNotSupportedException;

  /**
   * Pause the animation.
   *
   * @throws OperationNotSupportedException if the operation is called on a view type that does not
   *     * support this functionality.
   */
  void pause() throws OperationNotSupportedException;

  /**
   * Play the animation from a specified frame.
   *
   * @param frame the starting frame.
   * @param reverse true if the animation is to be played in reverse.
   * @throws OperationNotSupportedException if the operation is called on a view type that does not
   *     support this functionality.
   */
  void playFromFrame(float frame, boolean reverse) throws OperationNotSupportedException;

  /**
   * Returns the string representation of the text to be outputted.
   *
   * @return text to output
   * @param delay the delay (in ms) between each frame.
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
