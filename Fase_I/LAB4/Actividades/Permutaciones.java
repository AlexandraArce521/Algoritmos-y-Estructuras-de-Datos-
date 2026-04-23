public class Permutaciones {
	public static void permutar(int[] arr, List<Integer> actual, boolean[] usado) {
		if (actual.size() == arr.length) {
			System.out.println(actual);
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if (!usado[i]) {
				usado[i] = true;
				actual.add(arr[i]);
				permutar(arr, actual, usado);
				// Backtracking
				actual.remove(actual.size() - 1);
				usado[i] = false;
			}
		}
	}
}
