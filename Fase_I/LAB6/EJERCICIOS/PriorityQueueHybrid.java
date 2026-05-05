public class PriorityQueueHybrid<T, S extends Comparable<S>> {
    private Node<T, S>[] nivelesCola;
    private int niveles;

    public PriorityQueueHybrid(int niveles) {
        this.niveles = niveles;
        nivelesCola = (Node<T, S>[]) new Node[niveles];
    }

    public void enqueue(T dato, int prioridad, S secundario) {

        if (prioridad < 0 || prioridad >= niveles) {
            throw new IllegalArgumentException("Prioridad fuera de rango");
        }

        Node<T, S> nuevo = new Node<>(dato, secundario);

        if (nivelesCola[prioridad] == null ||
            secundario.compareTo(nivelesCola[prioridad].secundario) < 0) {

            nuevo.next = nivelesCola[prioridad];
            nivelesCola[prioridad] = nuevo;
            return;
        }

        Node<T, S> actual = nivelesCola[prioridad];

        while (actual.next != null &&
               actual.next.secundario.compareTo(secundario) <= 0) {

            actual = actual.next;
        }

        nuevo.next = actual.next;
        actual.next = nuevo;
    }

    public T dequeue() throws ExceptionIsEmpty {

        for (int i = niveles - 1; i >= 0; i--) {

            if (nivelesCola[i] != null) {

                T dato = nivelesCola[i].dato;
                nivelesCola[i] = nivelesCola[i].next;

                return dato;
            }
        }

        throw new ExceptionIsEmpty("Cola vacía");
    }

    public boolean isEmpty() {

        for (int i = 0; i < niveles; i++) {
            if (nivelesCola[i] != null) return false;
        }

        return true;
    }

    public void print() {

        for (int i = niveles - 1; i >= 0; i--) {

            System.out.print("Nivel " + i + ": ");

            Node<T, S> actual = nivelesCola[i];

            if (actual == null) {
                System.out.println("vacío");
                continue;
            }

            while (actual != null) {
                System.out.print("(" + actual.dato + "," + actual.secundario + ")");

                if (actual.next != null) System.out.print(" -> ");

                actual = actual.next;
            }

            System.out.println();
        }
    }
}
