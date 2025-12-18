import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] inputs = br.readLine().split(" ");
		int[] location = new int[n];
		int min = Integer.MAX_VALUE;
		int count = 0;

		for (int i = 0; i < n; i++) {
			location[i] = Integer.parseInt(inputs[i]);
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j) {
					continue;
				}
				int dif = Math.abs(location[i] - location[j]);

				if (min > dif) {
					min = dif;
					count = 1;
				} else if (min == dif) {
					count++;
				}
			}
		}

		System.out.println(min + " " + count / 2);
	}
}