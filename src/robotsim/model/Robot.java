package robotsim.model;

import fr.tp.inf112.projects.canvas.model.Shape; 

import robotsim.view.BasicOval;
import static robotsim.view.BasicStyle.DefaultRobot;


public class Robot extends Component
{
    private final double speed;


    public Robot(Point position, Dimension dimension, String name, double speed)
    {
        super(position, dimension, name);
        this.speed = speed;
        this.setShape(BasicOval(dimension.getWidth(), dimension.getHeight()));
        this.setStyle(DefaultRobot);
    }

    @Override
    public String toString()
    {
        return "Robot " + getBasicPrintInfo() + " and its speed : " + speed;
    }
}
