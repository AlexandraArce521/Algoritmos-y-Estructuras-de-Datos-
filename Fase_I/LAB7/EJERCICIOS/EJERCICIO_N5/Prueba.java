package EJERCICIO_05;

import Exceptions.*;

public class Prueba {
    public static void main(String[] args) {
        InventarioBST inventario = new InventarioBST();

        try {
            inventario.insert(new Producto(50, "Laptop",    2500.0));
            inventario.insert(new Producto(30, "Teclado",    150.0));
            inventario.insert(new Producto(70, "Monitor",    800.0));
            inventario.insert(new Producto(20, "Mouse",       50.0));
            inventario.insert(new Producto(40, "Auriculares", 200.0));
            inventario.insert(new Producto(60, "Webcam",      120.0));
            inventario.insert(new Producto(80, "Impresora",   350.0));
        } catch (ItemDuplicated e) {
            System.out.println(e.getMessage());
        }

        inventario.searchRange(30, 70);

        System.out.println();

        System.out.println("Numero de hojas: " + inventario.countLeaves());
        System.out.println();

        inventario.printDescending();
    }
}
