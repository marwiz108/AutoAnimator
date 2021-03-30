package model.transformation;

import model.shape.Shape;

/**
 * Abstract class for the Transformation interface that contains common functionality for
 * all Transformation objects.
 */
public abstract class AbstractTransformation implements Transformation {

  private final Shape shape;
  private final int startFrame;
  private final int endFrame;

  /**
   * Super constructor for all extending classes.
   * @param shape the shape object that this transformation acts upon.
   * @param startFrame the frame where the transformation starts.
   * @param endFrame the frame where the transformation ends.
   */
  public AbstractTransformation(Shape shape, int startFrame, int endFrame) {
    this.shape = shape;
    this.startFrame = startFrame;
    this.endFrame = endFrame;
  }

}
