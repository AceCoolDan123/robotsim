package robotsim.model;

import java.io.Serializable;

public class Dimension implements Serializable
{
    private final int width;
    private final int height;

    public Dimension()
    {
        width = 0;
        height = 0;
    }

    public Dimension(final int height, final int width)
    {
        this.height = height;
        this.width = width;
    } 

    public int getWidth() 
    {
        return width;
    }

    public int getHeight() 
    {
        return height;
    }

    @Override
    public String toString()
    {
        return "{height : " + height + ", " +
        "width : " + width + "}";
    }
}
