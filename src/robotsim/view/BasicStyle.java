package robotsim.view;

import robotsim.view.BasicStroke;

import fr.tp.inf112.projects.canvas.model.Style;
import fr.tp.inf112.projects.canvas.model.Stroke;
import fr.tp.inf112.projects.canvas.model.impl.RGBColor;
import org.w3c.dom.css.RGBColor;


public class BasicStyle implements Style
{
    private Color backgroundColor;
    private Stroke stroke;

    public static final Style DefaultRobot = BasicStyle(RGBColor.PINK, BasicStroke.TRAITPLEINFIN);

    public static final Style DefaultRoom = BasicStyle(RGBColor.WHITE, BasicStroke.TRAITPLEINFIN);

    public static final Style DefaultArea = BasicStyle(RGBColor.WHITE, BasicStroke.TRAITPOINTILLEFIN);

    public static final Style DefaultOpenedDoor = BasicStyle(RGBColor.WHITE, BasicStroke.TRAITPLEINEPAIS);
    
    public static final Style DefaultClosedDoor = BasicStyle(RGBColor.BLACK, BasicStroke.TRAITPLEINEPAIS);

    

    public BasicStyle()
    {
        this(RGBColor.WHITE, java.awt.BasicStroke.TRAITPLEINFIN);
    }

    public BasicStyle(Color backgroundColor, Stroke stroke)
    {
        this.backgroundColor = backgroundColor;
        this.stroke = stroke;
    }

    public void setBackgroundColor(color backgroundColor)
    {
        this.backgroundColor = backgroundColor;
    }

    public Color getBackgroundColor()
    {
        return backgroundColor;
    }

    public Stroke getStroke()
    {
        return stroke;
    }

}