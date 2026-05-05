public class PruebaTest {
	public static void main(String[] args) {

        PriorityQueue<String, Integer> pq = new PriorityQueueLinkSort<>();

        pq.enqueue("Juan", 2);
        pq.enqueue("Ana", 5);
        pq.enqueue("Luis", 3);
        pq.enqueue("Maria", 1);
        pq.enqueue("Carlos", 4);

        System.out.println("Cola de prioridad:");
        System.out.println(pq);

        try {
            System.out.println("\nElemento con mayor prioridad (front): " + pq.front());

            System.out.println("Elemento con menor prioridad (back): " + pq.back());

            System.out.println("\nEliminando elemento: " + pq.dequeue());
            System.out.println("Cola despues de dequeue:");
            System.out.println(pq);

        } catch (ExceptionIsEmpty e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
