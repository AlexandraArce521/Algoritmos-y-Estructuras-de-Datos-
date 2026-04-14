public class ViajeBarato {
	public static int costoMinimo(int[][] T) {
        int n = T.length;
        int[][] C = new int[n][n];

        for (int i = 0; i < n; i++) {
            C[i][i] = 0;
        }

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                C[i][j] = T[i][j];

                for (int k = i; k < j; k++) {
                    C[i][j] = Math.min(C[i][j], T[i][k] + C[k][j]);
                }
            }
        }

        return C[0][n - 1];
    }

    public static void main(String[] args) {
        int[][] T = {
            {0, 10, 75, 94},
            {0, 0, 35, 50},
            {0, 0, 0, 80},
            {0, 0, 0, 0}
        };

        System.out.println(costoMinimo(T)); 
    }
}
