package robotsim.view;

import fr.tp.inf112.projects.canvas.model.OvalShape;
import java.io.Serializable;


public class BasicOval implements OvalShape, Serializable
{
    private final int width;
    private final int height;

    public BasicOval(int width, int height)
    {
        this.width = width;
        this.height = height;
    }

    public int getWidth()
    {
        return width;
    }

    public int getHeight()
    {
        return height;
    }

}