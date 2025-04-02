package robotsim.model;


public class Component 
{
    public Point position;
    public Dimension dimension;
    private final String name;

    public Component(Point position, Dimension dimension, String name)
    {
        this.position = new Point(position.x, position.y);
        this.dimension = new Dimension(dimension.cornerLT, dimension.cornerRT, dimension.cornerLT, dimension.cornerLB);
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public String getBasicPrintInfo()
    {
        return "[name = " + name + ", position = " + position + ", dimension = " + dimension + "]";
    }
}
