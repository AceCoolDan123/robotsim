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

    public Door[] getDoors()
    {
        return doors;
    }
    public Area[] getAreas()
    {
        return areas;
    }
}
