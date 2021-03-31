package model.transformation;
import model.shape.Shape;
/**
 * Changes the size of a Shape over a specified range of frames.
 */
public class ResizeT extends AbstractTransformation {

  private enum Dimension {
    BASE, HEIGHT;
  }
  private final Dimension baseOrHeight;
  private final int initialValue;
  private final int finalValue;

  /**
   * Constructor for the ResizeT class.
   * @param shape the initial Shape object.
   * @param startFrame the starting frame of the transformation.
   * @param endFrame the ending frame of the transformation.
   */
  public ResizeT(Shape shape, int startFrame, int endFrame, Dimension dimension,
                 int initialValue, int finalValue) {
    super(shape, startFrame, endFrame);
    this.baseOrHeight = dimension;
    this.initialValue = initialValue;
    this.finalValue = finalValue;
  }

  @Override
  public Shape executeAtFrame(int frame) {
    int newValue = this.getValueAtFrame(frame, this.initialValue, this.finalValue);
    Shape shapeCopy = this.shape.copy();
    if (this.baseOrHeight == Dimension.BASE) {
      shapeCopy.resize(newValue, shapeCopy.getHeight());
    } else {
      shapeCopy.resize(shapeCopy.getBase(), newValue);
    }
    return shapeCopy;
  }
}
