import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] budget = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());

		long right = 1;
		long totalSum = 0;
		for (int i = 0; i < N; i++) {
			budget[i] = Long.parseLong(st.nextToken());
			right = Math.max(right, budget[i]);
			totalSum += budget[i];
		}
		long M = Long.parseLong(br.readLine());

		if (totalSum <= M) {
			System.out.println(right);
			return;
		}

		long left = 1;
		long result = 0;
		while (left <= right) {
			long mid = (left + right) / 2;
			long currentSum = 0;
			for (int i = 0; i < N; i++) {
				currentSum += Math.min(budget[i], mid);
			}

			if (currentSum <= M) {
				left = mid + 1;
				result = mid;
			} else {
				right = mid - 1;
			}
		}

		System.out.println(result);
	}
}