package Hash;

public class TestEjercicio5 {

    public static void main(String[] args) {

        HashC<Integer> tabla =
            new HashC<>(7);

        int[] datos = {
            2, 9, 16, 23, 4, 11
        };

        int elementos = 0;

        for (int x : datos) {

            tabla.insert(
                new Register<>(x, x)
            );

            elementos++;

            double alpha =
                (double) elementos / 7;

            System.out.println(
                "\nInsertado " + x +
                "  α = " + alpha
            );

            if (alpha > 0.75) {

                System.out.println(
                    "\nFACTOR SUPERA 0.75"
                );

                System.out.println(
                    "\nTABLA ANTES DEL REHASH"
                );

                tabla.printTable();

                HashC<Integer> nueva =
                    new HashC<>(17);

                for (int valor : datos) {

                    nueva.insert(
                        new Register<>(
                            valor,
                            valor
                        )
                    );
                }

                System.out.println(
                    "\nTABLA DESPUES DEL REHASH"
                );

                nueva.printTable();

                break;
            }
        }
    }
}
