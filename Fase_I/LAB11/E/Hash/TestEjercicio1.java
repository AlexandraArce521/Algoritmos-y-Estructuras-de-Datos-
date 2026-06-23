package Hash;

public class TestEjercicio1 {

    public static void main(String[] args) {

        int[] tabla = new int[11];

        for (int i = 0; i < tabla.length; i++) {
            tabla[i] = -1;
        }

        int[] valores = {3, 14, 25, 36, 47, 58};

        System.out.println("CALCULO MANUAL");

        for (int valor : valores) {

            int hash = valor % 11;

            System.out.println(
                valor + " % 11 = " + hash
            );

            if (tabla[hash] == -1) {
                tabla[hash] = valor;
            } else {
                System.out.println(
                    "COLISION con " + valor
                );
            }
        }

        System.out.println("\nTABLA FINAL");

        for (int i = 0; i < tabla.length; i++) {

            if (tabla[i] == -1) {
                System.out.println("[" + i + "] VACIO");
            } else {
                System.out.println("[" + i + "] " + tabla[i]);
            }
        }
    }
}