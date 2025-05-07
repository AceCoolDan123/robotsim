package robotsim.model;

import java.util.Arrays;

import robotsim.view.BasicRectangle;
import robotsim.view.BasicStyle;

import fr.tp.inf112.projects.canvas.model.Shape;

public class Area extends Component
{
    public Machine[] machines;


    
    public Area(Point position, Dimension dimension, Machine[] machines, String name)
    {
        super(position, dimension, name);
        
        this.machines = new Machine[machines.length];
        for (int i = 0; i < machines.length; i ++)
        {
            this.machines[i] = new Machine(machines[i].position, machines[i].dimension, machines[i].getName());
        }

        /* -------------------------- ATTRIBUTES FIGURE -------------------------- */
        style = BasicStyle.DefaultArea;
        shape = (Shape)(new BasicRectangle(dimension.getWidth(), dimension.getHeight()));
    }

    @Override
    public String toString()
    {
        return "Area " + getBasicPrintInfo() + "\n contains " + Arrays.toString(machines);
    }
}
