package EJERCICIO_05;

public class Producto implements Comparable<Producto> {
    private int codigo;
    private String nombre;
    private double precio;

    public Producto(int codigo, String nombre, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getCodigo() { 
    	return codigo; 
    }
    
    public String getNombre() { 
    	return nombre; 
    }
    
    public double getPrecio() { 
    	return precio; 
    }

    @Override
    public int compareTo(Producto other) {
        return Integer.compare(this.codigo, other.codigo);
    }

    @Override
    public String toString() {
        return "Codigo: " + codigo + " | Nombre: " + nombre + " | Precio: " + precio;
    }
}
