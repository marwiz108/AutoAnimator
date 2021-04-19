# EasyAnimator

## Canvas

The Canvas contains all Shape objects that will appear in the animationFrame, and can also be
thought of as the screen. The Canvas is able to render all Shapes in the appropriate position, size,
and color at any given frame throughout the animationFrame. Shapes are tracked using a
LinkedHashMap, which takes a Shape identifier as a key. The LinkedHashMap stores the original Shape
object in the order they were added, so the Canvas can be reset if needed. Shapes can be added or
removed from the Canvas. Transformations can also be added directly to the Canvas, given the
identifier of the Shape they will act upon.

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

## Changes (Pt 2)

Functionality added that sets the bounds of the canvas on creation (canvas height and width, and
minimum x and y values). Transformations are no longer added to the canvas, they are added to
the shape object that they are being applied to and tracked in the Shape class.
A static Builder class is added to ICanvas, that builds and sets up the canvas with its shapes
and their transformations. Shapes can now be reset to their original attributes by storing the
original shapes and keeping track of the changing shapes.

Before adding transformations we loop through the transformations for the shape and check whether
there is a conflicting transformation, e.g. a new transformation that clashes with the start or
end frame of an existing one, or a transformation that is the opposite of an existing one,
e.g. moving right and left at the same time.

Added string methods to the canvas, shapes and transformation classes to output as SVG files.

## View Interface

The IView is responsible for creating and displaying the canvas with the shapes, and displays the
animations that apply to the shapes, so you get a visual representation of the movement of the shapes.
The View interface also generates the text needed to output into for each type of text view (except
for the visual animation view where it is not supported). The View also creates the appropriate
file for each text view to output the svg or plaintext contents. Functionality to be able to pause
and play, as well as play from a specified frame, and resetting the view, is defined in the
interface to be implemented in the next part.

### Abstract Text View

The text view is responsible for outputting the animation as either plaintext or SVG. The delay
between frames is specified on creation of the view. The text view does not support the methods
for the visual view, such as play, pause, reset, playFromFrame and createAndShow. The sub-classes
Text and SVG generate the plaintext and XML respectively, which gets input into a .txt file or
.svg file. The SVG text file can be opened in a browser and show the animation.

### Animation Panel
The Animation Panel is a JPanel that has action listener capability, and uses the Timer. The
paintComponent method is overridden from JComponent to get all the shapes at a frame and draw
their state at that frame - for each shape in the canvas at that frame, if it is visible it will
set the colour and fill it, then starts the timer at 0 for the animation. The Timer calls the method
actionPerformed, with the specified delay between method calls. When actionPerformed gets called,
the frame will increment and repaint the shapes at the next frame with paintComponent. This is what
makes the graphics show continuously in the animation.

### Visual View

The visual view is responsible for displaying the canvas visually, and shows the shapes animating.
The method createAndShow sets up the window that the animation will be played on. The methods
generateText and createFile are not supported in this view because the view is only visual, there
is no file output.
