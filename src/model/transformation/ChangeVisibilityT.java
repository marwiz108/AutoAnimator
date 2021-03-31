package model.transformation;

import model.shape.Shape;

/**
 * Transformation that changes the visibility of a Shape at the appropriate frame(s).
 */
public class ChangeVisibilityT extends AbstractTransformation {


  /**
   * Constructor for the ChangeVisibilityT class.
   * @param shape the initial Shape object.
   * @param startFrame the starting frame of the transformation.
   * @param endFrame the ending frame of the transformation.
   */
  public ChangeVisibilityT(Shape shape, int startFrame, int endFrame) {
    super(shape, startFrame, endFrame);
  }

  @Override
  public Shape executeAtFrame(int frame) {
    for (int f = 0; f <= this.endFrame; f++) {
      if (f >= this.startFrame) {
        this.shape.setVisibility(true);
      }
      if (f == this.endFrame) {
        this.shape.setVisibility(false);
      }
    }
    return this.shape;
  }
}
