package robotsim.model;

import robotsim.view.BasicStyle;
import robotsim.view.BasicOval;
import fr.tp.inf112.projects.canvas.model.Shape; 

public class Puck extends Component
{
    public Puck(Point position, Dimension dimension, String name)
    {
        super(position, dimension, name);
        style = BasicStyle.DefaultPuck;
        shape = (Shape)(new BasicOval(dimension.getWidth(), dimension.getHeight()));
    }

    @Override
    public String toString()
    {
        return "Pluck " + getBasicPrintInfo();
    }

    @Override
    public boolean isOverlapping(Point point) 
    {
        return false;
    }

    @Override
    public void behave() {}

}
