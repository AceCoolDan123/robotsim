package robotsim.graph;

import fr.tp.inf112.projects.graph.impl.GridEdge;
import fr.tp.inf112.projects.graph.impl.GridGraph;
import fr.tp.inf112.projects.graph.impl.GridVertex;

import java.io.Serializable;

public class SerializableGridEdge extends GridEdge implements Serializable
{
    public SerializableGridEdge(final GridGraph graph, final GridVertex v1, final GridVertex v2, final int distance)
    {
        super(graph, v1, v2, distance);
    }
}