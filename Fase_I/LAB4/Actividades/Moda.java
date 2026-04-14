import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        int[] numeros = {
            1, 2, 3, 1, 1, 2, 3, 4, 2, 4, 412, 3, 12, 321,
            12, 3, 213, 13, 21, 31, 21, 1, 345, 12, 312, 3, 5424, 314
        };

        System.out.printf("El arreglo original es: %s \n", Arrays.toString(numeros),"\n");

        // Ordenar el arreglo
        Arrays.sort(numeros);

        int moda = numeros[0];
        int mayorFrecuencia = 1;
        int frecuenciaActual = 1;

        for (int i = 1; i < numeros.length; i++) {
            if (numeros[i] == numeros[i - 1]) {
                frecuenciaActual++;
            } else {
                if (frecuenciaActual > mayorFrecuencia) {
                    mayorFrecuencia = frecuenciaActual;
                    moda = numeros[i - 1];
                }
                frecuenciaActual = 1;
            }
        }

        // Verificar la última secuencia
        if (frecuenciaActual > mayorFrecuencia) {
            mayorFrecuencia = frecuenciaActual;
            moda = numeros[numeros.length - 1];
        }

        System.out.printf("\nLa moda es %d porque se repite %d veces",
                moda, mayorFrecuencia);
    }
}
