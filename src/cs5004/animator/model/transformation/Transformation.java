package cs5004.animator.model.transformation;

/**
 * Transformation interface that defines behavior shared by all transformation objects. A
 * transformation has one Shape and must be able to determine the state of that Shape at any given
 * (viable) frame number.
 */
public interface Transformation<T> {

  /**
   * Get the type of Transformation.
   *
   * @return the type of the Transformation object.
   */
  TransformationType getType();

  /**
   * Used in resize to tell if the base or the height will be changed.
   *
   * @return base or height.
   */
  dimension getDimension();

  /**
   * Determine the state (position, visibility, size, or color) of the Shape object at the current
   * frame.
   *
   * @param frame the frame to be rendered.
   * @return the result of the transformation at a given frame. Will be used to set the Shape state
   *     at the given frame. Note: the return type is different for each subclass and must be cast
   *     to the appropriate data type to work properly.
   * @throws IllegalArgumentException if the given frame is negative.
   */
  T executeAtFrame(float frame) throws IllegalArgumentException;

  /**
   * Return the starting frame of the transformation.
   *
   * @return the start frame.
   */
  float getStartFrame();

  /**
   * Return the ending frame of the transformation.
   *
   * @return the end frame.
   */
  float getEndFrame();

  /**
   * Determine the the value of some parameter at a given frame.
   *
   * @param frame the frame to calculate the value at.
   * @param initialValue The starting value of the parameter.
   * @param finalValue the ending value of the parameter.
   * @return the value the parameter will have at the given frame.
   * @throws IllegalArgumentException if the frame is negative.
   */
  float getValueAtFrame(float frame, float initialValue, float finalValue)
      throws IllegalArgumentException;
}
