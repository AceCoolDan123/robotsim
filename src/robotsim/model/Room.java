package robotsim.model;

import java.util.Arrays;

public class Room extends Component
{
    public Door[] doors;
    public Area[] areas;

    /* -------------------------- ATTRIBUTES FIGURE -------------------------- */

    style = DefaultRoom;
    shape = BasicRectangle(dimension.getWidth, dimension.getHeight);



    public Room(Point position, Dimension dimension, Door[] doors, Area[] areas, String name)
    {
        super(position, dimension, name);

        this.doors = new Door[doors.length];
        for (int i = 0; i < doors.length; i++) 
        {
            this.doors[i] = new Door(doors[i].left, doors[i].right, doors[i].getName());
        }
        
        this.areas = new Area[areas.length];
        for (int i = 0; i < areas.length; i++) 
        {
            this.areas[i] = new Area(areas[i].position, areas[i].dimension, areas[i].machines, areas[i].getName());
        }
    }    

    @Override
    public String toString()
    {
        return "Room " + getBasicPrintInfo() + "\n contains " + Arrays.toString(doors) + "\n contains " + Arrays.toString(areas);
    }
}
