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

In order for the project to run successfully, the working directory must be set to "src". If using a
.jar file to run the project, it must be placed in "src". All input files should pe placed in the
"src.input" directory, and all output files (if specified) will appear in the "src.output"
directory.

Functionality added that sets the bounds of the canvas on creation (canvas height and width, and
minimum x and y values).

The Canvas now contains two hashmaps with shape identifiers (keys) and shape objects (values). The
first hashmaps contains the initial state of the shapes, and these shapes contain all
Transformations. The second hashmap contains "dynamic" shape objects which are mutated throughout
the course of the animation. This was done so that all Transformations acting on a shape would
mutate the same shape resulting in their effects combining instead of creating new shapes where only
one parameter is being changed at a time, which was a problem with our previous design. The hashmap
containing initial shapes is there to keep all Transformations for each shape in one place, as well
as allow the animation to be reset easily.

the getShapesAtFrame method was implemented.

A static Builder class is added to ICanvas, that builds and sets up the canvas with its shapes and
their transformations. Shapes can now be reset to their original attributes by storing the original
shapes and keeping track of the changing shapes.

Shapes now keep track of their starting and ending frame, which is set based on the first and last
frame found in that shape's list of transformations. This information is used to create the
ChangeVisibility Transformation for that shape.

Before adding transformations we loop through the transformations for the shape and check whether
there is a conflicting transformation, e.g. a new transformation that clashes with the start or end
frame of an existing one, or a transformation that is the opposite of an existing one, e.g. moving
right and left at the same time.

The getValueAtFrame method in abstract transformation was updated to take in a current value
parameter. This was done because the method should not update the shape's parameter if the given
frame falls outside the scope (startFrame - endFrame) of the Transformation calling it. Before this
change, if the frame was outside the scope, the method would return initial value, which is not
always the same as the current value (ex: shape currently at (0, 0) moves from initial = (50, 50)
to final = (100, 100)).

Added string methods to the canvas, shapes and transformation classes to output as SVG files.

## View Interface

The IView is responsible for creating and displaying the canvas with the shapes, and displays the
animations that apply to the shapes, so you get a visual representation of the movement of the
shapes. The View interface also generates the text needed to output into for each type of text
view (except for the visual animation view where it is not supported). The View also creates the
appropriate file for each text view to output the svg or plaintext contents. Functionality to be
able to pause and play, as well as play from a specified frame, and resetting the view, is defined
in the interface to be implemented in the next part.

### Abstract Text View

A Text view generates text in the desired format and is capable of outputting that text in multiple
formats. The TextView will always create a JFrame with the desired text appearing on the screen. If
no -out parameter is supplied to EasyAnimator, the TextView will print the generated text on the
console in addition to creating the JFrame. If a -out parameter is supplied, the TextView will
create a new file with the given name containing the text.

The text view is responsible for outputting the animation as either plaintext or SVG. The delay
between frames is specified on creation of the view. The text view does not support the methods for
the visual view, such as play, pause, reset, playFromFrame and createAndShow. The sub-classes Text
and SVG generate the plaintext and XML respectively, which gets input into a .txt file or .svg file.
The SVG text file can be opened in a browser and show the animation.

### Animation Panel

The AnimationPanel is responsible for painting all shapes on the screen, and keeps track of timing
for displaying a visual animation.

The Animation Panel is a JPanel that has action listener capability, and uses the Timer. The
paintComponent method is overridden from JComponent to get all the shapes at a frame and draw their
state at that frame - for each shape in the canvas at that frame, if it is visible it will set the
colour and fill it, then starts the timer at 0 for the animation. The Timer calls the method
actionPerformed, with the specified delay between method calls. When actionPerformed gets called,
the frame will increment and repaint the shapes at the next frame with paintComponent. This is what
makes the graphics show continuously in the animation.

### Visual View

The visual view is responsible for displaying the canvas visually, and shows the shapes animating.
The method createAndShow sets up the window that the animation will be played on. The methods
generateText and createFile are not supported in this view because the view is only visual, there is
no file output.

## Changes (Pt 3)

The first change that was made had to do with allowing the animation to loop. This change was made
in the AnimationPanel class, and added a check for when that animation reached the last frame. After
the last frame, the current frame is reset back to 0.

This change introduced a bug where the shapes would not reset properly, and some end states would be
preserved after reset. After some debugging, the cause of this bug was determined to be in the
addShapes and resetDynamicShapes methods in ICanvasModel. These methods were not using the
Shape.copy method, which resulted in the initial shapes being modified along with dynamic shapes.
After adjusting these methods properly, the loop and reset features worked as expected.

### InteractiveView

The InteractiveView Class displays the animation using the AnimationPanel similar to the VisualView,
but allows the user to interact with the animation. Using the InteractiveView, the user is able to
play/pause the animation, reset the animation to its original state, toggle animation looping, and
increment/decrement the speed of the animation.

### Features

Features is the interface for the InteractiveView controller. This interface contains methods for
the operations that should be supported by the InteractiveView (play/pause, reset, change speed,
loop). The implementing class AnimationController has a reference to an InteractiveView object and
has methods that call the corresponding methods in InteractiveView when and Action Event happens.

### Controls

The Controls interface is responsible for defining behavior of any Controls that are used for an
InteractiveView. These controls include the GUIPanel and speedControls. Controls contain buttons,
and add ActionListeners to those buttons that call appropriate methods in the Controller when an
Action Event is detected.

#### GUIPanel

the GUIPanel shows a list of controls at the bottom of the InteractiveView (play/pause, reset,
change speed, loop).

#### speedControls

When the "change speed" button in the GUIPanel is clicked, it will open a new speed controls window.
This window shows the current speed of the animation (fps) and "+" / "-" buttons which increment and
decrement the speed respectively.