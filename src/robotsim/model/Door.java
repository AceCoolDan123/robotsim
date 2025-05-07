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
        int x = position.getxCoordinate();
        int y = position.getyCoordinate();
 
        Point cornerRT; 
        Point cornerRB; 
        Point cornerLB;
        Point cornerLT;

        if (isVertical) {
            shape = (Shape)(new BasicRectangle(thickness, length));
            
            cornerRT = new Point(x + thickness / 2, y + length / 2); 
            cornerRB = new Point(x + thickness / 2, y - length / 2); 
            cornerLB = new Point(x - thickness / 2, y - length / 2); 
            cornerLT = new Point(x - thickness / 2, y + length / 2); 
        }
        
        else {
            shape = (Shape)(new BasicRectangle(length, thickness));
            
            cornerRT = new Point(x + length / 2, y + thickness / 2); 
            cornerRB = new Point(x + length / 2, y - thickness / 2); 
            cornerLB = new Point(x - length / 2, y - thickness / 2); 
            cornerLT = new Point(x - length / 2, y + thickness / 2); 
        }

        dimension.cornerLB = cornerLB;
        dimension.cornerLT = cornerLT;
        dimension.cornerRT = cornerRT;
        dimension.cornerRB = cornerRB;

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

}
