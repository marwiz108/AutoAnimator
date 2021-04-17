package cs5004.animator.model.transformation;

import cs5004.animator.model.shape.Shape;

/**
 * Abstract class for the Transformation interface that contains common functionality for all
 * Transformation objects.
 */
public abstract class AbstractTransformation<T> implements Transformation<T> {

  // TODO abstract shapes should always look at the dynamic shape Hashmap in canvas
  protected final Shape initialShape;
  protected final float startFrame;
  protected final float endFrame;

  /**
   * Super constructor for all extending classes.
   *
   * @param shape the shape object that this transformation acts upon.
   * @param startFrame the frame where the transformation starts.
   * @param endFrame the frame where the transformation ends.
   */
  public AbstractTransformation(Shape shape, int startFrame, int endFrame)
      throws IllegalArgumentException {
    if (shape == null || startFrame < 0 || endFrame < 0) {
      throw new IllegalArgumentException("Invalid values for Transformation constructor.");
    }
    if (Math.abs(endFrame - startFrame) < 0.001) {
      throw new IllegalArgumentException("Start and end frame must be different.");
    }
    if (startFrame > endFrame) {
      throw new IllegalArgumentException("Start frame must come before end frame.");
    }
    this.initialShape = shape.copy();
    this.startFrame = startFrame;
    this.endFrame = endFrame;
  }

  /**
   * Function that creates a String representation of an abstract Transformation. Must be called by
   * a child class to fill in missing information.
   *
   * @param action the "kind" of transformation the child class is (move, resize, etc).
   * @param startVal The starting value of the Shape's appropriate field at the beginning of the
   *     Transformation.
   * @param endVal the final value of the Shape's appropriate field at the end of the
   *     Transformation.
   * @return String representation.
   */
  protected String toString(String action, String startVal, String endVal) {
    String id = this.initialShape.getIdentifier();
    return String.format(
        "Shape %s %s from %s to %s from t=%.2f to t=%.2f",
        id, action, startVal, endVal, this.startFrame, this.endFrame);
  }

  @Override
  public dimension getDimension() {
    return null;
  }

  @Override
  public float getStartFrame() {
    return this.startFrame;
  }

  @Override
  public float getEndFrame() {
    return this.endFrame;
  }

  @Override
  public boolean hasConflictingTransformation(Transformation newT) {
    if (this.getType() == newT.getType()) {
      if ((newT.getStartFrame() >= this.startFrame && newT.getStartFrame() < this.endFrame)
          || newT.getStartFrame() <= this.endFrame) {
        return true;
      }
    }
    return false;
  }

  @Override
  public float getValueAtFrame(
      float frame, float currentValue, float initialValue, float finalValue)
      throws IllegalArgumentException {
    if (frame < 0) {
      throw new IllegalArgumentException("Frame cannot be negative.");
    }
    if (frame < this.startFrame) {
      // TODO Fix so this returns the CURRENT value
      return currentValue;
    }
    if (frame > this.endFrame) {
      return finalValue;
    }
    float a = initialValue * ((this.endFrame - frame) / (this.endFrame - this.startFrame));
    float b = finalValue * ((frame - this.startFrame) / (this.endFrame - this.startFrame));
    return a + b;
  }
}
