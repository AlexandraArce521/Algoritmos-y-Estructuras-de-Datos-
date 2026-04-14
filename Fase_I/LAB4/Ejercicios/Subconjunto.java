public class Subconjunto {
	static boolean backtrack(int[] arr, int i, int suma, int objetivo) {
        if (suma == objetivo) return true;

        if (i >= arr.length || suma > objetivo) return false;
 
        boolean esMultiploDe3 = arr[i] % 3 == 0;
 
        if (esMultiploDe3) {
            return backtrack(arr, i + 1, suma + arr[i], objetivo);
        }
 
        boolean esPar = arr[i] % 2 == 0;
 
        boolean parProhibido = esPar
            && (i + 1 < arr.length)
            && (arr[i + 1] % 2 == 0)
            && (arr[i + 1] % 3 != 0);
 
        if (backtrack(arr, i + 1, suma, objetivo)) return true;
 
        if (!parProhibido) {
            if (backtrack(arr, i + 1, suma + arr[i], objetivo)) return true;
        }
 
        return false;
    }
 
    public static boolean resolver(int[] arr, int objetivo) {
        return backtrack(arr, 0, 0, objetivo);
    }
 
    public static void main(String[] args) {
        int[] arr1 = {3, 4, 6, 7, 2};
        System.out.println(resolver(arr1, 20)); 
 
        int[] arr2 = {3, 4, 6, 7, 8};
        System.out.println(resolver(arr2, 18)); 

        int[] arr3 = {3, 9, 2, 5, 8, 4};
        System.out.println(resolver(arr3, 31)); 
    }
}
