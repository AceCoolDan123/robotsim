import java.util.Set;


public class BasicPolygon implements PolygonShape
{
    private Set<Vertex> vertices;

    public BasicPolygon()
    {
        vertices = [];
    }

    public BasicPolygon(Set<Vertex> vertices)
    {
        this.vertices = vertices;
    }

    public addVertex(Vertex vertex)
    {
        vertices.add(vertex);
    }

    public Set<Vertex> getVertices()
    {
        return vertices;
    }

}