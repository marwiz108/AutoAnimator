package model.transformation;
import model.shape.Shape;
import java.awt.*;

/**
 * Changes the color of a Shape over a specified range of frames.
 */
public class ChangeColorT extends AbstractTransformation {

  private Color startColor;
  private Color endColour;

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
    this.startColor = initialColor;
    this.endColour = finalColor;
  }

  @Override
  public Shape executeAtFrame(int frame) {
    int newR = this.getValueAtFrame(frame, this.startColor.getRed(), this.endColour.getRed());
    int newG = this.getValueAtFrame(frame, this.startColor.getBlue(), this.endColour.getBlue());
    int newB = this.getValueAtFrame(frame, this.startColor.getGreen(), this.endColour.getGreen());
    this.shape.setColor(newR, newG, newB);

    return this.shape;
  }
}
