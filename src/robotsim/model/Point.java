package robotsim.model;
import static java.lang.Math.sqrt;
import fr.tp.inf112.projects.canvas.model.Vertex;

public class Point implements Vertex {

    public float x;
    public float y;
    public Point(float x, float y)
    {
        this.x = x;
        this.y = y;
    }

    @Override
    public int getxCoordinate()
    {
        return (int) x;
    };

    @Override
    public int getyCoordinate()
    {
        return (int) y;
    };

    public float distance(Point point2) 
    {
        int x2 = point2.getxCoordinate();
        int y2 = point2.getyCoordinate();
        
        float dx = (float) x-x2;
        float dy = (float) y-y2;
        
        return (float)sqrt((dx*dx) + (dy*dy));
    }

    @Override
    public String toString()
    {
        return "(x : " + x + ", y : " + y + ")";
    }
}
