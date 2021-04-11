package cs5004.animator.model.transformation;

import cs5004.animator.model.shape.Point2D;
import cs5004.animator.model.shape.Shape;

/** Moves a Shape from one position to another over a specified number of frames. */
public class MoveT extends AbstractTransformation<float[]> {

  private final Point2D startPos;
  private final Point2D endPos;

  /**
   * Constructor for a MoveT Transformation.
   *
   * @param shape the Shape object of the Transformation.
   * @param startFrame the first frame of the Transformation.
   * @param endFrame the last frame of the Transformation.
   * @param startPos the starting location of the reference point of the Shape.
   * @param endPos the ending location of the reference point of the Shape.
   */
  public MoveT(Shape shape, int startFrame, int endFrame, Point2D startPos, Point2D endPos) {
    super(shape, startFrame, endFrame);
    this.startPos = startPos;
    this.endPos = endPos;
  }

  /**
   * Constructor for MoveT that takes int arguments for position.
   *
   * @param shape the initial Shape object.
   * @param startFrame the starting frame.
   * @param endFrame the ending frame object.
   * @param initialX the initial x position of the Shape.
   * @param initialY the initial y position of the Shape.
   * @param finalX the final x position of the Shape.
   * @param finalY the final y position of the Shape.
   */
  public MoveT(
      Shape shape,
      int startFrame,
      int endFrame,
      float initialX,
      float initialY,
      float finalX,
      float finalY) {
    super(shape, startFrame, endFrame);
    this.startPos = new Point2D(initialX, initialY);
    this.endPos = new Point2D(finalX, finalY);
  }

  @Override
  public String toString() {
    return super.toString("moves", this.startPos.toString(), this.endPos.toString());
  }

  @Override
  public TransformationType getType() {
    return TransformationType.Move;
  }

  /**
   * Implementation of ExecuteAtFrame for a MoveT Transformation.
   *
   * @param frame the frame to be rendered.
   * @return an array of Floats that represents the position in [x, y] format.
   */
  @Override
  public float[] executeAtFrame(int frame) {
    if (frame < 0) {
      throw new IllegalArgumentException("Frame cannot be negative.");
    }
    float newX = this.getValueAtFrame(frame, this.startPos.getX(), this.endPos.getX());
    float newY = this.getValueAtFrame(frame, this.startPos.getY(), this.endPos.getY());

    return new float[] {newX, newY};
  }
}
