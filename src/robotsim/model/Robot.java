package robotsim.model;
public class Robot extends Component
{
    private final double speed;
    public Robot(Point position, Dimension dimension, String name, double speed)
    {
        super(position, dimension, name, RGBColor.GREEN);
        this.speed = speed;
    }

    @Override
    public String toString()
    {
        return "Robot " + getBasicPrintInfo() + " and its speed : " + speed;
    }
}
