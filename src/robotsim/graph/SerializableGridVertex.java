package robotsim.graph;

import fr.tp.inf112.projects.graph.impl.GridVertex;

import java.io.Serializable;

public class SerializableGridVertex extends GridVertex implements Serializable
{
    public SerializableGridVertex(final String label, final int x, final int y)
    {
        super(label, x, y);
    }
}