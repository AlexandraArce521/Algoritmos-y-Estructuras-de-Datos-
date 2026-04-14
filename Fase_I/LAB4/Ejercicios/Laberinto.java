import java.util.*;

public class Laberinto {
	static int N, M;
    static int[][] sol;
    static List<String> camino = new ArrayList<>();

    static boolean esValido(int[][] lab, int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M && lab[x][y] == 0 && sol[x][y] == 0;
    }

    static boolean backtrack(int[][] lab, int x, int y) {

        if (!esValido(lab, x, y)) return false;

        sol[x][y] = 1;
        camino.add("(" + x + "," + y + ")");

        if (x == N - 1 && y == M - 1) {
            return true;
        }


        if (backtrack(lab, x, y + 1) ||  backtrack(lab, x + 1, y) || backtrack(lab, x, y - 1) || backtrack(lab, x - 1, y)) { 
            return true;
        }

        sol[x][y] = 0;
        camino.remove(camino.size() - 1);

        return false;
    }

    public static void resolver(int[][] lab) {
        N = lab.length;
        M = lab[0].length;
        sol = new int[N][M];
        camino.clear();

        boolean existe = backtrack(lab, 0, 0);

        if (existe) {
            System.out.println("Salida: true");
            System.out.print("Explicacion: Hay un camino desde ");

            for (int i = 0; i < camino.size(); i++) {
                System.out.print(camino.get(i));
                if (i < camino.size() - 1) {
                    System.out.print(" -> ");
                }
            }
            System.out.println(".");
        } else {
            System.out.println("Salida: false");
            System.out.println("Explicacion: No hay camino que conecte la esquina superior izquierda con la inferior derecha");
        }
    }

    public static void main(String[] args) {

        int[][] lab1 = {
            {0, 0, 1},
            {1, 0, 1},
            {0, 0, 0}
        };

        int[][] lab2 = {
            {0, 0},
            {1, 0}
        };

        resolver(lab1);
        System.out.println();
        resolver(lab2);
    }
}
