import java.util.*;

class QueueArray<E> implements Queue<E> {
    private E[] array;
    private int front;
    private int rear;
    private int size;
    
    public QueueArray(int n) {
        array = (E[]) new Object[n];
        front = 0;
        rear = -1;
        size = 0;
    }
    
    @Override
    public void enqueue(E x) {
        if(isFull()) {
            throw new RuntimeException("La cola está llena");
        }
        rear = (rear + 1) % array.length;
        array[rear] = x;
        size++;
    }
    
    @Override
    public E dequeue() throws ExceptionIsEmpty {
        if(isEmpty()) {
            throw new ExceptionIsEmpty("Cola vacia");
        }
        
        E dato = array[front];
        front = (front+1)%array.length;
        size--;
        return dato;
    }

    @Override
    public E front() throws ExceptionIsEmpty {
        if(isEmpty()) {
            throw new ExceptionIsEmpty("Cola vacia");
        }
        
        E dato = array[front];
        return dato;
        
    }
    
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    
    @Override
    public boolean isFull() {
        return array.length == size;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(); // clase de Java que sirve para construir textos
        sb.append("[");
    
        for (int i = 0; i < size; i++) {
            int index = (front + i) % array.length;
            sb.append(array[index]);
    
            if (i < size - 1) {
                sb.append(", ");
            }
        }
    
        sb.append("]");
        return sb.toString();
    }
    
}
