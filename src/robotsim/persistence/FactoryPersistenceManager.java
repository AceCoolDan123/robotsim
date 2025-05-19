package robotsim.persistence;

import java.io.IOException;

import fr.tp.inf112.projects.canvas.model.impl.AbstractCanvasPersistenceManager;
import fr.tp.inf112.projects.canvas.model.CanvasChooser;

public class FactoryPersistenceManager extends AbstractCanvasPersistenceManager
{

    public FactoryPersistenceManager(final CanvasChooser factoryChooser)
    {
        super(factoryChooser);
    }

	/*@Override
	public CanvasChooser getCanvasChooser() {
		return canvasChooser;
	}*/

    Canvas read(String canvasId)
	throws IOException;

	/**
	 * Persists the specified canvas model into the data store of this persistence manager.
	 * 
	 * @param canvasModel The canvas model object.
	 * 
	 * @throws IOException When a problem occurs when persisting the canvas (e.g. wrong {@code canvasId}, unavailable data store
	 * or locked resource, etc.).
	 */
	void persist(Canvas canvasModel)
	throws IOException;

	/**
	 * Deletes the specified canvas model from the data store of this persistence manager.
	 * 
	 * @param canvasModel The canvas model object.
	 * 
	 * @return A {@code boolean} stating if the specified canvas model was removed or not from the data store, according to its existence in the data store.
	 * 
	 * @throws IOException When a problem occurs when deleting the canvas (e.g. wrong {@code canvasId}, unavailable data store
	 * or locked resource, etc.).
	 */
	boolean delete(Canvas canvasModel)
	throws IOException;
	

}
