package robotsim.model;

import robotsim.view.BasicRectangle;
import robotsim.view.BasicStyle;

import fr.tp.inf112.projects.canvas.model.Style;

public class Door extends Component 
{
    /*// left in the room face to the door
    public Point left;
    // right in the room face to the door
    public Point right;*/
    private boolean isOpened;
    private final int thickness = 1;
    private int length;

    /* -------------------------- ATTRIBUTES FIGURE -------------------------- */

    /*
    boolean determining the orientation of the door for the shape definition
        (isVertical == true)  => |
        (isVertical == false) => --
     */
    private boolean isVertical;

    private final Style closedStyle = BasicStyle.DefaultClosedDoor;
    private final Style openedStyle = BasicStyle.DefaultOpenedDoor;

    public Door(Point position, int length, String name, boolean isVertical)
    {
        int x = position.getxCoordinate();
        int y = position.getyCoordinate();
 
        Point cornerRT; 
        Point cornerRB; 
        Point cornerLB;

        if (isVertical) {
            setShape(new BasicRectangle(thickness, length));
            
            cornerRT = new Point(x + thickness, y); 
            cornerRB = new Point(x + thickness, y + length); 
            cornerLB = new Point(x, y + length); 
        }
        
        else {
            setShape(new BasicRectangle(length, thickness));
            
            cornerRT = new Point(x + length, y); 
            cornerRB = new Point(x + length, y + thickness); 
            cornerLB = new Point(x, y + thickness); 
        }

        super(position, new Dimension(position, cornerRT, cornerRB, cornerLB), name);

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

    /*public Door(Point left, Point right, bool isVertical, String name)
    {
        if (isVertical) {
            shape = BasicRectangle(1, 10);
        }
        
        else {
            shape = BasicRectangle(10, 1);

        }
        this.left = new Point(left.x, left.y);
        this.right = new Point(right.x, right.y);
    }*/

    
    @Override
    public String toString()
    {
        return "Door [name = " + getName() + ", position = "+ position + ", isVertical = " + isVertical + "]";
        //return "Door [name = " + name + ", left = " + left + ", right = " + right + "]";
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
