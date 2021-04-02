package model.transformation;

import model.shape.Shape;

/**
 * Abstract class for the Transformation interface that contains common functionality for
 * all Transformation objects.
 */
public abstract class AbstractTransformation implements Transformation {

  protected final Shape shape;
  protected final int startFrame;
  protected final int endFrame;

  /**
   * Super constructor for all extending classes.
   * @param shape the shape object that this transformation acts upon.
   * @param startFrame the frame where the transformation starts.
   * @param endFrame the frame where the transformation ends.
   */
  public AbstractTransformation(Shape shape, int startFrame, int endFrame)
          throws IllegalArgumentException{
    if (shape == null || startFrame < 0 || endFrame < 0) {
      throw new IllegalArgumentException("Invalid values for Transformation constructor.");
    }
    this.shape = shape.copy();
    this.startFrame = startFrame;
    this.endFrame = endFrame;
  }

  protected String toString(String action, String startVal, String endVal) {
    String id = this.shape.getIdentifier();
    return String.format("Shape %s %s from %s to %s from t=%d to t=%d",
            id, action, startVal, endVal, this.startFrame, this.endFrame);
  }

  @Override
  public int getValueAtFrame(int frame, float initialValue, float finalValue)
          throws IllegalArgumentException {
    if (frame < 0) {
      throw new IllegalArgumentException("Frame cannot be negative.");
    }
    double diff = finalValue - initialValue;
    double range = this.endFrame - this.startFrame;
    double step = diff / range;
    double acc = initialValue;
    for (int f = 0; f < this.endFrame; f++) {
      if (f >= this.startFrame) {
        acc += step;
      }
      if (f == frame) {
        break;
      }
    }
    return (int) acc;
  }

}
