package Pilas;
import Exceptions.ExceptionIsEmpty;

public class StackLink<E> implements Stack<E> {
    private Node<E> top;

    public StackLink() {
        this.top = null;
    }
    // =============================
    public void push(E x) {
        Node<E> nuevo = new Node<>(x);
        nuevo.setNext(top);
        top = nuevo;
    }
    // =============================
    public E pop() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("Pila vacia");
        }

        E dato = top.getData();
        top = top.getNext();
        return dato;
    }
    // =============================
    public E top() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("Pila vacia");
        }

        return top.getData();
    }
    // =============================
    public boolean isEmpty() {
        return top == null;
    }
    // =============================
    public String toString() {
        String resultado = "[";
        Node<E> actual = top;

        while (actual != null) {
            resultado += actual.getData();

            if (actual.getNext() != null) {
                resultado += ", ";
            }

            actual = actual.getNext();
        }

        resultado += "]";
        return resultado;
    }
}
