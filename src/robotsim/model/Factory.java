package robotsim.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

import fr.tp.inf112.projects.canvas.model.Style;
import fr.tp.inf112.projects.canvas.model.Figure;
import fr.tp.inf112.projects.canvas.model.Canvas;
import fr.tp.inf112.projects.canvas.controller.Observer;
import fr.tp.inf112.projects.canvas.controller.Observable;

import fr.tp.inf112.projects.graph.impl.GridGraph;
import fr.tp.inf112.projects.graph.impl.GridVertex;
import fr.tp.inf112.projects.graph.impl.GridEdge;

public class Factory extends Component implements Canvas, Observable
{
    /* -------------------------- ATTRIBUTES CANVAS -------------------------- */
    
    private ArrayList<Component> components = new ArrayList<Component>();
    private ArrayList<Figure> figures = new ArrayList<Figure>();
    private String id = "";
    private GridGraph graph = new GridGraph();

    /* -------------------------- ATTRIBUTES OBSERVABLE -------------------------- */
    
    private ArrayList<Observer> observers = new ArrayList<Observer>();
    private boolean isSimulationRunning = false;

    public Factory(Dimension dimension, String name)
    {
        super(new Point(0,0), dimension, name);
        for (int i = 0; i < dimension.getWidth(); i++)
        {
            for (int j = 0; j < dimension.getWidth(); j++)
            {
                //graph.addVertex(new GridVertex());
            }
        }
    }

    public boolean addComponent(Room room) 
    {
        room.setParentFactory(this);

        if (!components.add(room)){
            return false;
        }
        figures.add((Figure)room);

        for (Door door : room.getDoors()){
            addComponent(door);
        }
        
        for (Area area : room.getAreas()){
            addComponent(area);
        }

        notifyObservers();
        return true;
    }
    
    public boolean addComponent(Area area) 
    {
        area.setParentFactory(this);

        if (!components.add(area)){
            return false;
        }

        figures.add((Figure)area);

        for (Machine machine : area.getMachines()){
            addComponent(machine);
        }
        
        notifyObservers();
        return true;
    }

    public boolean addComponent(Component component) 
    {
        component.setParentFactory(this);

        if (components.add(component)) 
        {
            notifyObservers(); 
            figures.add((Figure)component);
            return true;
        }

        return false;
    }
/* 
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
*/
    @Override
    public String toString()
    {
        return "Factory [name =" + getName() + ", robots =" + robots + ", rooms = " + Arrays.toString(rooms) + ", chargingStations = " + Arrays.toString(chargingStations) + ", pucks = " + Arrays.toString(pucks) + "]";
    }

    @Override
    public void behave()
    {
        for (Component component : components) 
        {
            component.behave();
        }
    }


    /* -------------------------- METHODS CANVAS -------------------------- */

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

    /* -------------------------- METHODS OBSERVABLE -------------------------- */

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
    { 
        if (observers == null) { return; }
        // To be called every time model data is modified
        for (Observer observer : observers) 
        {
            observer.modelChanged();
        }
    }

    public void startSimulation()
    {
        if (isSimulationRunning) {
            System.out.println("La simulation est déjà en cours !");
            return;
        }
        
        isSimulationRunning = true;
        System.out.println("Simulation démarrée.");

        while (isSimulationRunning())
        {
            behave();
            notifyObservers();

            try {
                Thread.sleep(200);
            } 
            catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void stopSimulation()
    {
        if (!isSimulationRunning) {
            System.out.println("Aucune simulation n'est en cours.");
            return;
        }

        isSimulationRunning = false;
        System.out.println("Simulation arrêtée.");

    }

    public boolean isSimulationRunning()
    {
        return isSimulationRunning;
    }

}
