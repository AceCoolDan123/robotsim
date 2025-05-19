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

import fr.tp.inf112.projects.canvas.view.CanvasViewer;

public class SimulatorApplication {
    public static void main(String[] args) 
    {
        int factoryLength = 100;
        int roomLength = 20;
        int robotLength = 3;

        //Point centerPoint = createPoint(factoryLength / 2 - roomLength / 2, factoryLength /2 - roomLength / 2);
        //Point centerDoorPoint = createPoint(factoryLength / 2, factoryLength / 2 - roomLength / 2);
        Point leftPoint = createPoint(factoryLength / 4 - roomLength / 2, factoryLength / 2 - roomLength / 2);
        Point leftDoorPoint = createPoint(factoryLength / 4, factoryLength / 2 - roomLength / 2);
        Point rightPoint = createPoint(3 * factoryLength / 4 - roomLength / 2, factoryLength / 2 - roomLength / 2);
        Point rightDoorPoint = createPoint(3 * factoryLength / 4, factoryLength / 2 - roomLength / 2);
        Point chargingPoint = createPoint( 3 * factoryLength / 4, 3 * factoryLength / 4);
        Point puckPoint = createPoint(factoryLength / 4, factoryLength / 4);

        Factory factory1 = new Factory(
            new Dimension(factoryLength, factoryLength),
            "Factory 1");

        Room room0 = new Room(leftPoint, new Dimension(roomLength, roomLength), 
                            createSingleArrayHorizontalDoors("DoorRoom0", leftDoorPoint), 
                            createSingleArrayAreaWithOneMachine("AreaRoom0", leftPoint), "Room0");
        Room room1 = new Room(rightPoint, new Dimension(roomLength, roomLength), 
                            createSingleArrayHorizontalDoors("DoorRoom1", rightDoorPoint), 
                            createSingleArrayAreaWithOneMachine("AreaRoom1", rightPoint), "Room1");

        factory1.addComponent(room0);
        factory1.addComponent(room1);

        factory1.addComponent(new ChargingStation(chargingPoint, new Dimension(10, 10), "Charging Station"));
        factory1.addComponent(new Puck(puckPoint, new Dimension(2, 2), "Puck"));

=======
        Robot robot1 = new Robot(new Point(leftDoorPoint.getxCoordinate(), leftDoorPoint.getyCoordinate() - 5), new Dimension(robotLength, robotLength), "Robot0", (float)1, factory);
        robot1.addDestination(puckPoint);
        robot1.addDestination(chargingPoint);
        robot1.addDestination(puckPoint);

        factory1.addComponent(robot1);

        factory1.constructGraph();

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
