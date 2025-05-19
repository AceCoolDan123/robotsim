package robotsim.model;

import robotsim.view.BasicRectangle;
import robotsim.view.BasicStyle;

import fr.tp.inf112.projects.canvas.model.Style;
import fr.tp.inf112.projects.canvas.model.Shape;

public class Door extends Component 
{
    private boolean isOpened;
    private final int thickness = 1;
    private int length;
    private boolean isVertical;

    /* -------------------------- ATTRIBUTES FIGURE -------------------------- */

    /*
    boolean determining the orientation of the door for the shape definition
        (isVertical == true)  => |
        (isVertical == false) => --
     */

    private final Style closedStyle = BasicStyle.DefaultClosedDoor;
    private final Style openedStyle = BasicStyle.DefaultOpenedDoor;

    public Door(Point position, int length, String name, boolean isVertical)
    {
        super(position, new Dimension(), name);
 
        int width = isVertical ? thickness : length;
        int height = isVertical ? length : thickness;

        shape = (Shape)(new BasicRectangle(width, height));
        
        this.isVertical = isVertical;
        this.isOpened = true;
        this.length = length;

    }

    public final boolean switchDoorState()
    {
        isOpened = !isOpened;
        return isOpened;
    }

    public final boolean getDoorState()
    {
        return isOpened;
    }

    @Override
    public String toString()
    {
        return "Door [name = " + getName() + ", position = "+ position + ", isVertical = " + isVertical + "]";
        //return "Door [name = " + name + ", left = " + left + ", right = " + right + "]";
    }

    public boolean getIsVertical()
    {
        return isVertical;
    }

    public int getLength()
    {
        return length;
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

    // for int values
    public boolean isInBoundaries(Point point)
    {
        if (isVertical)
        {
            return ((int)point.x == (int)position.x) && ((int)point.y >= (int)position.y) && ((int)point.y <= (int)(position.y + length));
        }
        else
        {
            return ((int)point.y == (int)position.y) && ((int)point.x >= (int)position.x) && ((int)point.y <= (int)(position.y + length));
        }
    }

    @Override
    public boolean isOverlapping(Point point) 
    {
        return false;
    }

    @Override
    public void behave() {}
}
