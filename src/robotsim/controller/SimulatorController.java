package robotsim.controller;

import robotsim.model.Factory;

import robotsim.persistence.FactoryPersistenceManager;

import fr.tp.inf112.projects.canvas.controller.CanvasViewerController;
import fr.tp.inf112.projects.canvas.controller.Observer;
import fr.tp.inf112.projects.canvas.model.CanvasPersistenceManager;
import fr.tp.inf112.projects.canvas.model.Canvas;
import fr.tp.inf112.projects.canvas.view.FileCanvasChooser;


public class SimulatorController implements CanvasViewerController 
{

    private final Factory factoryModel;
    private Canvas canvasModel;
    private FactoryPersistenceManager persistenceManager = new FactoryPersistenceManager(new FileCanvasChooser("fctr", "factoy"));

    public SimulatorController(Factory factoryModel)
    {
        this.factoryModel = factoryModel;
        this.canvasModel = (Canvas)factoryModel;
    }

    public boolean addObserver(Observer observer)
    {
        return factoryModel.addObserver(observer);
    }

	public boolean removeObserver(Observer observer)
    {
        return factoryModel.addObserver(observer);
    }

    public final Canvas getCanvas()
    {
        return canvasModel;
    }

	public void setCanvas(Canvas canvasModel)
    {
        this.canvasModel = canvasModel;
    }
	
	public CanvasPersistenceManager getPersistenceManager()
    {
        return persistenceManager;
    }
	
	public void startAnimation()
    {
        factoryModel.startSimulation();
    }

	public void stopAnimation()
    {
        factoryModel.stopSimulation();
    }
	
	public boolean isAnimationRunning()
    {
        return factoryModel.isSimulationRunning();
    }
}
