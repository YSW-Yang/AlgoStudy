import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		long[] map = new long[N];
		for (int i = 0; i < N; i++) {
			map[i] = Long.parseLong(br.readLine());
		}
		Arrays.sort(map);

		long left = 1;
		long right = map[N - 1] - map[0];
		long maxLength = 0;
		while (left <= right) {
			long mid = (left + right) / 2;
			int prevIndex = 0;
			int count = 1;
			for (int i = 1; i < N; i++) {
				if (mid <= map[i] - map[prevIndex]) {
					prevIndex = i;
					count++;
				}
				if (count == C) {
					break;
				}
			}

			if (count == C) {
				maxLength = Math.max(maxLength, mid);
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		System.out.println(maxLength);
	}
}