package robotsim.model;

public class Dimension 
{
    public Point cornerLT; 
    public Point cornerRT; 
    public Point cornerRB; 
    public Point cornerLB; 

    public Dimension()
    {
        this.cornerLT = new Point(0,0);
        this.cornerRT = new Point(0,0);
        this.cornerRB = new Point(0,0);
        this.cornerLB = new Point(0,0);
    }

    public Dimension(Point cornerLT, Point cornerRT, Point cornerRB, Point cornerLB)
    {
        this.cornerLT = new Point(cornerLT.x, cornerLT.y);
        this.cornerRT = new Point(cornerRT.x, cornerRT.y);
        this.cornerRB = new Point(cornerRB.x, cornerRB.y);
        this.cornerLB = new Point(cornerLB.x, cornerLB.y);
    } 

    public int getWidth() 
    {
        return (int) cornerRT.distance(cornerLT);
    }

    public int getHeight() 
    {
        return (int) cornerRT.distance(cornerRB);
    }

    @Override
    public String toString()
    {
        return "{LT : " + cornerLT.toString() + ", " +
        "RT : " + cornerRT.toString() + ", " +
        "RB : " + cornerRB.toString() + ", " +
        "LB : " + cornerLB.toString() + "}";
    }
}
