package robotsim.model;

public class Point implements Vertex {

    public double x;
    public double y;
    public Point(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    public int getxCoordinate()
    {
        return (int) x;
    };

    public int getyCoordinate()
    {
        return (int) y;
    };

    @Override
    public String toString()
    {
        return "(x : " + x + ", y : " + y + ")";
    }
}
