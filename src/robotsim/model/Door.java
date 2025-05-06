package robotsim.model;

import robotsim.view.BasicRectangle;
import robotsim.view.BasicStyle;

import fr.tp.inf112.projects.canvas.model.Style;

public class Door implements Component 
{
    // left in the room face to the door
    public Point left;
    // right in the room face to the door
    public Point right;
    private final String name;
    private boolean isOpened;

    /* -------------------------- ATTRIBUTES FIGURE -------------------------- */

    /*
    boolean determining the orientation of the door for the shape definition
        (isVertical == true)  => |
        (isVertical == false) => --
     */
    private boolean isVertical;

    Style closedStyle = BasicStyle.DefaultClosedDoor;
    Style openedStyle = BasicStyle.DefaultOpenedDoor;


    public Door(Point left, Point right, bool isVertical, String name)
    {
        if (isVertical) {
            shape = BasicRectangle(1, 10);
        }
        
        else {
            shape = BasicRectangle(10, 1);

        }
        this.left = new Point(left.x, left.y);
        this.right = new Point(right.x, right.y);
    }

    public String getName()
    {
        return name;
    }

    @Override
    public String toString()
    {
        return "Door [name = " + name + ", left = " + left + ", right = " + right + "]";
    }

    /* -------------------------- METHODS FIGURE -------------------------- */

    @Override
    public Style getStyle()
    {
        if (isOpened) {
            return openedStyle;
        }

        return closedStyle;
    }

}
