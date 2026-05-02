class ExceptionIsEmpty extends Exception {
    public ExceptionIsEmpty(String mensaje) {
        super("(!)Cola vacia");
    }
}
public interface Queue<E> { 
    void enqueue(E x); 
    E dequeue() throws ExceptionIsEmpty; 
    E front() throws ExceptionIsEmpty; 
    boolean isEmpty(); 
} 
