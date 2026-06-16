package EJERCICIO_03;

public class Edge<V, E> {
    private Vertex<V> destination;
    private E weight;

    public Edge(Vertex<V> destination, E weight) {
        this.destination = destination;
        this.weight = weight;
    }

    public Vertex<V> getDestination() {
        return destination;
    }

    public E getWeight() {
        return weight;
    }
}
