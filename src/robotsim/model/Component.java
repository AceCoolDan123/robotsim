package robotsim.model;


public class Component implements Figure
{
    public Point position;
    public Dimension dimension;
    private final String name;
    private backgroundColor = RGBColor.PINK;

    public Component(Point position, Dimension dimension, String name)
    {
        this.position = new Point(position.x, position.y);
        this.dimension = new Dimension(dimension.cornerLT, dimension.cornerRT, dimension.cornerLT, dimension.cornerLB);
        this.name = name;
    }

    public Component(Point position, Dimension dimension, String name, RGBColor backgroundColor)
    {
        this.position = new Point(position.x, position.y);
        this.dimension = new Dimension(dimension.cornerLT, dimension.cornerRT, dimension.cornerLT, dimension.cornerLB);
        this.name = name;
        this.backgroundColor = backgroundColor;
    }

    public String getName()
    {
        return name;
    }

    public RGBColor getBackgroundColor(){
        return backgroundColor;
    }

    public String getBasicPrintInfo()
    {
        return "[name = " + name + ", position = " + position + ", dimension = " + dimension + "]";
    }
}
