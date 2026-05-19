package EjerciciosExtras;

public class MainProductos {

    public static void main(String[] args) {

        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║   SISTEMA DE PRODUCTOS - ÁRBOL AVL       ║");
        System.out.println("╚══════════════════════════════════════════╝\n");

        GestorProductos gestor = new GestorProductos();

        System.out.println("[ 1 ] Registrando productos en el almacén...");
        int[] codigos = {50, 30, 70, 20, 40, 60, 80};
        for (int codigo : codigos) {
            gestor.insertarProducto(codigo);
        }

        System.out.println("\n  Intentando registrar producto duplicado (50):");
        gestor.insertarProducto(50);

        System.out.println("\n[ 2 ] Listado de productos:");
        gestor.mostrarProductosOrdenados();

        System.out.println("\n[ 3 ] Estructura del árbol AVL:");
        gestor.mostrarArbol();

        System.out.println("\n[ 4 ] Búsquedas de productos:");
        gestor.buscarProducto(40);   
        gestor.buscarProducto(99);    

        System.out.println("\n[ 5 ] Eliminando producto 30 (descontinuado):");
        gestor.eliminarProducto(30);

        System.out.println("\n  Productos tras la eliminación:");
        gestor.mostrarProductosOrdenados();

        System.out.println("\n[ 6 ] Estadísticas del árbol:");
        gestor.mostrarEstadisticas();

        System.out.println("\n[ 7 ] Recorrido por niveles (amplitud):");
        gestor.mostrarPorNiveles();

        System.out.println("\n╔══════════════════════════════════════════╗");
        System.out.println("║   FIN DEL SISTEMA DE PRODUCTOS            ║");
        System.out.println("╚══════════════════════════════════════════╝");
    }
}
