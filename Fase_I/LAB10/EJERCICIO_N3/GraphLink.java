package EJERCICIO_03;
import java.util.ArrayList;

public class GraphLink<V, E> implements Graph<V, E> {
	private ArrayList<AdjList<V, E>> listaAdj;

    public GraphLink() {
        this.listaAdj = new ArrayList<>();
    }

    // ---------------------
    public void insertVertex(V v) {
        if (!searchVertex(v)) {
            listaAdj.add(new AdjList<>(new Vertex<>(v)));
        }
    }

    // ----------------------
    public void insertEdge(V origin, V destination, E weight) {
        AdjList<V, E> o = findVertex(origin);
        AdjList<V, E> d = findVertex(destination);
        
        if (o == null || d == null) {
        	return;
        }
        
        o.getEdges().add(new Edge<>(d.getVertex(), weight));
        d.getEdges().add(new Edge<>(o.getVertex(), weight));
    }

    // -------------------------
    public void removeVertex(V v) {
        AdjList<V, E> target = findVertex(v);
        
        if (target == null) {
        	return;
        }

        listaAdj.remove(target);

        for (AdjList<V, E> adj : listaAdj) {
            ArrayList<Edge<V, E>> edges = adj.getEdges();

            for (int i = 0; i < edges.size(); i++) {
                Edge<V, E> actual = edges.get(i);

                if (actual.getDestination().getData().equals(v)) {
                    edges.remove(i);
                    i--;
                }
            }
        }
    }

    // -------------------------
    public void removeEdge(V origin, V destination) {
        AdjList<V, E> o = findVertex(origin);
        AdjList<V, E> d = findVertex(destination);

        if (o == null || d == null) {
            return;
        }

        ArrayList<Edge<V, E>> edgesOrigin = o.getEdges();
        for (int i = 0; i < edgesOrigin.size(); i++) {
            Edge<V, E> actual = edgesOrigin.get(i);

            if (actual.getDestination().getData().equals(destination)) {
                edgesOrigin.remove(i);
                i--; 
            }
        }

        ArrayList<Edge<V, E>> edgesDest = d.getEdges();
        for (int i = 0; i < edgesDest.size(); i++) {
            Edge<V, E> actual = edgesDest.get(i);

            if (actual.getDestination().getData().equals(origin)) {
                edgesDest.remove(i);
                i--; 
            }
        }
    }

    // -------------------------
    public boolean searchVertex(V v) {
        return findVertex(v) != null;
    }

    // -------------------------
    public boolean searchEdge(V origin, V destination) {
        AdjList<V, E> o = findVertex(origin);

        if (o == null) {
        	return false;
        }

        for (Edge<V, E> v : o.getEdges()) {
            if (v.getDestination().getData().equals(destination)) {
                return true;
            }
        }
        return false;
    }

    // -------------------------
    public ArrayList<V> adjacentVertices(V v) {
        AdjList<V, E> adj = findVertex(v);
        ArrayList<V> result = new ArrayList<>();

        if (adj == null) {
        	return result;
        }

        for (Edge<V, E> x : adj.getEdges()) {
            result.add(x.getDestination().getData());
        }

        return result;
    }

    // -------------------------
    private AdjList<V, E> findVertex(V v) {
        for (AdjList<V, E> a : listaAdj) {
            if (a.getVertex().getData().equals(v)) {
                return a;
            }
        }
        return null;
    }
}
