package graph;

public class Edge<T> {
	private Vertex<T> destination;
    private int weight;

    public Edge(Vertex<T> destination) {
        this(destination, 1);
    }

    public Edge(Vertex<T> destination, int weight) {
        this.destination = destination;
        this.weight = weight;
    }

    public Vertex<T> getDestination() {
        return destination;
    }

    public int getWeight() {
        return weight;
    }

    public void setDestination(Vertex<T> destination) {
        this.destination = destination;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return destination.toString();
    }
}
