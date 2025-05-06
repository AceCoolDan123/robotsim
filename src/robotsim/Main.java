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

import fr.tp.inf112.projects.canvas.model.Canvas;
import fr.tp.inf112.projects.canvas.view.CanvasViewer;

public class Main {
    public static void main(String[] args) 
    {
        int factoryLength = 1000;
        int roomLength = 300;
        int robotLength = 10;
        Point centerPoint = createPoint(0, 0);
        Point centerDoorPoint = createPoint(0, roomLength / 2);
        Point leftPoint = createPoint(-500, 0);
        Point leftDoorPoint = createPoint(-500, roomLength / 2);
        Point rightPoint = createPoint(500, 0);
        Point rightDoorPoint = createPoint(500, roomLength / 2);
        Point chargingPoint = createPoint(0, 400);
        Point puckPoint = createPoint(0, -400);


        Room[] rooms = new Room[3];
        rooms[0] = new Room(leftPoint, createDimension(leftPoint, roomLength, roomLength), 
                            createSingleArrayHorizontalDoors("DoorRoom0", leftDoorPoint), 
                            createSingleArrayAreaWithOneMachine("AreaRoom0", leftPoint), "Room0");
        rooms[1] = new Room(centerPoint, createDimension(centerPoint, roomLength, roomLength), 
                            createSingleArrayHorizontalDoors("DoorRoom1", centerDoorPoint), 
                            createSingleArrayAreaWithOneMachine("AreaRoom1", centerPoint), "Room1");
        rooms[2] = new Room(rightPoint, createDimension(rightPoint, roomLength, roomLength), 
                            createSingleArrayHorizontalDoors("DoorRoom2", rightDoorPoint), 
                            createSingleArrayAreaWithOneMachine("AreaRoom2", rightPoint), "Room2");

        Factory factory1 = new Factory(
            new Point(0, 0), 
            createDimension(centerPoint, factoryLength, factoryLength),
            "Factory 1", rooms, 
            createSingleArrayStations("station0", chargingPoint), 
            createSingleArrayPuck(("puck0"), puckPoint));

        factory1.addRobot(leftPoint, createDimension(leftPoint, robotLength, robotLength), "Robot0");
        factory1.addRobot(centerPoint, createDimension(centerPoint, robotLength, robotLength), "Robot0");
        factory1.addRobot(rightPoint, createDimension(rightPoint, robotLength, robotLength), "Robot0");

        //System.out.println(factory1);

        CanvasViewer canvasViewer = new CanvasViewer((Canvas)factory1);
    }

    private static Point createPoint(double x, double y)
    {
        return new Point(x, y);
    }

    private static Door[] createSingleArrayHorizontalDoors(String name, Point pos)
    {
        Point left = new Point(pos.x - 10, pos.y);
        Point right = new Point(pos.x + 10, pos.y);
        Door[] res = new Door[1];
        res[0] = new Door(left, right, name);
        return res;
    }

    private static Area[] createSingleArrayAreaWithOneMachine(String name, Point pos)
    {
        Dimension dimension = createDimension(pos, 100, 100); 
        Area[] res = new Area[1];
        Machine[] machines = new Machine[1];
        machines[0] = new Machine(pos, dimension, "name's Machine");
        res[0] = new Area(pos, dimension, machines, name);
        return res;
    }

    private static ChargingStation[] createSingleArrayStations(String name, Point pos)
    {
        Dimension dimension = createDimension(pos, 50, 50);
        ChargingStation[] res = new ChargingStation[1];
        res[0] = new ChargingStation(pos, dimension, name);
        return res;
    }

    private static Puck[] createSingleArrayPuck(String name, Point pos)
    {
        Dimension dimension = createDimension(pos, 5, 5);
        Puck[] res = new Puck[1];
        res[0] = new Puck(pos, dimension, name);
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
