package graph;

public class Registro<T> {
	T vertice;
    int distancia;
    T anterior;
    boolean visitado;

    public Registro(T vertice) {
        this.vertice = vertice;
        this.distancia = Integer.MAX_VALUE;
        this.anterior = null;
        this.visitado = false;
    }
}
