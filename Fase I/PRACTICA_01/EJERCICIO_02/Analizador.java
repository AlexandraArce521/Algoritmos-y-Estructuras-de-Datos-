package Ejercicio_02;

public class Analizador {
    private Terreno mapa;
    private int k;
    private int mejorFila;
    private int mejorCol;
    private double mejorValor;

    public Analizador(Terreno mapa, int k) {
        this.mapa = mapa;
        this.k = k;
        this.mejorFila = -1;
        this.mejorCol = -1;
        this.mejorValor = -1;
    }

    public void analizar() {
        int filas = mapa.getFilas();
        int cols = mapa.getColumnas();
        for (int i = 0; i <= filas - k; i++) {
            for (int j = 0; j <= cols - k; j++) {
                double valorTotal = calcularValorRegion(i, j);
                if (valorTotal > mejorValor) {
                    mejorValor = valorTotal;
                    mejorFila = i;
                    mejorCol = j;
                }
            }
        }
    }

    private double calcularValorRegion(int fila, int col) {
        double total = 0;
        for (int i = fila; i < fila + k; i++) {
            for (int j = col; j < col + k; j++) {
                total += mapa.getZona(i, j).getValor();
            }
        }
        return total;
    }

    private String mineralPredominante() {
        String[] minerales = new String[k * k];
        int[] conteos = new int[k * k];
        int numTipos = 0;

        for (int i = mejorFila; i < mejorFila + k; i++) {
            for (int j = mejorCol; j < mejorCol + k; j++) {
                String m = mapa.getZona(i, j).getMineral();
                boolean encontrado = false;
                for (int t = 0; t < numTipos; t++) {
                    if (minerales[t].equals(m)) {
                        conteos[t]++;
                        encontrado = true;
                        break;
                    }
                }
                if (!encontrado) {
                    minerales[numTipos] = m;
                    conteos[numTipos] = 1;
                    numTipos++;
                }
            }
        }

        String maxMineral = minerales[0];
        int maxConteo = conteos[0];
        for (int t = 1; t < numTipos; t++) {
            if (conteos[t] > maxConteo) {
                maxConteo = conteos[t];
                maxMineral = minerales[t];
            }
        }
        return maxMineral;
    }

    public void mostrarResultados() {
        if (mejorFila == -1) {
            System.out.println("No se pudo analizar. Verifique que k <= dimensiones del mapa.");
            return;
        }
        System.out.println("Región más valiosa encontrada:");
        System.out.println();
        System.out.println("Posición inicial: (" + mejorFila + "," + mejorCol + ")");
        System.out.println("Tamaño de la región: " + k + " x " + k);
        System.out.println();
        System.out.println("Zonas analizadas:");
        for (int i = mejorFila; i < mejorFila + k; i++) {
            for (int j = mejorCol; j < mejorCol + k; j++) {
                System.out.println("  " + mapa.getZona(i, j));
            }
        }
        System.out.println();
        System.out.println("Valor total estimado: " + mejorValor);
        System.out.println();
        System.out.println("Mineral predominante en la región: " + mineralPredominante());
    }
}