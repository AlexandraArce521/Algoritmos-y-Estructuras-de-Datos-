package EJERCICIO03;
import AVLTREE.AVLTree;
import Exceptions.*;

public class PruebaEliminacion {
    public static void main(String[] args) {
        AVLTree<Integer> avl = new AVLTree<>();

        System.out.println("Preparando árbol: 30, 20, 40, 10, 25, 50, 55");
        try {
            for (int x : new int[]{30, 20, 40, 10, 25, 50, 55}) {
                avl.insert(x);
            }
        } catch (ItemDuplicated e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nÁrbol inicial:");
        avl.drawBST();

        System.out.println("║  Clave   ║    Caso BST      ║ Sucesor  ║  Nodo desbal.     ║  Rotación        ║");

        eliminarYMostrar(avl, 10, "Nodo hoja", "-", "Ninguno", "Ninguna");

        eliminarYMostrar(avl, 25, "Un hijo (izq)", "-", "20", "Ninguna");

        eliminarYMostrar(avl, 30, "Dos hijos", "40", "40", "RSL (Simple Izq)");

        eliminarYMostrar(avl, 20, "Nodo hoja", "-", "40", "RSR (Simple Der)");

        eliminarYMostrar(avl, 55, "Nodo hoja", "-", "50", "RDL (Doble Izq)");

        System.out.println("\nÁrbol final:");
        avl.drawBST();
        System.out.println("InOrden: " + avl.getInOrder());
        System.out.println("¿BST válido? " + avl.isValidBST());
    }

    private static void eliminarYMostrar(AVLTree<Integer> avl, int clave,
                                         String casoBST, String sucesor,
                                         String nodoDesbal, String rotacion) {
        System.out.printf("║  %-8d║  %-16s║  %-8s║  %-17s║  %-16s║%n",
                clave, casoBST, sucesor, nodoDesbal, rotacion);
        try {
            avl.delete(clave);
        } catch (ExceptionIsEmpty e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("  Árbol tras eliminar " + clave + ":");
        avl.drawBST();
        System.out.println("  InOrden: " + avl.getInOrder());
    }
}
