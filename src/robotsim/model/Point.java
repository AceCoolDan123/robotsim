package robotsim.model;
import java.lang.math

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

    public float distance(Point point2) 
    {
        int x2 = point2.getxCoordinate;
        int y2 = point2.getyCoordinate;
        
        float dx = (float) x-x2;
        float dy = (float) y-y2;
        
        return Math.sqrt((dx*dx) + (dy*dy))
    }

    @Override
    public String toString()
    {
        return "(x : " + x + ", y : " + y + ")";
    }
}
