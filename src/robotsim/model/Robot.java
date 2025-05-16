package robotsim.model;

import java.util.ArrayList;
import java.util.Arrays;

import fr.tp.inf112.projects.canvas.model.Shape; 

import javax.lang.model.util.ElementScanner14;
import javax.print.attribute.standard.Destination;

import robotsim.view.BasicOval;
import robotsim.view.BasicStyle;


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
    private int length = componentsToVisit.size();



    public Robot(Point position, Dimension dimension, String name, float speed)
    {
        super(position, dimension, name);
        this.speed = speed;
        shape = (Shape)(new BasicOval(dimension.getWidth(), dimension.getHeight()));
        style = BasicStyle.DefaultRobot; 

        System.out.println("Construction d'un robot : ");
        System.out.println("Style utilisé : " + style);
        System.out.println("Couleur : " + style.getBackgroundColor());

 
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
        int destinationX = component.getxCoordinate();
        int destinationY = component.getyCoordinate();
        float distance = this.getPosition().distance(component.getPosition());
        int x = this.getxCoordinate();
        int y = this.getyCoordinate();
        int dx = destinationX - x;
        int dy = destinationY - y;

        float newX = (float) (x + (dx/distance)*globalRobotSpeed*speed);
        float newY = (float) (y + (dy/distance)*globalRobotSpeed*speed);
        
        if((destinationX - newX)*dx < 0)
        {
            this.setxCoordinate((float) destinationX);
            this.setyCoordinate((float) destinationX);
        }

        else
        {
            this.setxCoordinate((float) (x + (dx/distance)*globalRobotSpeed*speed));
            this.setyCoordinate((float) (y + (dy/distance)*globalRobotSpeed*speed));
        }
    }

    @Override
    public void behave()
    {
        if (hasArrived) {
            currentComponent = componentsToVisit.get(visitedComponentsIdx);
            visitedComponentsIdx = (visitedComponentsIdx+1) % length;
            hasArrived = false;
        }

        else 
        {
            if (this.getPosition().distance(currentComponent.getPosition()) < globalRobotSpeed*speed);
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
