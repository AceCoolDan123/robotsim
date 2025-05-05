package robotsim;

import robotsim.model.Area;
import robotsim.model.ChargingStation;
import robotsim.model.Dimension;
import robotsim.model.Door;
import robotsim.model.Factory;
import robotsim.model.Machine;
import robotsim.model.Point;
import robotsim.model.Puck;
import robotsim.model.Room;

public class Main {
    public static void main(String[] args) 
    {
        int factoryLength = 1000;
        int roomLength = 300;
        int robotLength = 10;
        Point centerPoint = createPoint(0, 0);
        Point leftPoint = createPoint(-500, 0);
        Point rightPoint = createPoint(500, 0);


        Room[] rooms = new Room[3];
        rooms[0] = new Room(leftPoint, createDimension(leftPoint, roomLength, roomLength), createSingleArrayDoors("DoorRoom0"), createSingleArrayAreaWithOneMachine("AreaRoom0"), "Room0");
        rooms[1] = new Room(centerPoint, createDimension(centerPoint, roomLength, roomLength), createSingleArrayDoors("DoorRoom1"), createSingleArrayAreaWithOneMachine("AreaRoom1"), "Room1");
        rooms[2] = new Room(rightPoint, createDimension(rightPoint, roomLength, roomLength), createSingleArrayDoors("DoorRoom2"), createSingleArrayAreaWithOneMachine("AreaRoom2"), "Room2");

        Factory factory1 = new Factory(
            new Point(0, 0), 
            createDimension(centerPoint, factoryLength, factoryLength),
            "Factory 1", rooms, 
            createSingleArrayStations("station0"), 
            createSingleArrayPuck("puck0"));

        factory1.addRobot(leftPoint, createDimension(leftPoint, robotLength, robotLength), "Robot0");
        factory1.addRobot(centerPoint, createDimension(centerPoint, robotLength, robotLength), "Robot0");
        factory1.addRobot(rightPoint, createDimension(rightPoint, robotLength, robotLength), "Robot0");

        System.out.println(factory1);
    }

    private static Point createPoint(double x, double y)
    {
        return new Point(x, y);
    }

    private static Door[] createSingleArrayDoors(String name)
    {
        Point centerPoint = new Point(0, 0);
        Door[] res = new Door[1];
        res[0] = new Door(centerPoint, centerPoint, name);
        return res;
    }

    private static Area[] createSingleArrayAreaWithOneMachine(String name)
    {
        Point centerPoint = new Point(0, 0);
        Dimension dim00 = new Dimension(centerPoint, centerPoint, centerPoint, centerPoint);
        Area[] res = new Area[1];
        Machine[] machines = new Machine[1];
        machines[0] = new Machine(centerPoint, dim00, "name's Machine");
        res[0] = new Area(centerPoint, dim00, machines, name);
        return res;
    }

    private static ChargingStation[] createSingleArrayStations(String name)
    {
        Point centerPoint = new Point(0, 0);
        Dimension dim00 = new Dimension(centerPoint, centerPoint, centerPoint, centerPoint);
        ChargingStation[] res = new ChargingStation[1];
        res[0] = new ChargingStation(centerPoint, dim00, name);
        return res;
    }

    private static Puck[] createSingleArrayPuck(String name)
    {
        Point centerPoint = new Point(0, 0);
        Dimension dim00 = new Dimension(centerPoint, centerPoint, centerPoint, centerPoint);
        Puck[] res = new Puck[1];
        res[0] = new Puck(centerPoint, dim00, name);
        return res;
    }

    private static Dimension createDimension(Point center, int height, int width)
    {
        return new Dimension(
            new Point(center.x - width / 2, center.y + height / 2), 
            new Point(center.x + width / 2, center.y + height / 2), 
            new Point(center.x + width / 2, center.y - height / 2), 
            new Point(center.x - width / 2, center.y - height / 2)
        );
    }
}
