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

import robotsim.controller.SimulatorController;

import fr.tp.inf112.projects.canvas.model.Canvas;
import fr.tp.inf112.projects.canvas.view.CanvasViewer;
import javax.swing.text.Position;

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
        Point rightPoint = createPoint(3 * factoryLength / 4 - roomLength / 2, factoryLength / 2 - roomLength / 2);
        Point rightDoorPoint = createPoint(3 * factoryLength / 4, factoryLength / 2 - roomLength / 2);
        Point chargingPoint = createPoint( 3 * factoryLength / 4, 3 * factoryLength / 4);
        Point puckPoint = createPoint(factoryLength / 4, factoryLength / 4);

        Factory factory1 = new Factory(
            new Dimension(factoryLength, factoryLength),
            "Factory 1");

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

        for (Room room : rooms){
            factory1.addComponent(room);
        }

        factory1.addComponent(new ChargingStation(chargingPoint, new Dimension(10, 10), "Charging Station"));
        factory1.addComponent(new Puck(puckPoint, new Dimension(2, 2), "Puck"));

        Robot robot1 = new Robot(new Point(leftDoorPoint.x, leftDoorPoint.y - 5), new Dimension(robotLength, robotLength), "Robot0", (float)1);
        robot1.addComponentToVisit(rooms[2]);
        robot1.addComponentToVisit(rooms[0]);
        robot1.addComponentToVisit(rooms[1]);
        factory1.addComponent(robot1);
        Robot robot2 = new Robot(new Point(centerDoorPoint.x, centerDoorPoint.y - 5), new Dimension(robotLength, robotLength), "Robot1", (float)1);
        robot2.addComponentToVisit(rooms[1]);
        robot2.addComponentToVisit(rooms[0]);
        robot2.addComponentToVisit(rooms[2]);
        factory1.addComponent(robot2);
        Robot robot3 = new Robot(new Point(rightDoorPoint.x, rightDoorPoint.y - 5), new Dimension(robotLength, robotLength), "Robot2", (float)1);
        robot3.addComponentToVisit(rooms[2]);
        robot3.addComponentToVisit(rooms[1]);
        robot3.addComponentToVisit(rooms[0]);
        factory1.addComponent(robot3);


        //System.out.println(factory1.getFigures());

        //Room[] roomsTest = new Room[1];
        //roomsTest[0] = new Room(centerPoint, new Dimension(roomLength, roomLength), 
                            //createSingleArrayHorizontalDoors("DoorRoom0", leftDoorPoint), 
                            //createSingleArrayAreaWithOneMachine("AreaRoom0", leftPoint), "Room0");
        //Factory test = new Factory(new Dimension(100,100), "factory1", roomsTest, null, null);
        //test.addRobot(new Point(50,50), new Dimension(3, 3), "robot1");
        //CanvasViewer testViewer = new CanvasViewer((Canvas)test);
        //System.out.println("factory1.figures : " + factory1.getFigures());

        SimulatorController controller = new SimulatorController(factory1);

        CanvasViewer canvasViewer = new CanvasViewer(controller);
        controller.addObserver(canvasViewer);
        canvasViewer.startAnimation();
    }

    private static Point createPoint(float x, float y)
    {
        return new Point(x, y);
    }

    private static Door[] createSingleArrayHorizontalDoors(String name, Point pos)
    {
        Door[] res = new Door[1];
        res[0] = new Door(pos, 6, name, false);
        return res;
    }

    private static Area[] createSingleArrayAreaWithOneMachine(String name, Point pos)
    {
        Dimension areaDimension = new Dimension(10, 10); 
        Dimension machineDimension = new Dimension(5, 5); 
        Area[] res = new Area[1];
        Machine[] machines = new Machine[1];
        machines[0] = new Machine(new Point(pos.x + 8,  pos.y + 8), machineDimension, "name's Machine");
        res[0] = new Area(new Point(pos.x + 20 / 4,  pos.y + 20 / 4), areaDimension, machines, name);
        return res;
    }
}