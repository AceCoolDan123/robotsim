package robotsim.model;

import fr.tp.inf112.projects.canvas.model.Figure;
import fr.tp.inf112.projects.canvas.model.Style;
import fr.tp.inf112.projects.canvas.model.Shape;


public class Component implements Figure
{
    public Point position;
    public Dimension dimension;
    private final String name;
    
    /* -------------------------- ATTRIBUTES FIGURE -------------------------- */

    private Shape shape;
    private Style style;


    public Component(Point position, Dimension dimension, String name)
    {
        this.position = new Point(position.x, position.y);
        this.dimension = new Dimension(dimension.cornerLT, dimension.cornerRT, dimension.cornerLT, dimension.cornerLB);
        this.name = name;
    }

    /*public Component(Point position, Dimension dimension, String name, Color backgroundColor)
    {
        this.position = new Point(position.x, position.y);
        this.dimension = new Dimension(dimension.cornerLT, dimension.cornerRT, dimension.cornerLT, dimension.cornerLB);
        this.name = name;
        this.backgroundColor = backgroundColor;
    }*/

    public String getName()
    {
        return name;
    }

    public String getBasicPrintInfo()
    {
        return "[name = " + name + ", position = " + position + ", dimension = " + dimension + "]";
    }

    protected void setShape(Shape shape)
    {
        this.shape = shape;
    }
    
    protected void setStyle(Style style)
    {
        this.style = style;
    }

    /* -------------------------- METHODS FIGURE -------------------------- */


    public int getxCoordinate() 
    {
        return position.getxCoordinate();
    }
    
    public int getyCoordinate() 
    {
        return position.getyCoordinate();
    }

    public Style getStyle()
    {
        return style;
    }
    
    public Shape getShape()
    {
        return shape;
    }


}
