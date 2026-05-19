package EJERCICIO02;

public class Principal {
    public static void main(String[] args) {

        System.out.println("========== CASO 1: Inserción ascendente ==========");
        System.out.println("Datos: 10, 20, 30, 40, 50");
        System.out.println("En BST esta secuencia genera una lista lineal (altura = n-1).");
        System.out.println("El AVL rebalancea y mantiene altura logarítmica.\n");

        ComparadorBST_AVL caso1 = new ComparadorBST_AVL();
        caso1.insertarDatos(new int[]{10, 20, 30, 40, 50});
        caso1.mostrarBST();
        caso1.mostrarAVL();
        caso1.buscarDato(30);
        caso1.buscarDato(99);

        System.out.println("\n\n========== CASO 2: Inserción balanceada natural ==========");
        System.out.println("Datos: 30, 10, 50, 5, 20, 40, 60");
        System.out.println("En BST esta secuencia ya produce un árbol relativamente balanceado.");
        System.out.println("El AVL confirma y mantiene el balance con rotaciones si es necesario.\n");

        ComparadorBST_AVL caso2 = new ComparadorBST_AVL();
        caso2.insertarDatos(new int[]{30, 10, 50, 5, 20, 40, 60});
        caso2.mostrarBST();
        caso2.mostrarAVL();
        caso2.buscarDato(20);
        caso2.buscarDato(99);
    }
}
