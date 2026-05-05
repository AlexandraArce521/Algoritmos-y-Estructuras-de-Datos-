public class DequeLink<E> implements Deque<E> {
	private Node<E> first; 
	private Node<E> last; 
	
	public DequeLink() { 
		this.first = null; 
		this.last = null; 
	} 
    public void addFirst(E x) {
        Node<E> nuevo = new Node<>(x);

        if (isEmpty()) {
            first = last = nuevo;
        } else {
            nuevo.next = first;
            first = nuevo;
        }
    }
    
    public void addLast(E x) {
        Node<E> nuevo = new Node<>(x);

        if (isEmpty()) {
            first = last = nuevo;
        } else {
            last.next = nuevo;
            last = nuevo;
        }
    }
    
    public E removeFirst() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("Cola vacia");
        }

        E elemento = first.dato;
        first = first.next;

        if (first == null) { 
            last = null;
        }

        return elemento;
    }
    
    public E removeLast() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("Cola vacia");
        }

        E elemento = last.dato;

        if (first == last) {
            first = last = null;
            return elemento;
        }

        Node<E> actual = first;
        while (actual.next != last) {
            actual = actual.next;
        }

        actual.next = null;
        last = actual;

        return elemento;
    }
    
    public E getFirst() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("Cola vacia");
        }
        return first.dato;
    }
    
    public E getLast() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("Cola vacia");
        }
        return last.dato;
    }
    
    public boolean isEmpty() {
        return first == null;
    }
    
    @Override
    public String toString() {
        String resultado = "[";
        Node<E> actual = first;

        while (actual != null) {
            resultado += actual.dato;
            if (actual.next != null) {
                resultado += ", ";
            }
            actual = actual.next;
        }

        resultado += "]";
        return resultado;
    }
}
