package EJERCICIO_03;
import java.util.ArrayList;

public interface Graph<V, E> {
	void insertVertex(V v);
    void insertEdge(V origin, V destination, E edge);
    void removeVertex(V v);
    void removeEdge(V origin, V destination);
    boolean searchVertex(V v);
    boolean searchEdge(V origin, V destination);
    ArrayList<V> adjacentVertices(V v);
}
