public class Node<T> {
	T dato;
	Node<T> next;
	
	public Node(T dato) {
		this.dato = dato;
		this.next = null;
	}
}
