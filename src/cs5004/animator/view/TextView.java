package cs5004.animator.view;

/**
 * This interface represents a Text view. The TextView is responsible for displaying the textual
 * view and the SVG view of the animation.
 */
public interface TextView {

  /**
   * Returns the string representation of the text to be outputted.
   *
   * @return text to output
   */
  String generateText();

  /** Creates the JFrame and JPanel for the view. */
  void createFile(String filename);

  /** Renders the output of the view onto the file/window. */
  void render();
}
