package robotsim.model;

import robotsim.view.BasicRectangle;
import robotsim.view.BasicStyle;

import fr.tp.inf112.projects.canvas.model.Style;

public class Door extends Component 
{
    // left in the room face to the door
    public Point left;
    // right in the room face to the door
    public Point right;
    private boolean isOpened;

    /* -------------------------- ATTRIBUTES FIGURE -------------------------- */

    /*
    boolean determining the orientation of the door for the shape definition
        (isVertical == true)  => |
        (isVertical == false) => --
     */
    private boolean isVertical;

    private Style closedStyle = BasicStyle.DefaultClosedDoor;
    private Style openedStyle = BasicStyle.DefaultOpenedDoor;

    public Door(Point position, int length, String name, bool isVertical)
    {
        int x = position.getxCoordinate();
        int y = position.getyCoordinate();
 
        Point cornerRT; 
        Point cornerRB; 
        Point cornerLB;

        if (isVertical) {
            setShape(BasicRectangle(1, 10));
            
            cornerRT = new Point(x + 1, y); 
            cornerRB = new Point(x + 1, y + 10); 
            cornerLB = new Point(x, y + 10); 
        }
        
        else {
            setShape(BasicRectangle(10, 1));
            
            cornerRT = new Point(x + 10, y); 
            cornerRB = new Point(x + 10, y + 1); 
            cornerLB = new Point(x, y + 1); 
        }

        super(position, new Dimension(position, cornerRT, cornerRB, cornerLB), name);

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
