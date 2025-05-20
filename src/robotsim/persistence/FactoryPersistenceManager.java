package robotsim.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import fr.tp.inf112.projects.canvas.model.impl.AbstractCanvasPersistenceManager;
import fr.tp.inf112.projects.canvas.view.CanvasViewer;
import fr.tp.inf112.projects.canvas.model.Canvas;
import fr.tp.inf112.projects.canvas.model.CanvasChooser;

import robotsim.controller.SimulatorController;
import robotsim.model.Factory;

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

    public Canvas read(String canvasId) throws IOException
	{
		try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(canvasId))) {
            Object object = objectInputStream.readObject();
            if (object instanceof Canvas) {
                if (object instanceof Factory) {
                    SimulatorController controller = new SimulatorController((Factory) object);

                    CanvasViewer canvasViewer = new CanvasViewer(controller);
                    controller.addObserver(canvasViewer);
                    canvasViewer.startAnimation();
                }
                return (Canvas) object;
            } else {
                throw new IOException("Le fichier ne contient pas un objet Canvas valide.");
            }
        } catch (ClassNotFoundException e) {
            throw new IOException("Classe Canvas non trouvée lors de la désérialisation.", e);
        }
	}

	public void persist(Canvas canvasModel)
	throws IOException
	{

        if (canvasModel.getId() == null || canvasModel.getId().isEmpty()) {
            String newId = this.getCanvasChooser().newCanvasId();
            canvasModel.setId(newId);
            /*System.out.println("newId = "+ newId);
            System.out.println("canvasModel.getId() = " + canvasModel.getId());*/
        }

		String canvasId = canvasModel.getId();
        File file = new File(canvasId);
        File parentDir = file.getParentFile();
        
        if (parentDir != null && !parentDir.exists()) {
            if (!parentDir.mkdirs()) {
                throw new IOException("Impossible de créer le répertoire : " + parentDir.getAbsolutePath());
            }
        }

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            objectOutputStream.writeObject(canvasModel);
        } catch (IOException e) {
            throw new IOException("Erreur lors de la sauvegarde du canvas : " + e.getMessage(), e);
        }
	}

	public boolean delete(Canvas canvasModel)
	throws IOException
	{
		String canvasId = canvasModel.getId();
        File file = new File(canvasId);

        if (!file.exists()) {
            throw new IOException("Fichier à supprimer introuvable : " + canvasId);
        }

        if (!file.delete()) {
            throw new IOException("Échec de la suppression du fichier : " + canvasId);
        }

        return true;
    }
	
}
