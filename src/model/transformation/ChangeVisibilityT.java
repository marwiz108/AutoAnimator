package model.transformation;

import model.shape.Shape;

/**
 * Transformation that changes the visibility of a Shape at the appropriate frame(s).
 */
public class ChangeVisibilityT extends AbstractTransformation<Boolean> {

  /**
   * Constructor for the ChangeVisibilityT class.
   *
   * @param shape      the initial Shape object.
   * @param startFrame the starting frame of the transformation.
   * @param endFrame   the ending frame of the transformation.
   */
  public ChangeVisibilityT(Shape shape, int startFrame, int endFrame) {
    super(shape, startFrame, endFrame);
  }

  @Override
  public String toString() {
    return String.format("Shape %s appears at t=%d and disappears at t=%d",
            this.shape.getIdentifier(), this.startFrame, this.endFrame);
  }

  @Override
  public Boolean executeAtFrame(int frame) {
    if (frame < 0) {
      throw new IllegalArgumentException("Frame cannot be negative.");
    }
    return frame >= this.startFrame && frame < this.endFrame;
  }
}
