package robotsim.model;
import static java.lang.Math.sqrt;
import fr.tp.inf112.projects.canvas.model.Vertex;
import java.io.Serializable;

public class Point implements Vertex, Serializable
{

    public float x;
    public float y;

    public Point(float x, float y)
    {
        this.x = x;
        this.y = y;
    }

    public float distance(Point point2) 
    {
        int x2 = (int)point2.x;
        int y2 = (int)point2.y;
        
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
