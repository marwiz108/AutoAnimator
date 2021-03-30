package model.transformation;

import model.shape.Shape;

/**
 * Moves a Shape from one position to another over a specified number of frames.
 */
public class MoveT extends AbstractTransformation {

  // ADD: Fields that represent starting and ending position.

  /**
   * Constructor for the MoveT class.
   * @param shape the initial Shape object.
   * @param startFrame the starting frame of the transformation.
   * @param endFrame the ending frame of the transformation.
   */
  public MoveT(Shape shape, int startFrame, int endFrame) {
    super(shape, startFrame, endFrame);
  }

  @Override
  public Shape executeAtFrame(int frame) {
    return null;
  }
}
