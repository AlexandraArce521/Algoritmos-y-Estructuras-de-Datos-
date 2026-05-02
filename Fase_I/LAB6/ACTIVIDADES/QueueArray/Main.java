public class Main {
    public static void main(String[] args) {
        QueueArray<Integer> cola = new QueueArray<>(5);

        try {
            System.out.println("Insertando elementos...");
            cola.enqueue(10);
            cola.enqueue(20);
            cola.enqueue(30);
            cola.enqueue(40);
            cola.enqueue(50);

            System.out.println(cola);

            System.out.println("Elemento al frente: " + cola.front());

            System.out.println("\nEliminando elementos...");
            System.out.println("Sale: " + cola.dequeue());
            System.out.println("Sale: " + cola.dequeue());
            System.out.println(cola);


            System.out.println("\nInsertando más elementos (probando circularidad)...");
            cola.enqueue(60);
            cola.enqueue(70);
            System.out.println(cola);


            System.out.println("\nVaciando la cola...");
            while (!cola.isEmpty()) {
                System.out.println("Sale: " + cola.dequeue());
            }

            System.out.println("\nIntentando eliminar de cola vacía...");
            cola.dequeue(); 

        } catch (ExceptionIsEmpty e) {
            System.out.println("Error: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
