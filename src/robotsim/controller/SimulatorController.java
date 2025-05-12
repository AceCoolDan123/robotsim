package robotsim.controller;

import robotsim.model.Factory;

import fr.tp.inf112.projects.canvas.controller.CanvasViewerController;
import fr.tp.inf112.projects.canvas.controller.Observer;
import fr.tp.inf112.projects.canvas.model.CanvasPersistenceManager;
import fr.tp.inf112.projects.canvas.model.Canvas;


public class SimulatorController implements CanvasViewerController 
{

    private final Factory factoryModel;

    public SimulatorController(Factory factoryModel)
    {
        this.factoryModel = factoryModel;
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
        return factoryModel;
    }
	
	public void setCanvas(Canvas canvasModel)
    {
        this.factoryModel = canvasModel;
    }
	
	/*public CanvasPersistenceManager getPersistenceManager()
    {

    }*/
	
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
