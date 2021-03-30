package model.transformation;

import model.shape.Shape;

/**
 * Transformation interface that defines behavior shared by all transformation objects.
 * A transformation has one Shape and must be able to determine the state of that Shape
 * at any given (viable) frame number.
 */
public interface Transformation {

  /**
   * Determine the state (position, visibility, size, or color) of the Shape object at
   * the current frame.
   * @param frame the frame to be rendered.
   * @return A COPY of the original shape object that reflects results of the transformation
   * at the given frame.
   */
  Shape executeAtFrame(int frame);

  int getValueAtFrame(int frame, int initialValue, int finalValue);

}
