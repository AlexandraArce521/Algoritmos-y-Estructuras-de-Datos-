//EJERCICIO0007
public class SortListLinked<T extends Comparable<T>> extends ListLinked<T> {
	public void insertOrder(T x) {
		Node<T> nuevo = new Node<>(x);
		if (this.first == null || x.compareTo(this.first.dato) < 0) {
            nuevo.next = this.first;
            this.first = nuevo;
            return;
        }
		
		Node<T> actual = this.first;
		while (actual.next != null && x.compareTo(actual.next.dato) > 0) {
            actual = actual.next;
        }
		
		nuevo.next = actual.next;
        actual.next = nuevo;
	}
}


