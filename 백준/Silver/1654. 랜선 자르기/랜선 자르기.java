import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[K];

		long right = 0;
		for (int i = 0; i < K; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			right = Math.max(right, arr[i]);
		}

		long left = 1;
		long maxLength = 0;
		while (left <= right) {
			long mid = (left + right) / 2;
			long count = 0;
			for (int i = 0; i < K; i++) {
				count += arr[i] / mid;
			}

			if (count >= N) {
				maxLength = Math.max(maxLength, mid);
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		System.out.println(maxLength);
	}
}