
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el tamaño k de la subregión (k x k): ");
        int k = Integer.parseInt(sc.nextLine().trim());

        Terreno mapa = new Terreno("terrenos.txt");
        Analizador analizador = new Analizador(mapa, k);
        analizador.analizar();
        analizador.mostrarResultados();

        sc.close();
    }
}




