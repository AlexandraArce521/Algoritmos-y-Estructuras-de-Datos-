public class PriorityQueueLinkSort<E, N extends Comparable<N>> implements PriorityQueue<E, N> {
	class EntryNode{
		E data;
		N priority;
		
		EntryNode (E data, N priority){
			this.data = data;
			this.priority = priority;
		}
	}
	
	private Node<EntryNode> first; 
    private Node<EntryNode> last; 
    
    public PriorityQueueLinkSort() { 
        this.first = null; 
        this.last = null; 
    } 
	
    public void enqueue(E x, N pr) {
        EntryNode nuevoEntry = new EntryNode(x, pr);
        Node<EntryNode> nuevo = new Node<>(nuevoEntry);

        if (isEmpty()) {
            first = last = nuevo;
            return;
        }

        if (pr.compareTo(first.getData().priority) > 0) {
            nuevo.setNext(first);
            first = nuevo;
            return;
        }

        Node<EntryNode> actual = first;

        while (actual.getNext() != null &&
               pr.compareTo(actual.getNext().getData().priority) <= 0) {
            actual = actual.getNext();
        }

        nuevo.setNext(actual.getNext());
        actual.setNext(nuevo);

        if (nuevo.getNext() == null) {
            last = nuevo;
        }
    }
    
    public E dequeue() throws ExceptionIsEmpty {
        if (isEmpty())
            throw new ExceptionIsEmpty("Cola vacia");

        E aux = this.first.getData().data;
        this.first = this.first.getNext();

        if (this.first == null)
            this.last = null;

        return aux;
    }
    
    public E front() throws ExceptionIsEmpty {
        if (isEmpty())
            throw new ExceptionIsEmpty("Cola vacia");

        return first.getData().data;
    }
    
    public E back() throws ExceptionIsEmpty {
        if (isEmpty())
            throw new ExceptionIsEmpty("Cola vacia");

        return last.getData().data;
    }
    
    public boolean isEmpty() {
        return first == null;
    }
    
    @Override
    public String toString() {
        String resultado = "[";
        Node<EntryNode> actual = first;

        while (actual != null) {
            resultado += "(" + actual.getData().data + ", " 
                       + actual.getData().priority + ")";

            if (actual.getNext() != null) {
                resultado += ", ";
            }

            actual = actual.getNext();
        }

        resultado += "]";
        return resultado;
    }
}
