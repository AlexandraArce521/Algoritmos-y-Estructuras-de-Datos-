package EjercicioLibro;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        try {
            biblioteca.cargarArchivo("biblioteca.txt");

            System.out.println("ARBOL B");
            biblioteca.mostrarLibrosOrdenados();

            System.out.println("\nCantidad de libros: " + biblioteca.cantidadLibros());

            System.out.println("Altura del árbol: " + biblioteca.alturaArbol());

            System.out.println("\nBuscando 9780134494166");
            biblioteca.buscarLibroPorISBN("9780134494166");

            System.out.println("\nEliminando . . . 9780134494166");
            biblioteca.eliminarLibro("9780134494166");

            System.out.println("\nARBOL DESPUES DE ELIMINAR");

            System.out.println("\nLIBROS ORDENADOS DESPUES DE ELIMINAR");
            biblioteca.mostrarLibrosOrdenados();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
