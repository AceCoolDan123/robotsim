package robotsim.model;

public class ChargingStation extends Component
{
    public ChargingStation(Point position, Dimension dimension, String name)
    {
        super(position, dimension, name);
    } 

    @Override
    public String toString()
    {
        return "ChargingStation " + getBasicPrintInfo(); 
    }
}
