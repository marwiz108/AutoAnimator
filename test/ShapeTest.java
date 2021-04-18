import org.junit.Before;
import org.junit.Test;

import cs5004.animator.model.shape.Oval;
import cs5004.animator.model.shape.Rectangle;
import cs5004.animator.model.shape.Shape;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/** JUnit test class for the Shape interface. */
public class ShapeTest {

  private Shape oval;
  private Shape rectangle;

  @Before
  public void setUp() {
    this.oval = new Oval("o", 500, 100, 60, 30, 255, 0, 0);
    this.rectangle = new Rectangle("r", 200, 200, 50, 100, 0, 0, 255);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorWithInvalidX() {
    Shape newOval = new Oval("oval", -20, 50, 0, 50, 0, 0, 255);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorWithInvalidY() {
    Shape newOval = new Oval("oval", 100, -50, 0, 50, 0, 0, 255);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorWithInvalidBase() {
    Shape newOval = new Oval("oval", 100, 50, 0, 50, 0, 0, 255);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorWithInvalidHeight() {
    Shape newRect = new Rectangle("rectangle", 80, 260, 5, -3, 0, 0, 255);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorWithInvalidColorR() {
    Shape newOval = new Oval("oval", 100, 50, 50, 20, 321, 0, 255);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorWithInvalidColorG() {
    Shape newRect = new Rectangle("rectangle", 80, 260, 5, 12, 0, -4, 255);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorWithInvalidColorB() {
    Shape newRect = new Rectangle("rectangle", 80, 260, 5, 12, 0, 72, 256);
  }

  @Test
  public void testGetPosition() {
    assertEquals(500, this.oval.getPosition().getX(), 0);
    assertEquals(100, this.oval.getPosition().getY(), 0);

    assertEquals(200, this.rectangle.getPosition().getY(), 0);
    assertEquals(200, this.rectangle.getPosition().getY(), 0);
  }

  @Test
  public void testSetPosition() {
    this.oval.setPosition(320, 100);
    assertEquals(320, this.oval.getPosition().getX(), 0);
    assertEquals(100, this.oval.getPosition().getY(), 0);

    this.rectangle.setPosition(250, 150);
    assertEquals(250, this.rectangle.getPosition().getX(), 0);
    assertEquals(150, this.rectangle.getPosition().getY(), 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testSetPositionWithInvalidX() {
    this.oval.setPosition(-35, 25);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testSetPositionWithInvalidY() {
    this.oval.setPosition(35, -25);
  }

  @Test
  public void getBase() {
    assertEquals(60, this.oval.getBase(), 0);
    assertEquals(50, this.rectangle.getBase(), 0);
  }

  @Test
  public void getHeight() {
    assertEquals(30, this.oval.getHeight(), 0);
    assertEquals(100, this.rectangle.getHeight(), 0);
  }

  @Test
  public void testGetColour() {
    assertEquals(255, this.oval.getColor().getRed(), 0);
    assertEquals(0, this.oval.getColor().getGreen(), 0);
    assertEquals(0, this.oval.getColor().getBlue(), 0);

    assertEquals(0, this.rectangle.getColor().getRed(), 0);
    assertEquals(0, this.rectangle.getColor().getGreen(), 0);
    assertEquals(255, this.rectangle.getColor().getBlue(), 0);
  }

  @Test
  public void testSetColor() {
    this.oval.setColor(255, 178, 102);
    assertEquals(255, this.oval.getColor().getRed(), 0);
    assertEquals(178, this.oval.getColor().getGreen(), 0);
    assertEquals(102, this.oval.getColor().getBlue(), 0);

    this.rectangle.setColor(51, 153, 255);
    assertEquals(51, this.rectangle.getColor().getRed(), 0);
    assertEquals(153, this.rectangle.getColor().getGreen(), 0);
    assertEquals(255, this.rectangle.getColor().getBlue(), 0);
  }

  @Test
  public void testCopy() {
    Shape ovalCopy = this.oval.copy();
    assertEquals(this.oval.getBase(), ovalCopy.getBase(), 0);
    assertEquals(this.oval.getHeight(), ovalCopy.getHeight(), 0);
    assertEquals(this.oval.getPosition().toString(), ovalCopy.getPosition().toString());
    assertEquals(this.oval.getColor(), ovalCopy.getColor());

    Shape rectangleCopy = this.rectangle.copy();
    assertEquals(this.rectangle.getBase(), rectangleCopy.getBase(), 0);
    assertEquals(this.rectangle.getHeight(), rectangleCopy.getHeight(), 0);
    assertEquals(this.rectangle.getPosition().toString(), rectangleCopy.getPosition().toString());
    assertEquals(this.rectangle.getColor(), rectangleCopy.getColor());
  }

  @Test
  public void testResize() {
    this.oval.resize(90, 60);
    assertEquals(90, this.oval.getBase(), 0);
    assertEquals(60, this.oval.getHeight(), 0);

    this.rectangle.resize(180, 80);
    assertEquals(180, this.rectangle.getBase(), 0);
    assertEquals(80, this.rectangle.getHeight(), 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testResizeWithInvalidBase() {
    this.oval.resize(-10, 30);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testResizeWithInvalidHeight() {
    this.rectangle.resize(50, 0);
  }

  @Test
  public void testAddTransformation() {
    Transformation move = new MoveT(oval, 5, 15,
        new Point2D(0, 0), new Point2D(80, 50));

    this.oval.addTransformation(move);
    assertEquals(1, this.oval.getTransformations().size());
  }

  @Test
  public void testAddMultipleTransformations() {
    Transformation move = new MoveT(oval, 5, 15,
        new Point2D(0, 0), new Point2D(80, 50));
    Transformation resize = new ResizeT(oval, 8, 20,
        dimension.HEIGHT, 30, 100);

    this.oval.addTransformation(move);
    this.oval.addTransformation(resize);
    assertEquals(2, this.oval.getTransformations().size());
  }

  @Test (expected = IllegalArgumentException.class)
  public void testAddConflictingTransformation() {
    Transformation move = new MoveT(oval, 5, 15,
        new Point2D(0, 0), new Point2D(80, 50));
    Transformation move2 = new MoveT(oval, 5, 15,
        new Point2D(0, 0), new Point2D(50, 20));

    this.oval.addTransformation(move);
    this.oval.addTransformation(move2);
  }

  @Test
  public void testSetVisibility() {
    assertFalse(this.oval.isVisible());
    this.oval.setVisibility(true);
    assertTrue(this.oval.isVisible());
    this.oval.setVisibility(false);
    assertFalse(this.oval.isVisible());
  }

  @Test
  public void testToString() {
    String ovalStr =
        "Name: o\n"
            + "Type: oval\n"
            + "Position: (500.0, 100.0), Base: 60.0, Height: 30.0\n"
            + "Color: (255, 0, 0)";
    assertEquals(ovalStr, this.oval.toString());

    String rectStr =
        "Name: r\n"
            + "Type: rectangle\n"
            + "Position: (200.0, 200.0), Base: 50.0, Height: 100.0\n"
            + "Color: (0, 0, 255)";
    assertEquals(rectStr, this.rectangle.toString());
  }

  @Test
  public void testToSVGString() {
    assertEquals("<ellipse cx=\"500.000000\" cy=\"100.000000\" "
            + "rx=\"30.000000\" ry=\"15.000000\" fill=\"rgb(255, 0, 0)\" >\n"
        + "</ellipse>\n",
        this.oval.toSVGString());

    Transformation move = new MoveT(oval, 5, 15,
        new Point2D(0, 0), new Point2D(80, 50));
    Transformation resize = new ResizeT(oval, 8, 20,
        dimension.HEIGHT, 30, 100);
    this.oval.addTransformation(move);
    this.oval.addTransformation(resize);
    assertEquals("<ellipse cx=\"500.000000\" cy=\"100.000000\" "
        + "rx=\"30.000000\" ry=\"15.000000\" fill=\"rgb(255, 0, 0)\" >\n"
        + "<animate attributeName=\"x\" attributeType=\"XML\" from=\"0.0\" "
        + "to=\"80.0\" begin=\"5.0\" dur=\"10.0s\" />\n"
        + "<animate attributeName=\"y\" attributeType=\"XML\" from=\"0.0\" "
        + "to=\"50.0\" begin=\"5.0\" dur=\"10.0s\" />\n"
        + "<animateTransform attributeName=\"ry\" attributeType=\"XML\" "
        + "from=\"30.0\" to=\"100.0\" begin=\"8.0\" dur=\"12.0s\" />\n"
        + "</ellipse>\n",
        this.oval.toSVGString());
  }
}
