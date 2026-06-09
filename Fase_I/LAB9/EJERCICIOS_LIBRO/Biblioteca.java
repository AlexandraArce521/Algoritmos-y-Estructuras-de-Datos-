package EjercicioLibro;
import btree.BTree;
import btree.BNode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Biblioteca {
	public BTree<Libro> arbol;
	
	public Biblioteca() {
    }

    public void agregarLibro(Libro libro) {
        arbol.insert(libro);
    }

    public boolean buscarLibro(String isbn) {
        return arbol.search(new Libro(isbn, "", "", 0));
    }

    public void eliminarLibro(String isbn) {
        arbol.delete(new Libro(isbn, "", "", 0));
    }
    
    public void mostrarLibros() {
        System.out.println(arbol);
    }
    
    //=============== ===================
    public void cargarArchivo(String archivo) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(archivo));

        int orden = Integer.parseInt(br.readLine());
        arbol = new BTree<>(orden);

        String linea;
        while ((linea = br.readLine()) != null) {
            String[] datos = linea.split(",");

            String isbn = datos[0];
            String titulo = datos[1];
            String autor = datos[2];
            int anio = Integer.parseInt(datos[3]);

            Libro libro = new Libro(isbn, titulo, autor, anio);

            arbol.insert(libro);
        }

        br.close();
    }
    
    //================== ===================
    public int alturaArbol() {
        return arbol.height();
    }
    
    //============== ============= ==========
    public int cantidadLibros() {
        return arbol.count();
    }
    
    //===========================
    public void buscarLibroPorISBN(String isbn) {
        BNode<Libro> current = arbol.getRoot();
        Libro key = new Libro(isbn, "", "", 0);

        System.out.print("Recorrido: ");
        while (current != null) {
            System.out.print(current.getIdNode() + " -> ");
            
            int[] pos = new int[1];

            if (current.searchNode(key, pos)) {
                System.out.println("\nEncontrado en nodo " + current.getIdNode() + " posición " + pos[0]);
                return;
            }

            current = current.getChilds().get(pos[0]);
        }

        System.out.println("\nNo encontrado");
    }
    
    //==================== ==================
    public void mostrarLibrosOrdenados() {
        inOrder(arbol.getRoot());
        System.out.println();
    }

    private void inOrder(BNode<Libro> node) {
        if (node == null) {
        	return;
        }
        
        int i;
        for (i = 0; i < node.getCount(); i++) {
            inOrder(node.getChilds().get(i));
            System.out.print(node.getKeys().get(i) + " ");
        }

        inOrder(node.getChilds().get(i));
    }
    
}
