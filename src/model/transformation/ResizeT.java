package model.transformation;

import model.shape.Shape;

/**
 * Changes the size of a Shape over a specified range of frames.
 */
public class ResizeT extends AbstractTransformation {

  // ADD: data about the starting and ending size of the shape. Maybe base/height?

  /**
   * Constructor for the ResizeT class.
   * @param shape the initial Shape object.
   * @param startFrame the starting frame of the transformation.
   * @param endFrame the ending frame of the transformation.
   */
  public ResizeT(Shape shape, int startFrame, int endFrame) {
    super(shape, startFrame, endFrame);
  }

  @Override
  public Shape executeAtFrame(int frame) {
    return null;
  }
}
