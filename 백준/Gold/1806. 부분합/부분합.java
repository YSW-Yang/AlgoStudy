import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		Integer[] arr = new Integer[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int left = 0;
		int right = 0;
		long sum = 0;
		int minLength = Integer.MAX_VALUE;
		boolean found = false;
		while (true) {
			if (sum < S) {
				if (right == N) {
					break;
				}
				sum += arr[right++];
			} else {
				found = true;
				minLength = Math.min(right - left, minLength);
				sum -= arr[left++];
			}
		}

		System.out.println(found ? minLength : 0);
	}
}