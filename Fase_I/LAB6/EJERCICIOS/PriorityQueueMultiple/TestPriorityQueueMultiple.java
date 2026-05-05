public class TestPriorityQueueMultiple {
	public static void main(String[] args) {
        PriorityQueueMultiple<String> pq = new PriorityQueueMultiple<>(3);

        pq.enqueue("A", 0);
        pq.enqueue("B", 2);
        pq.enqueue("C", 1);
        pq.enqueue("D", 2);

        System.out.println("Estado de la cola:");
        System.out.println(pq);

        try {
            System.out.println("Orden de salida:");

            while (!pq.isEmpty()) {
                System.out.println(pq.dequeue());
            }

        } catch (ExceptionIsEmpty e) {
            System.out.println(e.getMessage());
        }
    }
}
