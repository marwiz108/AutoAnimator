package cs5004.animator.model.shape;

import java.awt.*;
import java.util.ArrayList;

import cs5004.animator.model.transformation.ChangeVisibilityT;
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
  protected float startFrame = 0;
  protected float endFrame = 0;
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
    for (Transformation myT : this.transformations) {
      if (myT.hasConflictingTransformation(newT)) {
        throw new IllegalArgumentException("Conflicting Transformation - could not add.");
      }
    }
    this.transformations.add(newT);
  }

  @Override
  public void setFrames() {
    this.startFrame = this.transformations.get(0).getStartFrame();
    this.endFrame = this.transformations.get(0).getEndFrame();
    for (Transformation t : this.transformations) {
      if (t.getStartFrame() < this.startFrame) {
        this.startFrame = t.getStartFrame();
      }
      if (t.getEndFrame() > this.endFrame) {
        this.endFrame = t.getEndFrame();
      }
    }
    Transformation vis = new ChangeVisibilityT(this, this.startFrame, this.endFrame);
    this.addTransformation(vis);
  }

  @Override
  public ArrayList<Transformation> getTransformations() {
    return this.transformations;
  }

  /**
   * Constructs a general string representation of a Shape. Must be given a type.
   *
   * @param shapeType the type of shape that is being described.
   * @return a formatted string representation.
   */
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

  /**
   * Constructs a general description of a Shape in XML format. Must be given a type.
   *
   * @param type the type of shpae that is being described.
   * @param template the template string passed by the child class.
   * @param delay the delay (in ms) between each frame.
   * @return XML description of a Shape.
   */
  protected String toSVGString(String type, String template, float delay) {
    float b;
    float h;
    String v;
    if (type.equals("ellipse")) {
      b = this.base / 2;
      h = this.height / 2;
    } else {
      b = this.base;
      h = this.height;
    }
    if (this.isVisible()) {
      v = "visible";
    } else {
      v = "hidden";
    }
    StringBuilder svgText = new StringBuilder();
    svgText.append(
        String.format(
            template,
            type,
            this.identifier,
            Math.round(this.reference.getX()),
            Math.round(this.reference.getY()),
            Math.round(b),
            Math.round(h),
            this.color.getRed(),
            this.color.getGreen(),
            this.color.getBlue(),
            v));
    this.transformations.forEach(t -> svgText.append(t.toSVGString(type, delay) + "\n"));
    svgText.append(String.format("\t</%s>\n", type));

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
