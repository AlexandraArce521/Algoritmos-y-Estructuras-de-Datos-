public class QueueArray<E> implements Queue<E>{
	private E[] array;
	private int inicio;
	private int final_;
	private int tamanio;
	
	public QueueArray (int n) {
		this.array = (E[]) new Object[n];
		this.inicio = 0;
		this.final_ = -1; 
		this.tamanio = 0; 
	}
	
	public void enqueue (E x) {
		if(isFull()) {
			System.out.println("Cola llena");
			return;
		}
		
		final_ = (final_ + 1) % array.length;
	    array[final_] = x;
	    tamanio++;
	}
	
	public E dequeue () throws ExceptionIsEmpty {
		if(isEmpty()) {
			throw new ExceptionIsEmpty("Cola vacia");
		}
		
		E d = array[inicio];
		array[inicio] = null;
		inicio = (inicio + 1) % array.length;
		tamanio --;
		return d;
	}
	
	public E front() throws ExceptionIsEmpty {
		if(isEmpty()) {
			throw new ExceptionIsEmpty("Cola vacia");
		}
		return array[inicio];
	}
	
	public boolean isEmpty() {
		return tamanio == 0;
	}
	
	public boolean isFull() {
		return tamanio == array.length;
	}
	
	@Override
	public String toString() {
	    if (isEmpty()) {
	    	return "[]";
	    }

	    String resultado = "[";

	    for (int i = 0; i < tamanio; i++) {
	        int index = (inicio + i) % array.length;
	        resultado += array[index];

	        if (i < tamanio - 1) {
	            resultado += ", ";
	        }
	    }

	    resultado += "]";
	    return resultado;
	}
}
