
import java.io.File;
import java.util.Scanner;

public class Terreno {
    private Zona[][] zonas;
    private int filas;
    private int columnas;

    public Terreno(String txt) {
        cargarDesdeArchivo(txt);
    }

    private void cargarDesdeArchivo(String txt) {
        try {
            Scanner sc = new Scanner(new File(txt));

            this.filas = sc.nextInt();
            this.columnas = sc.nextInt();

            zonas = new Zona[filas][columnas];

            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    String mineral = sc.next();
                    double cantidad = sc.nextDouble();
                    double pureza = sc.nextDouble();
                    zonas[i][j] = new Zona(mineral, cantidad, pureza);
                }
            }
            sc.close();
        } catch (Exception e) {
            System.out.println("No se pudo abrir el archivo: " + e.getMessage());
        }
    }

    public Zona getZona(int fila, int col) {
        return zonas[fila][col];
    }

    public int getFilas() {
        return this.filas;
    }

    public int getColumnas() {
        return this.columnas;
    }
}
