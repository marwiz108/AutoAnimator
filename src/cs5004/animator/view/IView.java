package cs5004.animator.view;

import javax.naming.OperationNotSupportedException;

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
