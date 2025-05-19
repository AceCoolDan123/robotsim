package robotsim;
import robotsim.model.Point;

public interface IObstacle {
    public boolean isOverlapping(Point point);
}
