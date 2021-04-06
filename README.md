# EasyAnimator

## Canvas

The Canvas contains all Shape objects that will appear in the animation, and can also be thought of
as the screen. The Canvas is able to render all Shapes in the appropriate position, size, and color
at any given frame throughout the animation. Shapes are tracked using a LinkedHashMap, which takes a
Shape identifier as a key. The LinkedHashMap stores the original Shape object in the order they were
added, so the Canvas can be reset if needed. Shapes can be added or removed from the Canvas.
Transformations can also be added directly to the Canvas, given the identifier of the Shape they
will act upon.

## Shape Interface

The Shape interface represents a shape that can be added to a Canvas. A Shape can do a multitude of
operations, including make a copy of itself, change its position, size, or color, and appear or
disappear.

### AbstractShape

AbstractShape defines behavior of shared methods of child classes of the Shape interface. An
AbstractShape has an identifier, a base and height, a reference point (Point2D), a Color, and an
ArrayList of Transformations that act on that Shape. The state of the shape can be calculated for
all fields at each frame by looping over this list of Transformations.

### Oval and Rectangle

Oval and Rectangle are children of the Shape interface, and extend AbstractShape. These classes
override the copy method and define the reference point. The functionality of these classes could be
improved with a "calculateArea" method that calculates the area of each Shape.

### Point2D

Point2D is a simple class that represents an (x, y) position on a coordinate plane. Point2D has an x
and y value, and is capable of changing its position. The functionality of this class could be
extended with a "calculateDistance" method that finds the distance between two Point2D instances.

## Transformation Interface

A Transformation corresponds to one Shape only, and is only active over a certain range of frames. A
Transformation is responsible for changing only one field of a Shape. Therefore, there are separate
child classes that can change a Shape's visibility, position, color, or size. A transformation can
determine the appropriate state of its Shape at a given frame.

### AbstractTransformation

The AbstractTransformation defines shared behavior of all Transformation classes. The Shape object
that the Transformation acts upon is held here, along with the starting and ending frame where the
Transformation is active. The AbstractTransformation class also defines the getValueAtFrame method,
which, given a frame and initial and final value, will calculate the intermediate value at the given
frame. This method is used in child classes to find the value of one of its parameters at the
appropriate frame. For example, the MoveT Transformation uses this method to calculate its x
position value at a certain frame. It then uses the method again to calculate the y position.

### ChangeVisibilityT

ChangeVisibilityT is a transformation that tells a shape which frame to appear at, and which frame
to disappear at. Its executeAtFrame returns a boolean depending on if the shape should be visible at
the given frame or not.

### MoveT

MoveT moves a Shape from an initial position to a final position. The ExecuteAtFrame method returns
an array of floats containing the x and y coordinates respectively.

### ChangeColorT

ChangeColorT changes a Shape's color from an initial rgb value to a final rgb value. The
ExecuteAtFrame method returns an array of Integers that represents r,g,b respectively.

### ResizeT

ResizeT changes the size of a shape. However, a ResizeT object can only change one dimension
(base or height). ExecuteAtFrame method returns a float that represents the new dimension.