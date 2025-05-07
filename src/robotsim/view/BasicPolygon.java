import java.util.Set;
import java.util.HashSet;

import fr.tp.inf112.projects.canvas.model.PolygonShape;
import fr.tp.inf112.projects.canvas.model.Vertex;

public class BasicPolygon implements PolygonShape
{
    private Set<Vertex> vertices;

    public BasicPolygon()
    {
        vertices = new HashSet<>();
    }

    public BasicPolygon(Set<Vertex> vertices)
    {
        this.vertices = vertices;
    }

    public void addVertex(Vertex vertex)
    {
        vertices.add(vertex);
    }

    public Set<Vertex> getVertices()
    {
        return vertices;
    }

}