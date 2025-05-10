package robotsim.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Observer;
import java.util.Set;

import fr.tp.inf112.projects.canvas.model.Style;
import fr.tp.inf112.projects.canvas.model.Figure;
import fr.tp.inf112.projects.canvas.model.Canvas;
import fr.tp.inf112.projects.canvas.controller.Observable;

public class Factory extends Component implements Canvas, Observable
{
    public ArrayList<Robot> robots;
    public Room[] rooms;
    public ChargingStation[] chargingStations;
    public Puck[] pucks;

    /* -------------------------- ATTRIBUTES CANVAS -------------------------- */
    
    private final ArrayList<Figure> components = new ArrayList();
    private String id = "";

    /* -------------------------- ATTRIBUTES OBSERVABLE -------------------------- */
    
    private final Set<Observer> observers;



    /*public Factory(Point position, Dimension dimension, String name, Room[] rooms, ChargingStation[] chargingStations, Puck[] pucks)
    {
        super(position, dimension, name);*/

    public Factory(Dimension dimension, String name, Room[] rooms, ChargingStation[] chargingStations, Puck[] pucks)
    {
        super(new Point(0,0), dimension, name);
        robots = new ArrayList<>(10);

        if (rooms == null) { 
            rooms = new Room[1];
        } else {
            this.rooms = new Room[rooms.length];
            for (int i = 0; i < rooms.length; i ++)
            {
                this.rooms[i] = new Room(rooms[i].position, rooms[i].dimension, rooms[i].doors, rooms[i].areas, rooms[i].getName());
                addComponent(this.rooms[i]);
            }
        }

        if (chargingStations == null)
        {
            chargingStations = new ChargingStation[1];
        } else {
            this.chargingStations = new ChargingStation[chargingStations.length];
            for (int i = 0; i < chargingStations.length; i ++)
            {
                this.chargingStations[i] = new ChargingStation(chargingStations[i].position, chargingStations[i].dimension, chargingStations[i].getName());
                addComponent(this.chargingStations[i]);
            }
        }

        if (pucks == null)
        {
            pucks = new Puck[1];
        } else {
            this.pucks = new Puck[pucks.length];
            for (int i = 0; i < pucks.length; i ++)
            {
                this.pucks[i] = new Puck(pucks[i].position, pucks[i].dimension, pucks[i].getName());
                addComponent(this.pucks[i]);
            }
        }
    }

    public boolean addComponent(Component component ) 
    {
        if (components.add(component)) 
        {
            notifyObservers(); // Notify observers that some data have changed
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
        addComponent(new_robot);
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

    @Override
    public void behave()
    {
        for (ArrayList<Figure> component : figures) {
            component.behave();
        }
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

    /* -------------------------- METHODES OBSERVABLE -------------------------- */

    @Override
    public boolean addObserver(Observer observer) 
    {
        return observers.add(observer);
    }

    @Override
    public boolean removeObserver(Observer observer) 
    {
        return observers.remove(observer);
    }

    protected void notifyObservers() 
    { // To be called every time model data is modified
        for (final Observer observer : observers) 
        {
            observer.modelChanged();
        }
    }

    

}
