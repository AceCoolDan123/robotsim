package robotsim.model;

public class Puck extends Component
{
    public Puck(Point position, Dimension dimension, String name)
    {
        super(position, dimension, name);
    }

    @Override
    public String toString()
    {
        return "Pluck " + getBasicPrintInfo();
    }
}
