import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] weights = new int[N];
		int maxWeight = 0;
		for (int i = 0; i < N; i++) {
			weights[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(weights);

		for (int i = 0; i < N; i++) {
			maxWeight = Math.max(maxWeight, weights[i] * (N - i));
		}

		System.out.println(maxWeight);
	}
}