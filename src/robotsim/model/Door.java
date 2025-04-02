package robotsim.model;

public class Door 
{
    // left in the room face to the door
    public Point left;
    // right in the room face to the door
    public Point right;
    private final String name;

    public Door(Point left, Point right, String name)
    {
        this.left = new Point(left.x, left.y);
        this.right = new Point(right.x, right.y);
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    @Override
    public String toString()
    {
        return "Door [name = " + name + ", left = " + left + ", right = " + right + "]";
    }
}
