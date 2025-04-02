package robotsim.model;

public class Dimension 
{
    public Point cornerLT; 
    public Point cornerRT; 
    public Point cornerRB; 
    public Point cornerLB; 

    public Dimension(Point cornerLT, Point cornerRT, Point cornerRB, Point cornerLB)
    {
        this.cornerLT = new Point(cornerLT.x, cornerLT.y);
        this.cornerRT = new Point(cornerRT.x, cornerRT.y);
        this.cornerRB = new Point(cornerRB.x, cornerRB.y);
        this.cornerLB = new Point(cornerLB.x, cornerLB.y);
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
