package EJERCICIO_03;
import java.util.ArrayList;

public class AdjList<V, E> {
	Vertex<V> vertex;
    ArrayList<Edge<V, E>> edges;

    public AdjList(Vertex<V> vertex) {
        this.vertex = vertex;
        this.edges = new ArrayList<>();
    }

    public Vertex<V> getVertex() {
        return vertex;
    }

    public ArrayList<Edge<V, E>> getEdges() {
        return edges;
    }
}
