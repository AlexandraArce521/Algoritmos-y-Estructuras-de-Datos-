import java.util.ArrayList;
import java.util.Random;

public class ColaReproduccion<T extends Cancion> {
	private NodeDoble<T> inicio;
	private NodeDoble<T> actual;
	private NodeDoble<T> fin;
	private String nombre;

	public ColaReproduccion(String nombre) {
		this.nombre = nombre;
        this.inicio = null;
        this.fin = null;
        this.actual = null;
    }
	//===================================
	public void agregarCancion(T cancion) {
		NodeDoble<T> nuevo = new NodeDoble<>(cancion);
		
		if(this.inicio == null) {
			this.inicio = nuevo;
			this.fin = nuevo;
			this.actual = nuevo;
		} else {
			this.fin.next = nuevo;
			nuevo.prev = this.fin;
			this.fin = nuevo;
		}
	}
	//===================================
	public T reproducirSiguiente() {
		if (this.actual == null) {
	        return null;
	    }
		
		if(this.actual.next != null) {
			this.actual = this.actual.next;
		}
		
		return this.actual.dato;
	}
	//===================================
	public T reproducirAnterior() {
		if (this.actual == null) {
	        return null;
	    }
		
		if (this.actual.prev != null) {
			this.actual = this.actual.prev;
		}
		
		return this.actual.dato;
	}
	//===================================
	public void mezclar() {
	    if (this.inicio == null || this.inicio.next == null) {
	        return; 
	    }

	    ArrayList<NodeDoble<T>> listaNodos = new ArrayList<>();

	    NodeDoble<T> nodoActual = this.inicio;

	    while (nodoActual != null) {
	        listaNodos.add(nodoActual);
	        nodoActual = nodoActual.next;
	    }
	    
	    Random random = new Random();
	    for (int i = listaNodos.size() - 1; i > 0; i--) {
	        int j = random.nextInt(i + 1);

	        NodeDoble<T> temp = listaNodos.get(i);
	        listaNodos.set(i, listaNodos.get(j));
	        listaNodos.set(j, temp);
	    }
	    
	    this.inicio = listaNodos.get(0);
	    this.inicio.prev = null;

	    for (int i = 0; i < listaNodos.size(); i++) {

	        NodeDoble<T> actual = listaNodos.get(i);

	        if (i > 0) {
	            actual.prev = listaNodos.get(i - 1);
	        }

	        if (i < listaNodos.size() - 1) {
	            actual.next = listaNodos.get(i + 1);
	        } else {
	            actual.next = null;
	            this.fin = actual;
	        }
	    }
	    
	    this.actual = this.inicio;
	}
	//===================================
	public void mostrarCola() {
		System.out.println("\n=== Cola de Reproducción " + this.nombre + " ===");
		if(this.actual == null) {
			System.out.println("No hay canciones");
			return;
		}
		
		NodeDoble<T> ubi = this.inicio;
		int contador = 1;
		while(ubi != null) {
			System.out.println(" " + contador + ". " + ubi.dato);
			ubi = ubi.next;
			contador += 1;
		}
	}
	//====================================
	public int duracionTotal() {
		if(this.actual == null) {
			return 0;
		}
		
		NodeDoble<T> ubi = this.inicio;
		int segundos = 0;
		while(ubi != null) {
			segundos += ubi.dato.getDuracionSeg();
			ubi = ubi.next;
		}
		return segundos;
	}
	
	//No dice en la practica
	public void mostrarReproduccionActual() {
		if (this.actual == null) {
	        System.out.println("No hay cancion");
	        return;
	    }
	    System.out.println("> Reproduciendo ahora: " + this.actual.dato);

	    if (this.actual.prev != null) {
	        System.out.println("< Anterior: " + this.actual.prev.dato);
	    } else {
	        System.out.println("< Anterior: Ninguna");
	    }
	}

}
