package robotsim.model;

import java.util.LinkedList;
import java.util.Queue;
import java.util.List;

import fr.tp.inf112.projects.canvas.model.Shape; 

import robotsim.view.BasicOval;
import robotsim.view.BasicStyle;

import fr.tp.inf112.projects.graph.impl.GridVertex;
import fr.tp.inf112.projects.graph.DijkstraAlgorithm;
import fr.tp.inf112.projects.graph.Vertex;
import fr.tp.inf112.projects.graph.Graph;

public class Robot extends Component
{
    private final float speed;
    private final static double globalRobotSpeed = 1;

    /* -------------------------- BEHAVIORAL ATTRIBUTES -------------------------- */
    private Queue<Point> destinations = new LinkedList<>();
    private Queue<Point> onGoingPath = new LinkedList<>();
    private Point currentDestination;
    private float epsilon = (float) 0.4;
    private Factory factory;

    public Robot(Point position, Dimension dimension, String name, float speed, Factory factory)
    {
        super(position, dimension, name);
        this.speed = speed;
        shape = (Shape)(new BasicOval(dimension.getWidth(), dimension.getHeight()));
        style = BasicStyle.DefaultRobot; 
        this.factory = factory;
    }

    @Override
    public String toString()
    {
        return "Robot " + getBasicPrintInfo() + " and its speed : " + speed;
    }

    /* -------------------------- BEHAVIORAL METHODS -------------------------- */

    public void addDestination(Point point)
    {
        destinations.add(point);
    }

    public void move()
    {
        float distance = this.getPosition().distance(currentDestination);
        float x = this.getTruexCoordinate();
        float y = this.getTrueyCoordinate();
        float dx = currentDestination.x - x;
        float dy = currentDestination.y - y;

        float newX = (float) (x + (dx/distance)*globalRobotSpeed*speed);
        float newY = (float) (y + (dy/distance)*globalRobotSpeed*speed);

        if((currentDestination.x - newX)*dx < 0)
        {
            this.setxCoordinate((float) currentDestination.x);
        }
        else
        {
            this.setxCoordinate(newX);
        }
        if((currentDestination.y - newY)*dy < 0)
        {
            this.setyCoordinate((float) currentDestination.y);
        }
        else
        {
            this.setyCoordinate(newY);
        }
    }

    @Override
    public void behave()
    {
        // nowhere to explore
        if (onGoingPath.isEmpty() && destinations.isEmpty()) { return; }

        // new path to calculate
        if (onGoingPath.isEmpty()) 
        {
            Point finalDestination = destinations.poll();
            GridVertex currentVertex = (GridVertex)factory.getGraph().getVertex("Vertex" + (int)getPosition().x + "." + (int)getPosition().y);
            GridVertex finalVertex = (GridVertex)factory.getGraph().getVertex("Vertex" + (int)finalDestination.x + "." + (int)finalDestination.y);
            
            List<Vertex> path = DijkstraAlgorithm.findShortestPath((Graph)factory.getGraph(), (Vertex)currentVertex, (Vertex)finalVertex);

            for (Vertex vertex : path)
            {
                onGoingPath.add(new Point(((GridVertex)vertex).getxCoordinate(), ((GridVertex)vertex).getyCoordinate()));
            }
        } 
        else if (currentDestination != null && this.getPosition().distance(currentDestination) > epsilon)
        {
            move();
            return;
        }
        // following onGoingPath
        currentDestination = onGoingPath.poll();
    }

    @Override
    public boolean isOverlapping(Point point) { return false; }
}
