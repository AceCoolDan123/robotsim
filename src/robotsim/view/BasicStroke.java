package robotsim.view;

import java.io.Serializable;

import fr.tp.inf112.projects.canvas.model.Stroke;
import fr.tp.inf112.projects.canvas.model.Color;
import fr.tp.inf112.projects.canvas.model.impl.RGBColor;
import java.util.Arrays;

public class BasicStroke implements Stroke, Serializable
{
    private Color color;
    private float thickness;
    private float[] dashPattern;

    public static final Stroke TRAITPLEINFIN = new BasicStroke();

    public static final Stroke TRAITPOINTILLEFIN = new BasicStroke(RGBColor.BLACK, (float)1, new float[]{(float)10.5, (float)10.5});

    public static final Stroke TRAITPLEINEPAIS = new BasicStroke(RGBColor.BLACK, (float)5, new float[]{(float)1});


    public BasicStroke()
    {
        this(RGBColor.BLACK, 1, new float[]{1});
    }

    public BasicStroke(Color color, float thickness, float[] dashPattern)
    {
        this.color = color;
        this.thickness = thickness;
        this.dashPattern = Arrays.copyOf(dashPattern, dashPattern.length);
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