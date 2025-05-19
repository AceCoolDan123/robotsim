package robotsim.model;

import fr.tp.inf112.projects.canvas.model.Figure;
import fr.tp.inf112.projects.canvas.model.Style;
import fr.tp.inf112.projects.canvas.model.Shape;

import java.io.Serializable;


public abstract class Component implements Figure, Serializable
{
    protected Point position;
    protected Dimension dimension;
    private final String name;
    
    /* -------------------------- ATTRIBUTES FIGURE -------------------------- */

    protected Shape shape;
    protected Style style;

    /* -------------------------- ATTRIBUTES OBSERVER -------------------------- */

    protected Factory parentFactory;

    

    public Component(Point position, Dimension dimension, String name)
    {
        this.position = new Point(position.getxCoordinate(), position.getyCoordinate());
        this.dimension = new Dimension(dimension.getHeight(), dimension.getWidth());
        this.name = name;
    }

    public final String getName()
    {
        return name;
    }

    public String getBasicPrintInfo()
    {
        return "[name = " + name + ", position = " + position + ", dimension = " + dimension + "]";
    }

    public final Point getPosition()
    {
        return position;
    }

    public final Dimension getDimension()
    {
        return dimension;
    }

    protected final void setxCoordinate(float x)
    {
        position.setxCoordinate(x);
    }

    protected final void setyCoordinate(float y)
    {
        position.setyCoordinate(y);
    }

    public final void setParentFactory(Factory factory)
    {
        this.parentFactory = factory;
    }

    public abstract void behave();
    public abstract boolean isOverlapping(Point point);

    @Override
    public String toString()
    {
        return "name : " + name + ", dimension : " + dimension;
    }

    /* -------------------------- METHODS FIGURE -------------------------- */


    public int getxCoordinate() 
    {
        return (int)position.getxCoordinate();
    }
    
    public int getyCoordinate() 
    {
        return (int)position.getyCoordinate();
    }

    protected float getTruexCoordinate()
    {
        return position.getxCoordinate();
    }

    protected float getTrueyCoordinate()
    {
        return position.getyCoordinate();
    }

    public Style getStyle()
    {
        return this.style;
    }
    
    public Shape getShape()
    {
        return shape;
    }
}
