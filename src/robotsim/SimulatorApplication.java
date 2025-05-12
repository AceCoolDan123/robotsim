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
import robotsim.model.Robot;

import fr.tp.inf112.projects.canvas.model.Canvas;
import fr.tp.inf112.projects.canvas.view.CanvasViewer;

public class SimulatorApplication {
    public static void main(String[] args) 
    {
        int factoryLength = 100;
        int roomLength = 20;
        int robotLength = 3;

        Point centerPoint = createPoint(factoryLength / 2 - roomLength / 2, factoryLength /2 - roomLength / 2);
        Point centerDoorPoint = createPoint(factoryLength / 2, factoryLength / 2 - roomLength / 2);
        Point leftPoint = createPoint(factoryLength / 4 - roomLength / 2, factoryLength / 2 - roomLength / 2);
        Point leftDoorPoint = createPoint(factoryLength / 4, factoryLength / 2 - roomLength / 2);
        Point rightPoint = createPoint(3 * factoryLength / 4 - roomLength, factoryLength / 2);
        Point rightDoorPoint = createPoint(3 * factoryLength / 4, factoryLength / 2 - roomLength / 2);
        Point chargingPoint = createPoint( 3 * factoryLength / 4, 3 * factoryLength / 4);
        Point puckPoint = createPoint(factoryLength / 4, factoryLength / 4);


        Room[] rooms = new Room[3];
        rooms[0] = new Room(leftPoint, new Dimension(roomLength, roomLength), 
                            createSingleArrayHorizontalDoors("DoorRoom0", leftDoorPoint), 
                            createSingleArrayAreaWithOneMachine("AreaRoom0", leftPoint), "Room0");
        rooms[1] = new Room(centerPoint, new Dimension(roomLength, roomLength), 
                            createSingleArrayHorizontalDoors("DoorRoom1", centerDoorPoint), 
                            createSingleArrayAreaWithOneMachine("AreaRoom1", centerPoint), "Room1");
        rooms[2] = new Room(rightPoint, new Dimension(roomLength, roomLength), 
                            createSingleArrayHorizontalDoors("DoorRoom2", rightDoorPoint), 
                            createSingleArrayAreaWithOneMachine("AreaRoom2", rightPoint), "Room2");

        Factory factory1 = new Factory(
            new Dimension(factoryLength, factoryLength),
            "Factory 1", rooms, 
            createSingleArrayStations("station0", chargingPoint), 
            createSingleArrayPuck(("puck0"), puckPoint));

        factory1.addRobot(leftPoint, new Dimension(robotLength, robotLength), "Robot0");
        factory1.addRobot(centerPoint, new Dimension(robotLength, robotLength), "Robot0");
        factory1.addRobot(rightPoint, new Dimension(robotLength, robotLength), "Robot0");

        //System.out.println(factory1.getFigures());

        Room[] roomsTest = new Room[1];
        roomsTest[0] = new Room(centerPoint, new Dimension(roomLength, roomLength), 
                            createSingleArrayHorizontalDoors("DoorRoom0", leftDoorPoint), 
                            createSingleArrayAreaWithOneMachine("AreaRoom0", leftPoint), "Room0");
        Factory test = new Factory(new Dimension(100,100), "factory1", null, null, null);
        test.addRobot(new Point(50,50), new Dimension(3, 3), "robot1");
        CanvasViewer testViewer = new CanvasViewer((Canvas)test);

        //CanvasViewer canvasViewer = new CanvasViewer((Canvas)factory1);
    }

    private static Point createPoint(float x, float y)
    {
        return new Point(x, y);
    }

    private static Door[] createSingleArrayHorizontalDoors(String name, Point pos)
    {
        Door[] res = new Door[1];
        res[0] = new Door(pos, 6, name, true);
        return res;
    }

    private static Area[] createSingleArrayAreaWithOneMachine(String name, Point pos)
    {
        Dimension dimension = new Dimension(10, 10); 
        Area[] res = new Area[1];
        Machine[] machines = new Machine[1];
        machines[0] = new Machine(pos, dimension, "name's Machine");
        res[0] = new Area(pos, dimension, machines, name);
        return res;
    }

    private static ChargingStation[] createSingleArrayStations(String name, Point pos)
    {
        Dimension dimension = new Dimension(10, 10);
        ChargingStation[] res = new ChargingStation[1];
        res[0] = new ChargingStation(pos, dimension, name);
        return res;
    }

    private static Puck[] createSingleArrayPuck(String name, Point pos)
    {
        Dimension dimension = new Dimension(2, 2);
        Puck[] res = new Puck[1];
        res[0] = new Puck(pos, dimension, name);
        return res;
    }
}