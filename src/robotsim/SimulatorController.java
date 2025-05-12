package robotsim;

import fr.tp.inf112.projects.canvas.controller.CanvasViewerController;
import fr.tp.inf112.projects.canvas.model.Canvas;
import fr.tp.inf112.projects.canvas.model.CanvasPersistenceManager;

public class SimulatorController implements CanvasViewerController {

    private Canvas canvas;

    public SimulatorController() {}

    public SimulatorController(Canvas canvas)
    {
        this.canvas = canvas;
    }

    Canvas getCanvas()
    {
        return canvas;
    }

   void setCanvas(Canvas var1)
   {
        canvas = var1;
   }

   CanvasPersistenceManager getPersistenceManager();

   void startAnimation();

   void stopAnimation();

   boolean isAnimationRunning(); 
}
