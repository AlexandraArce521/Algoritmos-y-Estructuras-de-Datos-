package Hash;

public class TestEjercicio2 {

    private static final int SIZE = 7;

    public static void main(String[] args) {

        int[] datos = {10, 17, 24, 31, 4};

        System.out.println("===== SONDEO LINEAL =====");
        lineal(datos);

        System.out.println("\n===== SONDEO CUADRATICO =====");
        cuadratico(datos);
    }

    private static void lineal(int[] datos) {

        int[] tabla = new int[SIZE];

        for (int i = 0; i < SIZE; i++) {
            tabla[i] = -1;
        }

        for (int valor : datos) {

            int hash = valor % SIZE;
            int exploradas = 1;

            while (tabla[(hash + exploradas - 1) % SIZE] != -1) {
                exploradas++;
            }

            tabla[(hash + exploradas - 1) % SIZE] = valor;

            System.out.println(
                "\nInsertando " + valor +
                " | posiciones exploradas = " +
                exploradas
            );

            imprimir(tabla);
        }
    }

    private static void cuadratico(int[] datos) {

        int[] tabla = new int[SIZE];

        for (int i = 0; i < SIZE; i++) {
            tabla[i] = -1;
        }

        for (int valor : datos) {

            int hash = valor % SIZE;
            int i = 0;
            int exploradas = 0;

            while (tabla[(hash + i * i) % SIZE] != -1) {
                i++;
                exploradas++;
            }

            tabla[(hash + i * i) % SIZE] = valor;

            System.out.println(
                "\nInsertando " + valor +
                " | posiciones exploradas = " +
                (exploradas + 1)
            );

            imprimir(tabla);
        }
    }

    private static void imprimir(int[] tabla) {

        for (int i = 0; i < tabla.length; i++) {
            System.out.print("[" + i + "] ");

            if (tabla[i] == -1)
                System.out.print("EMPTY ");
            else
                System.out.print(tabla[i] + " ");
        }

        System.out.println();
    }
}
