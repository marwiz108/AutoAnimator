package model.transformation;
import model.shape.Shape;
import java.awt.*;

/**
 * Changes the color of a Shape over a specified range of frames.
 */
public class ChangeColorT extends AbstractTransformation {


  /**
   * Constructor for the ChangeColorT class.
   * @param shape the initial Shape object.
   * @param startFrame the starting frame of the transformation.
   * @param endFrame the ending frame of the transformation.
   * @param initialColor the starting color of the Shape.
   * @param finalColor the ending color of the Shape.
   */
  public ChangeColorT(Shape shape, int startFrame, int endFrame,
                      Color initialColor, Color finalColor) {
    super(shape, startFrame, endFrame);
  }

  @Override
  public Shape executeAtFrame(int frame) {
    return null;
  }
}
