package cs5004.animator.model.transformation;

import cs5004.animator.model.shape.Shape;

/** Transformation that changes the visibility of a Shape at the appropriate frame(s). */
public class ChangeVisibilityT extends AbstractTransformation<Boolean> {

  /**
   * Constructor for the ChangeVisibilityT class.
   *
   * @param shape the initial Shape object.
   * @param startFrame the starting frame of the transformation.
   * @param endFrame the ending frame of the transformation.
   */
  public ChangeVisibilityT(Shape shape, float startFrame, float endFrame) {
    super(shape, startFrame, endFrame);
  }

  @Override
  public String toString() {
    return String.format(
        "Shape %s appears at t=%.2f and disappears at t=%.2f",
        this.initialShape.getIdentifier(), this.startFrame, this.endFrame);
  }

  @Override
  public String toSVGString(String type, float delay) {
    // TODO this
    return "";
  }

  @Override
  public TransformationType getType() {
    return TransformationType.ChangeVis;
  }

  /**
   * Implementation of ExecuteAtFrame for a ChangeVisibilityT Transformation.
   *
   * @param s the shape object.
   * @param frame the frame to be rendered.
   * @return true if the shape is visible, false otherwise.
   */
  @Override
  public Boolean executeAtFrame(Shape s, float frame) {
    if (frame < 0) {
      throw new IllegalArgumentException("Frame cannot be negative.");
    }
    return frame >= this.startFrame && frame < this.endFrame;
  }
}
