package robotsim.model;

public class Dimension 
{
    private int width;
    private int height;

    public Dimension()
    {
        width = 0;
        height = 0;
    }

    public Dimension(int height, int width)
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
        return "{height : " + height.toString() + ", " +
        "width : " + width.toString() + "}";
    }
}
