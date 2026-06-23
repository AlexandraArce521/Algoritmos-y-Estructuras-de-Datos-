package Hash;

public class TestEjercicio4 {

    public static void main(String[] args) {

        HashC<Integer> hash = new HashC<>(7);

        hash.insert(new Register<>(5, 5));
        hash.insert(new Register<>(12, 12));
        hash.insert(new Register<>(19, 19));
        hash.insert(new Register<>(26, 26));

        System.out.println("ANTES");
        hash.printTable();

        hash.delete(12);

        System.out.println("\nDESPUES DE ELIMINAR 12");
        hash.printTable();

        System.out.println(
            "\nBUSCAR 19 -> " +
            hash.search(19)
        );

        hash.insert(new Register<>(33, 33));

        System.out.println("\nREINSERTAR 33");
        hash.printTable();
    }
}
