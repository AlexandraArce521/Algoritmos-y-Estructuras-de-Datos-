package Ejer_02;
import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.graph.SimpleWeightedGraph;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import java.util.Set;

public class RedCiudades {

    private Graph<String, DefaultWeightedEdge> grafo;

    public RedCiudades() {
        // Grafo ponderado no dirigido
        grafo = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
    }

    // Agregar ciudad (vértice)
    public void agregarCiudad(String ciudad) {
        grafo.addVertex(ciudad);
    }

    // Agregar carretera con distancia (arista con peso)
    public void agregarCarretera(String origen, String destino, double distancia) {
        DefaultWeightedEdge arista = grafo.addEdge(origen, destino);
        grafo.setEdgeWeight(arista, distancia);
    }

    // Mostrar todas las ciudades
    public void mostrarCiudades() {
        System.out.println("Ciudades registradas:");
        for (String ciudad : grafo.vertexSet()) {
            System.out.println("- " + ciudad);
        }
    }

    // Mostrar todas las conexiones (carreteras)
    public void mostrarCarreteras() {
        System.out.println("\nCarreteras registradas:");
        for (DefaultWeightedEdge arista : grafo.edgeSet()) {
            String origen = grafo.getEdgeSource(arista);
            String destino = grafo.getEdgeTarget(arista);
            double peso = grafo.getEdgeWeight(arista);
            System.out.println(origen + " - " + destino + " : " + peso + " km");
        }
    }

    // Calcular camino más corto usando Dijkstra
    public void caminoMasCorto(String origen, String destino) {
        DijkstraShortestPath<String, DefaultWeightedEdge> dijkstra = new DijkstraShortestPath<>(grafo);
        GraphPath<String, DefaultWeightedEdge> ruta = dijkstra.getPath(origen, destino);

        if (ruta == null) {
            System.out.println("No existe camino entre " + origen + " y " + destino);
            return;
        }

        System.out.println("\nCamino más corto entre " + origen + " y " + destino + ":");
        System.out.println(ruta.getVertexList());
        System.out.println("Costo total: " + ruta.getWeight() + " km");
    }
}
