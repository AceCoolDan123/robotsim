package robotsim.controller;

import fr.tp.inf112.projects.canvas.controller.Observer;


public class FactoryViewer implements Observer
{
    private final SimulatorController controller;

    public FactoryViewer(SimulatorController controller) 
    {
        this.controller = controller;
        controller.addObserver(this);
    }
    
    @Override
    public void modelChanged() 
    {
        repaint();
    }
    
    @Override
    public void dispose() 
    {
        controller.removeObserver(this);
        super.dispose();
    }

}
