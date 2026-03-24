
public class Main {
	public static<T> void swap(T[] arreglo, int i, int j) {
		if(i >= 0 && i < arreglo.length && j >= 0 && j < arreglo.length) {
			T posicionA = arreglo[i];
			
			arreglo[i] = arreglo[j];
			arreglo[j] = posicionA;
			
		} else {
			System.out.println("Indices invalidos. Verificaar");
		}
	}
	
	public static<T> void mostrar(T[] arreglo) {
		System.out.print("Arreglo: [");
		
		for(int i = 0; i < arreglo.length; i++) {
			if(i < arreglo.length - 1) {
				System.out.print(arreglo[i] + ", ");
			}else {
				System.out.println(arreglo[i] + "]");
			}
		}
	}
	
	public static void main(String[] args) {
		String[] arr = {"A","B","C","D"};
		mostrar(arr);
		swap(arr, 1, 3);
		mostrar(arr);
		
		Integer[] arr2 = {10, 20, 30, 40};
		mostrar(arr2);
		swap(arr2, 0, 2);
		mostrar(arr2);
	}

}
