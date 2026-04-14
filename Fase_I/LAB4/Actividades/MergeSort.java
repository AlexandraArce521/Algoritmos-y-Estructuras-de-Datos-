
public class MergeSort {
    public static void sort(int[] arr, int izq, int derecha) {
        if (izq < derecha) {
            int mid = izq + (derecha - izq) / 2;

            sort(arr, izq, mid);
            sort(arr, mid + 1, derecha);

            merge(arr, izq, mid, derecha);
        }
    }

    private static void merge(int[] arr, int izq, int mid, int derecha) {
        int n1 = mid - izq + 1;
        int n2 = derecha - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        System.arraycopy(arr, izq, L, 0, n1);
        System.arraycopy(arr, mid + 1, R, 0, n2);

        int i = 0, j = 0, k = izq;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i++];
            } else {
                arr[k] = R[j++];
            }
            k++;
        }

        while (i < n1) arr[k++] = L[i++];

        while (j < n2) arr[k++] = R[j++];
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 1, 4]};
        sort(arr, 0, arr.length - 1);
        
        for (int num : arr) System.out.print(num + " ");
    }
}
