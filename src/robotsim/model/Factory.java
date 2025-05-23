package robotsim.model;

import java.util.ArrayList;
import java.util.Arrays;

import fr.tp.inf112.projects.canvas.model.Figure;
import fr.tp.inf112.projects.canvas.model.Canvas;
import fr.tp.inf112.projects.canvas.controller.Observer;
import fr.tp.inf112.projects.canvas.controller.Observable;

import robotsim.graph.SerializableGridGraph;
import robotsim.graph.SerializableGridVertex;
import robotsim.graph.SerializableGridEdge;

import fr.tp.inf112.projects.graph.impl.GridGraph;
import fr.tp.inf112.projects.graph.impl.GridVertex;
import fr.tp.inf112.projects.graph.Edge;
import java.io.Serializable;

public class Factory extends Component implements Canvas, Observable, Serializable
{
    /* -------------------------- ATTRIBUTES CANVAS -------------------------- */
    
    private ArrayList<Figure> figures = new ArrayList<Figure>();
    private String id = "";

    /* -------------------------- ATTRIBUTES OBSERVABLE -------------------------- */
    
    private transient ArrayList<Observer> observers;
    private boolean isSimulationRunning = false;

    private SerializableGridGraph graph;
    private ArrayList<Component> components = new ArrayList<Component>();

    public Factory(Dimension dimension, String name)
    {
        super(new Point(0,0), dimension, name);
        observers = new ArrayList<Observer>();
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

    public void constructGraph()
    {
        graph = new SerializableGridGraph();
        int w = dimension.getWidth();
        int h = dimension.getHeight();

        for (int i = 0; i < w; i++)
        {
            for (int j = 0; j < h; j++)
            {
                Point point = new Point(i, j);

                if (isOverlapping(point)) { continue; }

                GridVertex currentVertex = new SerializableGridVertex("Vertex" + i + "." + j, i, j);
                GridVertex upVertex = (SerializableGridVertex)graph.getVertex("Vertex" + i + "." + (j - 1));
                GridVertex leftVertex = (SerializableGridVertex)graph.getVertex("Vertex" + (i - 1) + "." + j);

                graph.addVertex(currentVertex);

                // Up Edge
                if (upVertex != null)
                {
                    Edge edge = new SerializableGridEdge(graph, upVertex, currentVertex, 1);
                    graph.addEdge(edge);
                    upVertex.addEdge(edge);
                    currentVertex.addEdge(edge);
                }
                // Left Edge
                if (leftVertex != null)
                {
                    Edge edge = new SerializableGridEdge(graph, leftVertex, currentVertex, 1);
                    graph.addEdge(edge);
                    leftVertex.addEdge(edge);
                    currentVertex.addEdge(edge);
                }
            }
        }
    }

    @Override
    public boolean isOverlapping(Point point)
    {
        for (Component component : components)
        {
            if (component.isOverlapping(point))
            {
                return true;
            }
        }

        return false;
    }

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

    public GridGraph getGraph()
    {
        return (GridGraph)graph;
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
        if (observers == null)
        {
            observers = new ArrayList<Observer>();
        }
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
                Thread.sleep(20);
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
