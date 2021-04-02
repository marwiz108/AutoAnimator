package model.transformation;
import model.shape.Shape;
/**
 * Changes the size of a Shape over a specified range of frames.
 */
public class ResizeT extends AbstractTransformation {

  private String toStringHelp(float base, float height) {
    return String.format("Base: %.1f, Height: %.1f", base, height);
  }

  private final Dimension baseOrHeight;
  private final int initialValue;
  private final int finalValue;

  /**
   * Constructor for the ResizeT class.
   *
   * @param shape      the initial Shape object.
   * @param startFrame the starting frame of the transformation.
   * @param endFrame   the ending frame of the transformation.
   */
  public ResizeT(Shape shape, int startFrame, int endFrame, Dimension dimension,
                 int initialValue, int finalValue) {
    super(shape, startFrame, endFrame);
    this.baseOrHeight = dimension;
    this.initialValue = initialValue;
    this.finalValue = finalValue;
  }

  public enum Dimension {
    BASE, HEIGHT
  }

  @Override
  public String toString() {
    String pre = toStringHelp(this.shape.getBase(), this.shape.getHeight());
    String post;
    if (this.baseOrHeight == Dimension.HEIGHT) {
      post = toStringHelp(this.shape.getBase(), finalValue);
    } else {
      post = toStringHelp(finalValue, this.shape.getHeight());
    }
    return super.toString("Scales", pre, post);
  }

  @Override
  public Shape executeAtFrame(int frame) {
    if (frame < 0) {
      throw new IllegalArgumentException("Frame cannot be negative.");
    }
    int newValue = this.getValueAtFrame(frame, this.initialValue, this.finalValue);
    if (this.baseOrHeight == Dimension.BASE) {
      this.shape.resize(newValue, this.shape.getHeight());
    } else {
      this.shape.resize(this.shape.getBase(), newValue);
    }
    return this.shape;
  }
}
