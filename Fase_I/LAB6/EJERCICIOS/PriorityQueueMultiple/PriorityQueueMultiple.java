public class PriorityQueueMultiple<E> {
	private DequeLink<E>[] arregloDeColas;
    private int niveles;

    public PriorityQueueMultiple(int niveles) {
        this.niveles = niveles;
        arregloDeColas = (DequeLink<E>[]) new DequeLink[niveles];

        for (int i = 0; i < niveles; i++) {
            arregloDeColas[i] = new DequeLink<>();
        }
    }
    
    public void enqueue(E x, int prioridad) {
        if (prioridad < 0 || prioridad >= niveles) {
            System.out.println("Prioridad invalida");
            return;
        }

        arregloDeColas[prioridad].addLast(x);
    }
    
    public E dequeue() throws ExceptionIsEmpty {
        for (int i = niveles - 1; i >= 0; i--) {
            if (!arregloDeColas[i].isEmpty()) {
                return arregloDeColas[i].removeFirst();
            }
        }

        throw new ExceptionIsEmpty("Cola de prioridad vacia");
    }
    
    public boolean isEmpty() {
        for (int i = 0; i < niveles; i++) {
            if (!arregloDeColas[i].isEmpty()) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public String toString() {
        String resultado = "";

        for (int i = niveles - 1; i >= 0; i--) {
            resultado += "Prioridad " + i + ": " + arregloDeColas[i] + "\n";
        }

        return resultado;
    }
}
