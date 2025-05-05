

public class BasicStyle implements Style
{
    private Color backgroundColor;
    private Stroke stroke;

    public static final Style DefaultRobot = BasicStyle(PINK, TRAITPLEINFIN);

    public static final Style DefaultRoom = BasicStyle(WHITE, TRAITPLEINFIN);

    public static final Style DefaultArea = BasicStyle(WHITE, TRAITPOINTILLEFIN);

    public static final Style DefaultOpenedDoor = BasicStyle(WHITE, TRAITPLEINEPAIS);
    
    public static final Style DefaultClosedDoor = BasicStyle(BLACK, TRAITPLEINEPAIS);

    

    public BasicStyle()
    {
        this(WHITE, TRAITPLEINFIN);
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