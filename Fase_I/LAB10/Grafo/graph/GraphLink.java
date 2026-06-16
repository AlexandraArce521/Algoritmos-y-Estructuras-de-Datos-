package graph;
import java.util.ArrayList;
import Exceptions.*;
import Stack.StackLink;
import LINKEDlist.ListLinked;
import Queue.*;


public class GraphLink<T> {
	private ListLinked<AdjList<T>> graph;

    public GraphLink() {
        this.graph = new ListLinked<>();
    }
    
    //=========
    public void insertVertex(T data) {
        Vertex<T> vertex = new Vertex<>(data);
        graph.insertLast(new AdjList<>(vertex));
    }
    
    //========
    private AdjList<T> findVertex(T data) {
        for (int i = 0; i < graph.size(); i++) {
            AdjList<T> adj = graph.get(i);
            
            if (adj.getVertex().getData().equals(data))
                return adj;
        }
        
        return null;
    }
    
    //===========
    public void insertEdge(T origin, T destination) {
        AdjList<T> v1 = findVertex(origin);
        AdjList<T> v2 = findVertex(destination);

        if (v1 == null || v2 == null)
            return;

        v1.getEdges().insertLast(new Edge<>(v2.getVertex()));
        v2.getEdges().insertLast(new Edge<>(v1.getVertex()));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < graph.size(); i++) {
            AdjList<T> adj = graph.get(i);
            sb.append(adj.getVertex()).append(" -> ");

            for (int j = 0; j < adj.getEdges().size(); j++) {
                sb.append(adj.getEdges().get(j)).append(" ");
            }
            sb.append("\n");
        }
        
        return sb.toString();
    }
    
    //========
    public void removeEdge(T origin, T destination) {
        AdjList<T> v1 = findVertex(origin);
        AdjList<T> v2 = findVertex(destination);

        if (v1 == null || v2 == null)
            return;

        for (int i = 0; i < v1.getEdges().size(); i++) {
            Edge<T> edge = v1.getEdges().get(i);

            if (edge.getDestination().getData().equals(destination)) {
                v1.getEdges().removeNode(edge);
                break;
            }
        }

        for (int i = 0; i < v2.getEdges().size(); i++) {
            Edge<T> edge = v2.getEdges().get(i);

            if (edge.getDestination().getData().equals(origin)) {
                v2.getEdges().removeNode(edge);
                break;
            }
        }
    }
    
    //======
    public void removeVertex(T data) {
        AdjList<T> vertice = findVertex(data);

        if (vertice == null)
            return;

        for (int i = 0; i < graph.size(); i++) {
            AdjList<T> adj = graph.get(i);

            for (int j = 0; j < adj.getEdges().size(); j++) {
                Edge<T> edge = adj.getEdges().get(j);

                if (edge.getDestination().getData().equals(data)) {
                    adj.getEdges().removeNode(edge);
                    j--;
                }
            }
        }

        graph.removeNode(vertice);
    }
    
    //=======
    public ArrayList<T> BFS(T origen) throws ExceptionIsEmpty {
        ArrayList<T> visitados = new ArrayList<>();
        AdjList<T> inicial = findVertex(origen);

        if (inicial == null) {
            return visitados;
        }

        DequeLink<Vertex<T>> cola = new DequeLink<>();
        cola.addLast(inicial.getVertex());
        visitados.add(origen);

        while (!cola.isEmpty()) {
            Vertex<T> actual = cola.removeFirst();
            AdjList<T> adj = findVertex(actual.getData());

            for (int i = 0; i < adj.getEdges().size(); i++) {
                Vertex<T> vecino = adj.getEdges().get(i).getDestination();

                if (!visitados.contains(vecino.getData())) {
                    visitados.add(vecino.getData());
                    cola.addLast(vecino);
                }
            }
        }
        return visitados;
    }
    
    //=====
    public ArrayList<T> DFS(T origen) {
        ArrayList<T> visitados = new ArrayList<>();
        AdjList<T> inicial = findVertex(origen);

        if (inicial == null) {
            return visitados;
        }

        dfs(inicial.getVertex(), visitados);
        return visitados;
    }
    
    //=========
    private void dfs(Vertex<T> v, ArrayList<T> visitados) {
        visitados.add(v.getData());

        AdjList<T> adj = findVertex(v.getData());

        for (int i = 0; i < adj.getEdges().size(); i++) {
            Vertex<T> vecino = adj.getEdges().get(i).getDestination();

            if (!visitados.contains(vecino.getData())) {
                dfs(vecino, visitados);
            }
        }
    }
    
    
    //=====| EJERCICIO 01 |==== ========================== =======================
    public void insertEdgeWeight(T origin, T destination, int weight) {
        AdjList<T> v1 = findVertex(origin);
        AdjList<T> v2 = findVertex(destination);

        if (v1 == null || v2 == null)
            return;

        v1.getEdges().insertLast(new Edge<>(v2.getVertex(), weight));
        v2.getEdges().insertLast(new Edge<>(v1.getVertex(), weight));
    }
    
    //=======
    public ArrayList<T> shortPath(T origen, T destino) throws ExceptionIsEmpty {
        StackLink<T> pila = Dijkstra(origen, destino);
        ArrayList<T> camino = new ArrayList<>();

        while (!pila.isEmpty()) {
            camino.add(pila.pop());
        }

        return camino;
    }
    
    //======
    public boolean isConexo() {
        if (graph.size() == 0) {
            return true;
        }

        ArrayList<T> visitados = new ArrayList<>();
        dfs(graph.get(0).getVertex(), visitados);

        return visitados.size() == graph.size();
    }
    
    //=======
    private Registro<T> buscarRegistro(ListLinked<Registro<T>> registros, T dato) {
        for (int i = 0; i < registros.size(); i++) {
            Registro<T> r = registros.get(i);

            if (r.vertice.equals(dato)) {
                return r;
            }
        }

        return null;
    }
    
    //====
    public StackLink<T> Dijkstra(T origen, T destino) {
        ListLinked<Registro<T>> registros = new ListLinked<>();

        for (int i = 0; i < graph.size(); i++) {
            T dato = graph.get(i).getVertex().getData();
            registros.insertLast(new Registro<>(dato));
        }

        buscarRegistro(registros, origen).distancia = 0;
        
        while (true) {
            Registro<T> actual = null;

            for (int i = 0; i < registros.size(); i++) {
                Registro<T> r = registros.get(i);
                
                if (!r.visitado) {
                    if (actual == null || r.distancia < actual.distancia) {
                        actual = r;
                    }
                }
            }

            if (actual == null ||
                actual.distancia == Integer.MAX_VALUE) {
                break;
            }

            actual.visitado = true;
            AdjList<T> adj = findVertex(actual.vertice);

            for (int i = 0; i < adj.getEdges().size(); i++) {
                Edge<T> edge = adj.getEdges().get(i);
                T vecino = edge.getDestination().getData();

                Registro<T> regVecino = buscarRegistro(registros, vecino);

                if (regVecino.visitado) {
                    continue;
                }

                int nuevaDistancia = actual.distancia + edge.getWeight();

                if (nuevaDistancia < regVecino.distancia) {
                    regVecino.distancia = nuevaDistancia;
                    regVecino.anterior = actual.vertice;
                }
            }
        }

        StackLink<T> ruta = new StackLink<>();
        T actual = destino;

        while (actual != null) {
            ruta.push(actual);
            Registro<T> r = buscarRegistro(registros, actual);
            actual = r.anterior;
        }

        return ruta;
    }
    
    
    //=====| EJERCICIO 04 |============= =============== ============ =======
    private int contarAristas() {
        int total = 0;

        for (int i = 0; i < graph.size(); i++) {
            total += graph.get(i).getEdges().size();
        }

        return total / 2;
    }
    
    //========
    public boolean isPlano() {
        int V = graph.size();
        int E = contarAristas();

        if (V < 3)
            return true;

        return E <= (3 * V - 6);
    }
    
    //=====
    private int grado(T dato) {
        AdjList<T> adj = findVertex(dato);

        if (adj == null)
            return 0;

        return adj.getEdges().size();
    }
    
    //=========
    private void ordenar(int[] arreglo) {
        for (int i = 0; i < arreglo.length - 1; i++) {
            for (int j = 0; j < arreglo.length - i - 1; j++) {

                if (arreglo[j] > arreglo[j + 1]) {
                    int aux = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = aux;
                }
            }
        }
    }
    
    //==========
    public boolean isIsomorfo(GraphLink<T> otro) {
        if (graph.size() != otro.graph.size())
            return false;

        if (contarAristas() != otro.contarAristas())
            return false;

        int[] grados1 = new int[graph.size()];
        int[] grados2 = new int[otro.graph.size()];

        for (int i = 0; i < graph.size(); i++) {
            grados1[i] =
                graph.get(i).getEdges().size();
        }

        for (int i = 0; i < otro.graph.size(); i++) {
            grados2[i] =
                otro.graph.get(i).getEdges().size();
        }

        ordenar(grados1);
        ordenar(grados2);

        for (int i = 0; i < grados1.length; i++) {
            if (grados1[i] != grados2[i])
                return false;
        }

        return true;
    }
    
    //===========
    public GraphLink<T> complemento() {
        GraphLink<T> comp = new GraphLink<>();

        for (int i = 0; i < graph.size(); i++) {
            T dato = graph.get(i).getVertex().getData();

            comp.insertVertex(dato);
        }

        for (int i = 0; i < graph.size(); i++) {
            T v1 =  graph.get(i).getVertex().getData();

            for (int j = i + 1; j < graph.size(); j++) {
                T v2 = graph.get(j).getVertex().getData();

                if (!searchEdge(v1, v2)) {
                    comp.insertEdge(v1, v2);
                }
            }
        }

        return comp;
    }
    
    //=======
    public boolean isAutoComplementario() {
        GraphLink<T> comp = complemento();
        return isIsomorfo(comp);
    }
    
    //=====
    public boolean searchEdge(T origin, T destination) {
        AdjList<T> adj = findVertex(origin);

        if (adj == null)
            return false;

        for (int i = 0; i < adj.getEdges().size(); i++) {
            Edge<T> edge = adj.getEdges().get(i);

            if (edge.getDestination().getData().equals(destination)) {
                return true;
            }
        }

        return false;
    }
}


