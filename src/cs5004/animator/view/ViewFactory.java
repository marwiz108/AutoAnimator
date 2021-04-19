package cs5004.animator.view;

/** Factory that creates a view based on user input. */
public interface ViewFactory {

  /**
   * Create a text view or svg view.
   *
   * @param viewType the type of view to create.
   * @param outFile the filename where the output will go.
   * @param delay the delay between frames of the animation.
   * @return The view object.
   */
  IView create(String viewType, String outFile, float delay);
}
