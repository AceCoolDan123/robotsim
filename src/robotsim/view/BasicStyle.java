package robotsim.view;


import fr.tp.inf112.projects.canvas.model.Style;
import fr.tp.inf112.projects.canvas.model.Stroke;
import fr.tp.inf112.projects.canvas.model.Color;
import fr.tp.inf112.projects.canvas.model.impl.RGBColor;
import java.io.Serializable;

public class BasicStyle implements Style, Serializable
{
    private Color backgroundColor;
    private Stroke stroke;

    public static final Style DefaultRobot = new BasicStyle(RGBColor.PINK, BasicStroke.TRAITPLEINFIN);

    public static final Style DefaultRoom = new BasicStyle(RGBColor.WHITE, BasicStroke.TRAITPLEINFIN);

    public static final Style DefaultArea = new BasicStyle(RGBColor.WHITE, BasicStroke.TRAITPOINTILLEFIN);

    public static final Style DefaultMachine = new BasicStyle(RGBColor.WHITE, BasicStroke.TRAITPLEINFIN);

    public static final Style DefaultChargingStation = new BasicStyle(RGBColor.WHITE, BasicStroke.TRAITPOINTILLEFIN);

    public static final Style DefaultPuck = new BasicStyle(RGBColor.GREEN, BasicStroke.TRAITPLEINFIN);

    public static final Style DefaultOpenedDoor = new BasicStyle(RGBColor.WHITE, BasicStroke.TRAITPLEINEPAIS);
    
    public static final Style DefaultClosedDoor = new BasicStyle(RGBColor.BLACK, BasicStroke.TRAITPLEINEPAIS);

    

    public BasicStyle()
    {
        this(RGBColor.WHITE, BasicStroke.TRAITPLEINFIN);
    }

    public BasicStyle(Color backgroundColor, Stroke stroke)
    {
        this.backgroundColor = backgroundColor;
        this.stroke = stroke;
    }

    public void setBackgroundColor(Color backgroundColor)
    {
        this.backgroundColor = backgroundColor;
    }

    @Override
    public Color getBackgroundColor()
    {
        return backgroundColor;
    }

    public Stroke getStroke()
    {
        return stroke;
    }

}