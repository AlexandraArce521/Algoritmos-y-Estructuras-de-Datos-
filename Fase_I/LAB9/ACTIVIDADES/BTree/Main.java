public class Main {

    public static void main(String[] args) {

        BTree<Integer> arbol = new BTree<>(4);

        int datos[] = {
            50, 20, 70, 10, 30,
            60, 80, 25, 27, 26,
            65, 75, 85, 5
        };

        System.out.println("INSERTANDO DATOS");
        System.out.println("================");

        for (int x : datos) {

            System.out.println("Insertando: " + x);
            arbol.insert(x);
        }

        System.out.println("\nInserción finalizada.");
    }
}
