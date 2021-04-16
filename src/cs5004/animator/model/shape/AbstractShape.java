package cs5004.animator.model.shape;

import java.awt.*;
import java.util.ArrayList;

import cs5004.animator.model.transformation.Transformation;

/** Abstract class for a Shape object that stores common functionality for all shapes. */
public abstract class AbstractShape implements Shape {

  protected final String identifier;
  protected float base;
  protected float height;
  protected Point2D reference;
  protected ArrayList<Transformation> transformations;
  protected Color color;
  protected boolean visible;
  protected boolean isInitialized;

  /**
   * Constructor that is used to create an abstract shape. Is called by children of the
   * AbstractShape class.
   *
   * @param identifier The identifier that is used to find the Shape.
   * @param x the x-coordinate of the reference point.
   * @param y the y-coordinate of the reference point.
   * @param base the magnitude of the base of the shape.
   * @param height the magnitude of the height of the shape.
   * @param r the red value of the shape's color (0 <= r <= 255)
   * @param g the green value of the shape's color (0 <= g <= 255)
   * @param b the blue value of the shape's color (0 <= b <= 255)
   * @throws IllegalArgumentException if the base or height is negative, or if r, g, b are outside
   *     the allowed range.
   */
  public AbstractShape(
      String identifier, float x, float y, float base, float height, int r, int g, int b)
      throws IllegalArgumentException {
    if (base < 0 || height < 0) {
      throw new IllegalArgumentException("Shape dimensions must be positive.");
    }
    this.identifier = identifier;
    this.reference = new Point2D(x, y);
    this.base = base;
    this.height = height;
    this.setColor(r, g, b);
    this.visible = false;
    this.isInitialized = true;
    this.transformations = new ArrayList<>();
  }

  /**
   * Creates a shape with default (0) values.
   *
   * @param id the shape identifier.
   */
  public AbstractShape(String id) {
    this.identifier = id;
    this.reference = new Point2D(0, 0);
    this.base = 0;
    this.height = 0;
    this.setColor(0, 0, 0);
    this.visible = false;
    this.isInitialized = false;
    this.transformations = new ArrayList<>();
  }

  @Override
  public boolean isInitialized() {
    return this.isInitialized;
  }

  @Override
  public void initialize() {
    this.isInitialized = true;
  }

  @Override
  public String getIdentifier() {
    return this.identifier;
  }

  @Override
  public Point2D getPosition() {
    return this.reference;
  }

  @Override
  public void setPosition(float x, float y) throws IllegalArgumentException {
    //    if (x < 0 || y < 0) {
    //      throw new IllegalArgumentException("Position coordinates must be positive.");
    //    }
    this.reference.updatePosition(x, y);
  }

  @Override
  public float getBase() {
    return this.base;
  }

  @Override
  public float getHeight() {
    return this.height;
  }

  @Override
  public Color getColor() {
    return this.color;
  }

  @Override
  public void setColor(int r, int g, int b) throws IllegalArgumentException {
    if (r < 0 || r > 255 || g < 0 || g > 255 || b < 0 || b > 255) {
      throw new IllegalArgumentException("Invalid RGB values.");
    }
    this.color = new Color(r, g, b);
  }

  @Override
  public void resize(float newBase, float newHeight) throws IllegalArgumentException {
    if (newBase <= 0 || newHeight <= 0) {
      throw new IllegalArgumentException("Shape dimensions must be positive.");
    }
    this.base = newBase;
    this.height = newHeight;
  }

  @Override
  public boolean isVisible() {
    return this.visible;
  }

  @Override
  public void setVisibility(boolean val) {
    this.visible = val;
  }

  @Override
  public void addTransformation(Transformation newT) throws IllegalArgumentException {
    // TODO Find a way to check for conflicting Transformations that doesn't cause errors

    //    for (Transformation myT : this.transformations) {
    //      if (myT.getType() == newT.getType()) {
    //        if (!(myT.getStartFrame() >= newT.getEndFrame()
    //            || myT.getEndFrame() <= newT.getStartFrame())) {
    //          throw new IllegalArgumentException("Conflicting Transformation - could not add.");
    //        }
    //      }
    //    }
    this.transformations.add(newT);
  }

  @Override
  public ArrayList<Transformation> getTransformations() {
    return this.transformations;
  }

  protected String toString(String shapeType) {
    return String.format(
        "Name: %s\nType: %s\nPosition: %s, Base: %s, Height: %s\nColor: %s",
        this.identifier,
        shapeType,
        this.getPosition().toString(),
        this.base,
        this.height,
        this.colorToString());
  }

  protected String toSVGString(String type) {
    // TODO remove cx for rectangles
    StringBuilder svgText = new StringBuilder();
    String template;
    if (type.equals("ellipse")) {
      template = "<%s cx=\"%f\" cy=\"%f\" rx=\"%f\" ry=\"%f\" fill=\"rgb(%d, %d, %d)\" >\n";
    } else {
      template = "<%s x=\"%f\" y=\"%f\" rx=\"%f\" ry=\"%f\" fill=\"rgb(%d, %d, %d)\" >\n";
    }
    svgText.append(
        String.format(
            template,
            type,
            this.reference.getX(),
            this.reference.getY(),
            this.base / 2,
            this.height / 2,
            this.color.getRed(),
            this.color.getGreen(),
            this.color.getBlue()));
    this.transformations.forEach(t -> svgText.append(t.toSVGString() + "\n"));
    svgText.append(String.format("</%s>\n", type));

    return svgText.toString();
  }

  /**
   * Function that prints out a color in an easily readable format.
   *
   * @return the string representation of the Color.
   */
  private String colorToString() {
    return String.format(
        "(%s, %s, %s)", this.color.getRed(), this.color.getGreen(), this.color.getBlue());
  }
}
