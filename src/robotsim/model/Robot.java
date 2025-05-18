package robotsim.model;

import java.util.ArrayList;
import java.util.Arrays;

import fr.tp.inf112.projects.canvas.model.Shape; 

import javax.lang.model.util.ElementScanner14;
import javax.print.attribute.standard.Destination;

import robotsim.view.BasicOval;
import robotsim.view.BasicStyle;
import robotsim.view.BasicStroke;


public class Robot extends Component
{
    private final float speed;
    private final static double globalRobotSpeed = 1;

    /* -------------------------- BEHAVIORAL ATTRIBUTES -------------------------- */

    private ArrayList<Component> componentsToVisit = new ArrayList<Component>();
    
    //behave method attributes
    private boolean hasArrived = true;
    private int visitedComponentsIdx = 0;
    private Component currentComponent = null;
    private float epsilon = (float) 0.4;

    public Robot(Point position, Dimension dimension, String name, float speed)
    {
        super(position, dimension, name);
        this.speed = speed;
        shape = (Shape)(new BasicOval(dimension.getWidth(), dimension.getHeight()));
        style = BasicStyle.DefaultRobot; 
 
        componentsToVisit = new ArrayList<Component>();
    }

    @Override
    public String toString()
    {
        return "Robot " + getBasicPrintInfo() + " and its speed : " + speed;
    }

    /* -------------------------- BEHAVIORAL METHODS -------------------------- */

    public void addComponentToVisit(Component component)
    {
        componentsToVisit.add(component);
    }

    public void move(Component component)
    {
        float destinationX = component.getTruexCoordinate();
        float destinationY = component.getTrueyCoordinate();
        float distance = this.getPosition().distance(component.getPosition());
        float x = this.getTruexCoordinate();
        float y = this.getTrueyCoordinate();
        float dx = destinationX - x;
        float dy = destinationY - y;

        float newX = (float) (x + (dx/distance)*globalRobotSpeed*speed);
        float newY = (float) (y + (dy/distance)*globalRobotSpeed*speed);
        
        System.out.println(getName() + ": " + position.toString() + "\n(newX, newY) = (" + newX +"," + newY + ")");
        System.out.flush();

        if((destinationX - newX)*dx < 0)
        {
            this.setxCoordinate((float) destinationX);
            System.out.println("flop type 1.1");
        }
        else
        {
            this.setxCoordinate(newX);
            System.out.println("flop type 1.2");
        }
        if((destinationY - newY)*dy < 0)
        {
            this.setyCoordinate((float) destinationY);
            System.out.println("flop type 2.1");

        }
        else
        {
            this.setyCoordinate(newY);
            System.out.println("flop type 2.2");
        }

        System.out.println(getName() + ": " + position.toString() + "\n(newX, newY) = (" + newX +"," + newY + ")");
        
    }

    @Override
    public void behave()
    {
        if (hasArrived) 
        {
            currentComponent = componentsToVisit.get(visitedComponentsIdx);
            visitedComponentsIdx = (visitedComponentsIdx+1) % (componentsToVisit.size());
            System.out.println("visited component changed ! currentIdx : "+visitedComponentsIdx);
            hasArrived = false;
        } 
        else 
        {
            if (this.getPosition().distance(currentComponent.getPosition()) > epsilon)
            {
                move(currentComponent);
            }
            else
            {
                hasArrived = true;
            }    
        }
    }
}
