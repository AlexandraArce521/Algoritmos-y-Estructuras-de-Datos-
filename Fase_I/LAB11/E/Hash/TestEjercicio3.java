package Hash;

public class TestEjercicio3 {

    public static void main(String[] args) {

        HashO<String> hash = new HashO<>(7);

        hash.insert(new Register<>(10, "Juan"));
        hash.insert(new Register<>(17, "Ana"));
        hash.insert(new Register<>(24, "Luis"));
        hash.insert(new Register<>(31, "Rosa"));
        hash.insert(new Register<>(5, "Pedro"));
        hash.insert(new Register<>(12, "Carla"));

        System.out.println("TABLA ORIGINAL");
        hash.printTable();

        int posicion = 24 % 7;

        System.out.println(
            "\nLa clave 24 cae en indice " +
            posicion
        );

        Register<String> encontrado =
            hash.search(24);

        System.out.println(
            "Registro encontrado: " +
            encontrado
        );

        System.out.println(
            "\nNodo dentro de la lista:"
        );

        for (int i = 0;
             i < hash.getBucket(posicion).size();
             i++) {

            Register<String> r =
                hash.getBucket(posicion).get(i);

            if (r.getKey() == 24) {

                System.out.println(
                    "Nodo #" + (i + 1)
                );

                break;
            }
        }

        hash.delete(17);

        System.out.println(
            "\nDespues de eliminar 17"
        );

        hash.printTable();

        System.out.println(
            "\nNodos restantes en la cadena:"
        );

        System.out.println(
            hash.getBucket(3).size()
        );
    }
}