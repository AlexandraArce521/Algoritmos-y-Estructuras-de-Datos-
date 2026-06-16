package graph;
import LINKEDlist.ListLinked;

public class AdjList<T> {
	private Vertex<T> vertex;
    private ListLinked<Edge<T>> edges;

    public AdjList(Vertex<T> vertex) {
        this.vertex = vertex;
        this.edges = new ListLinked<>();
    }

    public Vertex<T> getVertex() {
        return this.vertex;
    }
    
    public ListLinked<Edge<T>> getEdges(){
    	return this.edges;
    }
}
