package cs5004.animator.model.transformation;

import java.awt.Color;

import cs5004.animator.model.shape.Shape;

/** Changes the color of a Shape over a specified range of frames. */
public class ChangeColorT extends AbstractTransformation<int[]> {

  private final Color startColor;
  private final Color endColor;

  /**
   * Constructor for the ChangeColorT class that takes Color objects as parameters.
   *
   * @param shape the initial Shape object.
   * @param startFrame the starting frame of the transformation.
   * @param endFrame the ending frame of the transformation.
   * @param initialColor the starting color of the Shape.
   * @param finalColor the ending color of the Shape.
   */
  public ChangeColorT(
      Shape shape, int startFrame, int endFrame, Color initialColor, Color finalColor) {
    super(shape, startFrame, endFrame);
    this.startColor = initialColor;
    this.endColor = finalColor;
  }

  /**
   * Secondary constructor for ChangeColorT that takes initial/final Color rgb values as ints.
   *
   * @param shape initial Shape object.
   * @param startFrame the frame where this transformation starts.
   * @param endFrame the final frame of the transformation.
   * @param initialR the initial red value (0 - 255).
   * @param initialG the initial green value (0 - 255).
   * @param initialB the initial blue value (0 - 255).
   * @param finalR the final red value (0 - 255).
   * @param finalG the final green value (0 - 255).
   * @param finalB the final blue value (0 - 255).
   */
  public ChangeColorT(
      Shape shape,
      int startFrame,
      int endFrame,
      int initialR,
      int initialG,
      int initialB,
      int finalR,
      int finalG,
      int finalB) {
    super(shape, startFrame, endFrame);
    this.startColor = new Color(initialR, initialG, initialB);
    this.endColor = new Color(finalR, finalG, finalB);
  }

  /**
   * Helper function for toString.
   *
   * @param r the red value.
   * @param g the green value.
   * @param b the blue value.
   * @return string in the format (r, g, b).
   */
  private String toStringHelp(int r, int g, int b) {
    return String.format("(%d, %d, %d)", r, g, b);
  }

  @Override
  public String toString() {
    String start = toStringHelp(startColor.getRed(), startColor.getGreen(), startColor.getBlue());
    String end = toStringHelp(endColor.getRed(), endColor.getGreen(), endColor.getBlue());
    return super.toString("changes color", start, end);
  }

  @Override
  public String toSVGString(String type, float delay) {
    StringBuilder svgText = new StringBuilder();
    svgText.append(
        String.format(
            "\t\t<animate attributeName=\"fill\" "
                + "attributeType=\"XML\" from=\"rgb(%d, %d, %d)\" to=\"rgb(%d, %d, %d)\" "
                + "begin=\"%.1fms\" dur=\"%.1fms\" />\n",
            this.startColor.getRed(),
            this.startColor.getGreen(),
            this.startColor.getBlue(),
            this.endColor.getRed(),
            this.endColor.getGreen(),
            this.endColor.getBlue(),
            this.startFrame * delay,
            (this.endFrame - this.startFrame) * delay));

    return svgText.toString();
  }

  @Override
  public TransformationType getType() {
    return TransformationType.ChangeColor;
  }

  /**
   * Implementation of ExecuteAtFrame for a ChangeColorT Transformation.
   *
   * @param s
   * @param frame the frame to be rendered.
   * @return the r, g, b values of the Color in an int array in the format [r, g, b].
   */
  @Override
  public int[] executeAtFrame(Shape s, float frame) {
    if (frame < 0) {
      throw new IllegalArgumentException("Frame cannot be negative.");
    }
    int newR =
        (int)
            this.getValueAtFrame(
                frame, s.getColor().getRed(), this.startColor.getRed(), this.endColor.getRed());
    int newG =
        (int)
            this.getValueAtFrame(
                frame,
                s.getColor().getGreen(),
                this.startColor.getGreen(),
                this.endColor.getGreen());
    int newB =
        (int)
            this.getValueAtFrame(
                frame, s.getColor().getBlue(), this.startColor.getBlue(), this.endColor.getBlue());

    return new int[] {newR, newG, newB};
  }
}
