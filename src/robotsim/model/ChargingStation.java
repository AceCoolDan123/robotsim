package robotsim.model;

import robotsim.view.BasicRectangle;
import robotsim.view.BasicStyle;

import fr.tp.inf112.projects.canvas.model.Shape;

public class ChargingStation extends Component
{
    public ChargingStation(Point position, Dimension dimension, String name)
    {
        super(position, dimension, name);
        style = BasicStyle.DefaultChargingStation;
        shape = (Shape)(new BasicRectangle(dimension.getWidth(), dimension.getHeight()));
    } 

    @Override
    public String toString()
    {
        return "ChargingStation " + getBasicPrintInfo(); 
    }
}
