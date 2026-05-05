public class Node<T, S extends Comparable<S>> {
    public T dato;             
    public S secundario;       
    public Node<T, S> next;

    public Node(T dato, S secundario) {
        this.dato = dato;
        this.secundario = secundario;
        this.next = null;
    }
}
