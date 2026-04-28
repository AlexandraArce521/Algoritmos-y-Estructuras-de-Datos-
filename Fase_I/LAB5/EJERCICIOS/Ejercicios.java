public class Ejercicios {
	//EJERCICIO0001
	public static <T> boolean  buscarElemento (ListLinked<T> lista, T valor) {
		Node<T> actual = lista.first;
		
		while(actual != null) {
			if (valor.equals(actual.dato)) {
				return true;
			}
			actual = actual.next;
		}
		return false;
	}
	
	//EJERCICIO0002
	public static <T> ListLinked<T> invertirLista(ListLinked<T> lista){
		ListLinked<T> nueva = new ListLinked<>();
		
		Node<T> actual = lista.first;
		 while (actual != null) {
			 Node<T> nuevo = new Node<>(actual.dato);
			 nuevo.next = nueva.first;
			 nueva.first = nuevo;

			 actual = actual.next;
		}
		return nueva;
	}
	
	//EJERCICIO0003
	public static <T> Node<T> insertarAlFinal(Node<T> head, T valor){
		Node<T> nuevo = new Node<>(valor);
		
		if (head == null) {
	        return nuevo;
	    }
		
		Node<T> actual = head;
		while(actual.next != null) {
			actual = actual.next;
		}
		
		actual.next = nuevo;
		return head;
	}
	
	//EJERCICIO0004
	public static <T> int contarNodos(Node<T> head) {
		Node<T> actual = head;
		int contador = 0;
		while(actual != null) {
			actual = actual.next;
			contador += 1;
		}
		return contador;
	}
	
	//EJERCICIO0005
	public static <T> boolean sonIguales(ListLinked<T> lista1, ListLinked<T> lista2) {
		Node<T> actual1 = lista1.first;
		Node<T> actual2 = lista2.first;
		
		while (actual1 != null && actual2 != null) {
			if (!actual1.dato.equals(actual2.dato)) {
				return false;
			}
			actual1 = actual1.next;
			actual2 = actual2.next;
		}
		return actual1 == null && actual2 == null;
	}
	
	//EJERCICIO0006
	public static <T> ListLinked<T> concatenarListas(ListLinked<T> lista1, ListLinked<T> lista2){
		ListLinked<T> nuevaLista = new ListLinked<>();
		Node<T> fin = null;
		
		Node<T> actual1 = lista1.first;
		Node<T> actual2 = lista2.first;
		
		while(actual1 != null) {
			Node<T> nuevo = new Node<>(actual1.dato);
			
			if (nuevaLista.first == null) {
	            nuevaLista.first = nuevo;
	            fin = nuevo;
	        } else {
	            fin.next = nuevo;
	            fin = nuevo;
	        }
			actual1 = actual1.next;
		}
		
		while(actual2 != null) {
			Node<T> nuevo = new Node<>(actual2.dato);

	        if (nuevaLista.first == null) {
	            nuevaLista.first = nuevo;
	            fin = nuevo;
	        } else {
	            fin.next = nuevo;
	            fin = nuevo;
	        }

	        actual2 = actual2.next;
		}
		return nuevaLista;
	}
}
