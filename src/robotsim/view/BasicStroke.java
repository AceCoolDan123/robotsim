package robotsim.view;

import java.util.ArrayList;
import java.io.Serializable;

import fr.tp.inf112.projects.canvas.model.Stroke;
import fr.tp.inf112.projects.canvas.model.Color;
import fr.tp.inf112.projects.canvas.model.impl.RGBColor;

public class BasicStroke implements Stroke, Serializable
{
    private Color color;
    private float thickness;
    private float[] dashPattern;

    public static final Stroke TRAITPLEINFIN = new BasicStroke();

    public static final Stroke TRAITPOINTILLEFIN = new BasicStroke(BLACK, 0.1, {10, 10});

    public static final Stroke TRAITPLEINEPAIS = new BasicStroke(BLACK, 0.5, {});


    public BasicStroke()
    {
        this(BLACK, 10, {});
    }

    public BasicStroke(Color color, float thickness, float[] dashPattern)
    {
        this.color = color;
        this.thickness = thickness;
        this.dashPattern = dashPattern;
    }

    public Color getColor()
    {
        return color;
    }

    public float getThickness()
    {
        return thickness;
    }

    public float[] getDashPattern()
    {
        return dashPattern;
    }

}