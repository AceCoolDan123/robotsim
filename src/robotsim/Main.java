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
        int factoryLength = 100;
        int robotLength = 100;
        Point point00 = createPoint(0, 0);


        Room[] rooms = new Room[3];
        rooms[0] = new Room(point00, createDimension(point00, length / 2, length / 2), createSingleArrayDoors("DoorRoom0"), createSingleArrayAreaWithOneMachine("AreaRoom0"), "Room0");
        //rooms[1] = new Room(point00, dim00, createSingleArrayDoors("DoorRoom1"), createSingleArrayAreaWithOneMachine("AreaRoom1"), "Room1");
        //rooms[2] = new Room(point00, dim00, createSingleArrayDoors("DoorRoom2"), createSingleArrayAreaWithOneMachine("AreaRoom2"), "Room2");

        Factory factory1 = new Factory(
            new Point(0, 0), 
            createDimension(point00, length, length),
            "Factory 1", rooms, 
            createSingleArrayStations("station0"), 
            createSingleArrayPuck("puck0"));

        factory1.addRobot(point00, createDimension(point00, 10, 10), "Robot0");
        factory1.addRobot(point00, new Dimension(point00, point00, point00, point00), "Robot1");
        factory1.addRobot(point00, new Dimension(point00, point00, point00, point00), "Robot2");

        System.out.println(factory1);
    }

    private static Point createPoint(double x, double y)
    {
        return new Point(x, y);
    }

    private static Door[] createSingleArrayDoors(String name)
    {
        Point point00 = new Point(0, 0);
        Door[] res = new Door[1];
        res[0] = new Door(point00, point00, name);
        return res;
    }

    private static Area[] createSingleArrayAreaWithOneMachine(String name)
    {
        Point point00 = new Point(0, 0);
        Dimension dim00 = new Dimension(point00, point00, point00, point00);
        Area[] res = new Area[1];
        Machine[] machines = new Machine[1];
        machines[0] = new Machine(point00, dim00, "name's Machine");
        res[0] = new Area(point00, dim00, machines, name);
        return res;
    }

    private static ChargingStation[] createSingleArrayStations(String name)
    {
        Point point00 = new Point(0, 0);
        Dimension dim00 = new Dimension(point00, point00, point00, point00);
        ChargingStation[] res = new ChargingStation[1];
        res[0] = new ChargingStation(point00, dim00, name);
        return res;
    }

    private static Puck[] createSingleArrayPuck(String name)
    {
        Point point00 = new Point(0, 0);
        Dimension dim00 = new Dimension(point00, point00, point00, point00);
        Puck[] res = new Puck[1];
        res[0] = new Puck(point00, dim00, name);
        return res;
    }

    private static Dimension createDimension(Point center, int height, int width)
    {
        return new Dimension(
            new Point(center.x - width, center.y + height), 
            new Point(center.x + width, center.y + height), 
            new Point(center.x + width, center.y - height), 
            new Point(center.x - width, center.y - heigth)
        );
    }
}
