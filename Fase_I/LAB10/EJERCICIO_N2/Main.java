package Ejer_02;

public class Main {
    public static void main(String[] args) {
        RedCiudades red = new RedCiudades();

        // Agregar ciudades
        red.agregarCiudad("Arequipa");
        red.agregarCiudad("Cusco");
        red.agregarCiudad("Puno");
        red.agregarCiudad("Tacna");
        red.agregarCiudad("Moquegua");

        // Agregar carreteras con distancia
        red.agregarCarretera("Arequipa", "Cusco", 510);
        red.agregarCarretera("Arequipa", "Moquegua", 230);
        red.agregarCarretera("Moquegua", "Tacna", 160);
        red.agregarCarretera("Cusco", "Puno", 390);
        red.agregarCarretera("Puno", "Tacna", 420);;

        // Mostrar información
        red.mostrarCiudades();
        red.mostrarCarreteras();

        // Calcular camino más corto
        red.caminoMasCorto("Arequipa", "Tacna");
    }
}
