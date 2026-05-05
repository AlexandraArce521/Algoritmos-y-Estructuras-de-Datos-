public class Test {
	public static void main(String[] args) {

        PriorityQueueHybrid<String, Integer> cola = new PriorityQueueHybrid<>(3);

        cola.enqueue("A", 2, 5);
        cola.enqueue("B", 2, 1);
        cola.enqueue("C", 1, 3);
        cola.enqueue("D", 2, 3);

        cola.print();

        System.out.print("Salida: ");

        try {
            while (!cola.isEmpty()) {
                System.out.print(cola.dequeue() + ", ");
            }
        } catch (ExceptionIsEmpty e) {
            System.out.println(e.getMessage());
        }
    }
}
