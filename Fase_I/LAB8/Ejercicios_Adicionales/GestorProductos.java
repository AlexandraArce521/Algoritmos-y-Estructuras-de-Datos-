package EjerciciosExtras;
import AVLTREE.*;

import Exceptions.*;

public class GestorProductos {
    private AVLTree<Integer> arbolProductos;

    public GestorProductos() {
        this.arbolProductos = new AVLTree<>();
    }

    public AVLTree<Integer> getArbolProductos() {
        return arbolProductos;
    }

    //==========================================
    public void insertarProducto(int codigo) {
        try {
            arbolProductos.insert(codigo);
            System.out.println("  ✔ Producto [" + codigo + "] registrado correctamente.");
        } catch (ItemDuplicated e) {
            System.out.println("  ✘ Producto [" + codigo + "] ya existe en el sistema.");
        }
    }

    //==========================
    public boolean buscarProducto(int codigo) {
        try {
            arbolProductos.search(codigo);
            System.out.println("  ✔ Producto [" + codigo + "] encontrado en el almacén.");
            return true;
        } catch (ItemNoFound e) {
            System.out.println("  ✘ Producto [" + codigo + "] NO existe en el almacén.");
            return false;
        }
    }

    //======================================
    public void eliminarProducto(int codigo) {
        try {
            arbolProductos.delete(codigo);
            System.out.println("  ✔ Producto [" + codigo + "] eliminado del almacén.");
        } catch (ExceptionIsEmpty e) {
            System.out.println("  ✘ El árbol está vacío, no se puede eliminar.");
        }
    }
    
    //===================
    public void mostrarProductosOrdenados() {
        System.out.println("  Productos ordenados (InOrden): " + arbolProductos.getInOrder());
    }

    //============================
    public void mostrarArbol() {
        System.out.println("  Estructura del árbol AVL:");
        arbolProductos.drawBST();
    }

    //=====================
    public void mostrarPorNiveles() {
        System.out.print("  Recorrido por niveles: ");
        arbolProductos.recorridoPorAmplitudRecursivo();
    }

    //============================
    public void mostrarEstadisticas() {
        System.out.println("  Total de productos (todos los nodos): " + arbolProductos.countAllNodes());
        System.out.println("  Nodos internos (no hojas):            " + arbolProductos.countNodes());
        System.out.println("  Altura del árbol:                     " + arbolProductos.height(arbolProductos.getRoot().data));
    }
}
