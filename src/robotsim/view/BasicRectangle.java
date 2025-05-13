package robotsim.view;

import fr.tp.inf112.projects.canvas.model.RectangleShape;
import java.io.Serializable;

public class BasicRectangle implements RectangleShape, Serializable
{
    private final int width;
    private final int height;

    public BasicRectangle(int width, int height)
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