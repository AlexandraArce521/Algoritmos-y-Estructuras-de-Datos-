public class ListLinked<T> {
	Node<T> first;
	
	ListLinked(){
		this.first = null;
	}
	//===================================================
	public void insertFirst(T x) {
		Node<T> nuevo = new Node<>(x);
		nuevo.next = first;
		first = nuevo;
	}
	//===================================================
	public void insertLast(T x) {
		if(first == null) {
			first = new Node<>(x);
			return;
		}
		
		Node<T> actual = first;
		while(actual.next != null) {
			actual = actual.next;
		}
		
		Node<T> nuevo = new Node<>(x);
		actual.next = nuevo;
	}
	//====================================================
	public boolean removeNode(T x) {
		if(isEmptyList()) {
			return false;
		}
		
		if(first.dato.equals(x)) {
			first = first.next;
			return true;
		}
		
		Node<T> actual = first;
		while(actual.next != null && actual.next.dato.equals(x) == false) {
			actual = actual.next;
		}
		
		if (actual.next == null) {
			return false;
		}
		
		actual.next = actual.next.next;
		return true;
	}
	//=====================================================
	public boolean search(T x) {
		if(isEmptyList()) {
			return false;
		}
		
		Node<T> actual = first;
		while(actual != null) {
			if(actual.dato.equals(x)) {
				return true;
			}
			actual = actual.next;
		}
		return false;
	}
	//=====================================================
	public int length() {
		int contador = 0;
		Node<T> actual = first;
		while(actual != null) {
			actual = actual.next;
			contador ++;
		}
		return contador;
	}
	//====================================================
	public boolean isEmptyList() {
		if(this.first == null)
			return true;
		return false;
	}
	//====================================================
	public void print() {
		System.out.println("\nElementos de la lista ================");
		Node<T> actual = first;
		while(actual != null) {
			System.out.println(actual.dato);
			actual = actual.next;
		}
	}
	//====================================================
	public void reverse() {
		Node<T> anterior = null;
        Node<T> actual = first;
        while (actual != null) {
            Node<T> siguiente = actual.next;
            actual.next = anterior;
            anterior = actual;
            actual = siguiente;
        }
        first = anterior;
    }
}
