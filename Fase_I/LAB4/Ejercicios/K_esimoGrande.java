public class K_esimoGrande {
	static int quickSelect(int[] arreglo, int izquierda, int derecha, int k) {
	    if (izquierda == derecha) return arreglo[izquierda];

	    int pivote = arreglo[derecha];
	    int i = izquierda;

	    for (int j = izquierda; j < derecha; j++) {
	        if (arreglo[j] > pivote) { 
	            int temp = arreglo[i];
	            arreglo[i] = arreglo[j];
	            arreglo[j] = temp;
	            i++;
	        }
	    }

	    int temp = arreglo[i];
	    arreglo[i] = arreglo[derecha];
	    arreglo[derecha] = temp;

	    int conteo = i - izquierda + 1;

	    if (conteo == k) return arreglo[i];
	    else if (k < conteo) return quickSelect(arreglo, izquierda, i - 1, k);
	    else return quickSelect(arreglo, i + 1, derecha, k - conteo);
	}

	public static int resolver(int[] arreglo, int k) {
	    return quickSelect(arreglo, 0, arreglo.length - 1, k);
	}

	public static void main(String[] args) {
	    int[] arreglo = {4, 2, 7, 10, 4, 1, 6};
	    int k = 5;
	    System.out.println(resolver(arreglo, k));
	}
}
