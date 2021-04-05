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

  /**
   * Constructor for MoveT that takes int arguments for position.
   *
   * @param shape      the initial Shape object.
   * @param startFrame the starting frame.
   * @param endFrame   the ending frame object.
   * @param initialX   the initial x position of the Shape.
   * @param initialY   the initial y position of the Shape.
   * @param finalX     the final x position of the Shape.
   * @param finalY     the final y position of the Shape.
   */
  public MoveT(Shape shape, int startFrame, int endFrame, int initialX, int initialY,
               int finalX, int finalY) {
    super(shape, startFrame, endFrame);
    this.startPos = new Point2D(initialX, initialY);
    this.endPos = new Point2D(finalX, finalY);
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
    float newX = this.getValueAtFrame(frame, this.startPos.getX(), this.endPos.getX());
    float newY = this.getValueAtFrame(frame, this.startPos.getY(), this.endPos.getY());
    Shape shapeAtFrame = this.shape.copy();
    shapeAtFrame.setPosition(newX, newY);

    return shapeAtFrame;
  }
}
