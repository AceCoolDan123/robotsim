package robotsim.model;

import java.util.Arrays;

import robotsim.view.BasicRectangle;
import robotsim.view.BasicStyle;

import fr.tp.inf112.projects.canvas.model.Style;
import fr.tp.inf112.projects.canvas.model.Shape;

public class Room extends Component 
{
    private Door[] doors;
    private Area[] areas;

    /* -------------------------- ATTRIBUTES FIGURE -------------------------- */




    public Room(Point position, Dimension dimension, Door[] doors, Area[] areas, String name)
    {
        super(position, dimension, name);

        style = BasicStyle.DefaultRoom;
        shape = (Shape)(new BasicRectangle(dimension.getWidth(), dimension.getHeight()));

        this.doors = new Door[doors.length];
        for (int i = 0; i < doors.length; i++) 
        {
            this.doors[i] = new Door(doors[i].position, doors[i].getLength(), doors[i].getName(), doors[i].getIsVertical());
        }
        
        this.areas = new Area[areas.length];
        for (int i = 0; i < areas.length; i++) 
        {
            this.areas[i] = new Area(areas[i].position, areas[i].dimension, areas[i].getMachines(), areas[i].getName());
        }
    }    

    @Override
    public String toString()
    {
        return "Room " + getBasicPrintInfo() + "\n contains " + Arrays.toString(doors) + "\n contains " + Arrays.toString(areas);
    }

    @Override 
    public boolean isOverlapping(Point point)
    {
        boolean overlappingEdge = 
        // left edge
        ((point.x == (int)position.x) && (point.y > position.y) && isInYBoundaries(point.y)) ||
        // right edge
        ((point.x == (int)(position.x + dimension.getWidth())) && isInYBoundaries(point.y)) ||
        // bottom edge
        ((point.y == (int)(position.y + dimension.getHeight())) && isInXBoundaries(point.x)) ||
        // up edge
        ((point.y == (int)position.y) && isInXBoundaries(point.x));


        return overlappingEdge && notOverlappingDoors(point);
    }

    private boolean notOverlappingDoors(Point point)
    {
        for (Door door : doors)
        {
            if(door.isOverlapping(point))
            {
                return true;
            }
        }
        return false;
    }

    private boolean isInXBoundaries(float x)
    {
        return (x >= position.x) && (x <= position.x + dimension.getWidth()); 
    }

    private boolean isInYBoundaries(float y)
    {
        return (y >= position.y) && (y <= position.y + dimension.getHeight()); 
    }

    public Door[] getDoors()
    {
        return doors;
    }
    public Area[] getAreas()
    {
        return areas;
    }

    @Override
    public void behave() {}
}
