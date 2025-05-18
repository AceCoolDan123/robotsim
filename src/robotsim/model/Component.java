package robotsim.model;

import fr.tp.inf112.projects.canvas.model.Figure;
import fr.tp.inf112.projects.canvas.model.Style;
import fr.tp.inf112.projects.canvas.model.Shape;

import fr.tp.inf112.projects.canvas.controller.Observer;

import robotsim.view.BasicStyle.DefaultRobot;

import static robotsim.view.BasicStyle.DefaultRobot;

import java.awt.BasicStroke;
import java.io.Serializable;


public class Component implements Figure, Serializable
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
        this.position = new Point(position.x, position.y);
        this.dimension = new Dimension(dimension.getHeight(), dimension.getWidth());
        this.name = name;
    }

    /*public Component(Point position, Dimension dimension, String name, Color backgroundColor)
    {
        this.position = new Point(position.x, position.y);
        this.dimension = new Dimension(dimension.cornerLT, dimension.cornerRT, dimension.cornerLT, dimension.cornerLB);
        this.name = name;
        this.backgroundColor = backgroundColor;
    }*/

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

    public void behave()
    {
        
    }

    @Override
    public String toString()
    {
        return "name : " + name + ", dimension : " + dimension;
    }

    /* -------------------------- METHODS FIGURE -------------------------- */


    public int getxCoordinate() 
    {
        return (int)position.x;
    }
    
    public int getyCoordinate() 
    {
        return (int)position.y;
    }

    public Style getStyle()
    {
        //return DefaultRobot;
        return this.style;
    }
    
    public Shape getShape()
    {
        return shape;
    }
}
