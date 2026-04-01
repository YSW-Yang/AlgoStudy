import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static int[] res;
	public static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[9];
		res = new int[7];

		for (int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);

		combine(0, 0);
	}

	public static void combine(int start, int depth) {
		if (depth == 7) {
			int sum = 0;
			for (int h : res) {
				sum += h;
			}
			if (sum == 100) {
				for (int h : res) {
					System.out.println(h);
				}
				System.exit(0);
			}
			return;
		}

		for (int i = start; i < arr.length; i++) {
			res[depth] = arr[i];
			combine(i + 1, depth + 1);
		}
	}
}
