package model.transformation;
import model.shape.Point2D;
import model.shape.Shape;
/**
 * Moves a Shape from one position to another over a specified number of frames.
 */
public class MoveT extends AbstractTransformation {

  Point2D startPos;
  Point2D endPos;

  /**
   * Constructor for the MoveT class.
   * @param shape the initial Shape object.
   * @param startFrame the starting frame of the transformation.
   * @param endFrame the ending frame of the transformation.
   */
  public MoveT(Shape shape, int startFrame, int endFrame, Point2D startPos, Point2D endPos) {
    super(shape, startFrame, endFrame);
    this.startPos = startPos;
    this.endPos = endPos;
  }

  @Override
  public String toString() {
    return super.toString("moves",
            this.startPos.toString(), this.endPos.toString());
  }

  @Override
  public Shape executeAtFrame(int frame) {
    if (frame < 0) {
      throw new IllegalArgumentException("Frame cannot be negative.");
    }
    int newX = this.getValueAtFrame(frame, this.startPos.getX(), this.endPos.getX());
    int newY = this.getValueAtFrame(frame, this.startPos.getY(), this.endPos.getY());
    this.shape.setPosition(newX, newY);

    return this.shape;
  }
}
