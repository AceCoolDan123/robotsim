package robotsim.controller;

import robotsim.model.Factory;
import robotsim.persistence.FactoryPersistenceManager;

import fr.tp.inf112.projects.canvas.controller.CanvasViewerController;
import fr.tp.inf112.projects.canvas.controller.Observer;
import fr.tp.inf112.projects.canvas.model.CanvasPersistenceManager;
import fr.tp.inf112.projects.canvas.model.Canvas;


public class SimulatorController implements CanvasViewerController 
{

    private final Factory factoryModel;
    private Canvas canvasModel;
    private final FactoryPersistenceManager persistenceManager;

    public SimulatorController(Factory factoryModel, FactoryPersistenceManager persistenceManager)
    {
        this.factoryModel = factoryModel;
        this.canvasModel = (Canvas)factoryModel;
        this.persistenceManager = persistenceManager;
    }

    @Override
    public boolean addObserver(Observer observer)
    {
        return factoryModel.addObserver(observer);
    }

    @Override
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
	
    @Override
	public void startAnimation()
    {
        factoryModel.startSimulation();
    }

    @Override
	public void stopAnimation()
    {
        factoryModel.stopSimulation();
    }
	
    @Override
	public boolean isAnimationRunning()
    {
        return factoryModel.isSimulationRunning();
    }
}
