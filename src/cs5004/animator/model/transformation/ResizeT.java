package cs5004.animator.model.transformation;

import cs5004.animator.model.shape.Shape;

/** Changes the size of a Shape over a specified range of frames. */
public class ResizeT extends AbstractTransformation<Float> {

  private final dimension baseOrHeight;
  private final float initialValue;
  private final float finalValue;

  /**
   * Constructor for the ResizeT class.
   *
   * @param shape the initial Shape object.
   * @param startFrame the starting frame of the transformation.
   * @param endFrame the ending frame of the transformation.
   * @param initialValue the initial magnitude of the base or height.
   * @param finalValue the final magnitude of the base or height.
   */
  public ResizeT(
      Shape shape,
      int startFrame,
      int endFrame,
      dimension dimension,
      float initialValue,
      float finalValue) {
    super(shape, startFrame, endFrame);
    this.baseOrHeight = dimension;
    this.initialValue = initialValue;
    this.finalValue = finalValue;
  }

  /**
   * Helper function for toString that creates a detailed message about Base and Height of the
   * Shape.
   *
   * @param base The Base of the Shape.
   * @param height the Height of the Shape.
   * @return String message to be used in toString.
   */
  private String toStringHelp(float base, float height) {
    return String.format("Base: %.1f, Height: %.1f", base, height);
  }

  /**
   * Get the dimension that this Resize Transformation is acting upon.
   *
   * @return BASE or HEIGHT.
   */
  public dimension getDimension() {
    return baseOrHeight;
  }

  @Override
  public String toString() {
    String pre = toStringHelp(this.shape.getBase(), this.shape.getHeight());
    String post;
    if (this.baseOrHeight == dimension.HEIGHT) {
      post = toStringHelp(this.shape.getBase(), finalValue);
    } else {
      post = toStringHelp(finalValue, this.shape.getHeight());
    }
    return super.toString("Scales", pre, post);
  }

  @Override
  public TransformationType getType() {
    return TransformationType.Resize;
  }

  @Override
  public Float executeAtFrame(float frame) {
    if (frame < 0) {
      throw new IllegalArgumentException("Frame cannot be negative.");
    }
    return this.getValueAtFrame(frame, this.initialValue, this.finalValue);
  }
}
