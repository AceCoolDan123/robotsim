package robotsim.model;

import java.util.ArrayList;
import java.util.Arrays;
import fr.tp.inf112.projects.canvas.model.Style;
import fr.tp.inf112.projects.canvas.model.Figure;
import fr.tp.inf112.projects.canvas.model.Canvas;

public class Factory extends Component implements Canvas
{
    public ArrayList<Robot> robots;
    public final Room[] rooms;
    public final ChargingStation[] chargingStations;
    public Puck[] pucks;

    /* -------------------------- ATTRIBUTES CANVAS -------------------------- */
    
    private final ArrayList<Figure> figures = new ArrayList();
    private String Id = "";

    public Factory(Point position, Dimension dimension, String name, Room[] rooms, ChargingStation[] chargingStations, Puck[] pucks)
    {
        super(position, dimension, name);
        robots = new ArrayList<>(10);
        this.rooms = new Room[rooms.length];
        for (int i = 0; i < rooms.length; i ++)
        {
            this.rooms[i] = new Room(rooms[i].position, rooms[i].dimension, rooms[i].doors, rooms[i].areas, rooms[i].getName());
            figures.add(this.rooms[i]);
        }

        this.chargingStations = new ChargingStation[chargingStations.length];
        for (int i = 0; i < chargingStations.length; i ++)
        {
            this.chargingStations[i] = new ChargingStation(chargingStations[i].position, chargingStations[i].dimension, chargingStations[i].getName());
            figures.add(this.chargingStations[i]);
        }

        this.pucks = new Puck[pucks.length];
        for (int i = 0; i < pucks.length; i ++)
        {
            this.pucks[i] = new Puck(pucks[i].position, pucks[i].dimension, pucks[i].getName());
            figures.add(this.pucks[i]);
        }
    }

    public boolean addRobot(Point position, Dimension dimension, String name)
    {
        if (!checkRobotName(name))
        {
            return false;
        }
        Robot new_robot = new Robot(position, dimension, name, 0);
        robots.add(new_robot);
        figures.add(new_robot);
        return true;
    }

    private boolean checkRobotName(String name)
    {
        for (Robot robot : robots) {
            if (robot.getName().equals(name))
            {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "Factory [name =" + getName() + ", robots =" + robots + ", rooms = " + Arrays.toString(rooms) + ", chargingStations = " + Arrays.toString(chargingStations) + ", pucks = " + Arrays.toString(pucks) + "]";
    }


    /* -------------------------- METHODES CANVAS -------------------------- */

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public int getWidth()
    {
        return dimension.getWidth();
    }

    public int getHeight()
    {
        return dimension.getHeight();
    }

    public ArrayList<Figure> getFigures() {
        return figures;
    } 

}
