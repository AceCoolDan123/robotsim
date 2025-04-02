package robotsim.model;

public class Machine extends Component
{
    public Machine(Point position, Dimension dimension, String name)    
    {
        super(position, dimension, name);
    }

    @Override
    public String toString()
    {
        return "Machine " + getBasicPrintInfo(); 
    }
}
