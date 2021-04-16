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
  public String toSVGString() {
    StringBuilder svgText = new StringBuilder();
    svgText.append(
        String.format(
            "<animate attributeName=\"x\" "
                + "attributeType=\"XML\" from=\"%.1f\" to=\"%.1f\" begin=\"%.1f\" dur=\"%.1fs\" />\n",
            this.startPos.getX(),
            this.endPos.getX(),
            this.startFrame,
            this.endFrame - this.startFrame));
    svgText.append(
        String.format(
            "<animate attributeName=\"y\" "
                + "attributeType=\"XML\" from=\"%.1f\" to=\"%.1f\" begin=\"%.1f\" dur=\"%.1fs\" />",
            this.startPos.getY(),
            this.endPos.getY(),
            this.startFrame,
            this.endFrame - this.startFrame));

    return svgText.toString();
  }

  @Override
  public TransformationType getType() {
    return TransformationType.Move;
  }

  @Override
  public boolean hasConflictingTransformation(Transformation newT) {
    //    newT = (MoveT)newT;
    if (Math.abs(this.endPos.getX() - this.startPos.getX()) > 0
        && Math.abs(this.endPos.getY() - this.startPos.getY()) == 0) {
      return Math.abs(((MoveT) newT).endPos.getX() - ((MoveT) newT).startPos.getX()) > 0;
    } else if (Math.abs(this.endPos.getX() - this.startPos.getX()) == 0
        && Math.abs(this.endPos.getY() - this.endPos.getY()) > 0) {
      return Math.abs(((MoveT) newT).endPos.getY() - ((MoveT) newT).endPos.getY()) > 0;
    } else
      return Math.abs(this.endPos.getX() - this.startPos.getX()) > 0
          && Math.abs(this.endPos.getY() - this.startPos.getY()) > 0;
  }

  /**
   * Implementation of ExecuteAtFrame for a MoveT Transformation.
   *
   * @param s
   * @param frame the frame to be rendered.
   * @return an array of Floats that represents the position in [x, y] format.
   */
  @Override
  public float[] executeAtFrame(Shape s, float frame) {
    if (frame < 0) {
      throw new IllegalArgumentException("Frame cannot be negative.");
    }
    float newX =
        this.getValueAtFrame(
            frame, s.getPosition().getX(), this.startPos.getX(), this.endPos.getX());
    float newY =
        this.getValueAtFrame(
            frame, s.getPosition().getY(), this.startPos.getY(), this.endPos.getY());

    return new float[] {newX, newY};
  }
}
