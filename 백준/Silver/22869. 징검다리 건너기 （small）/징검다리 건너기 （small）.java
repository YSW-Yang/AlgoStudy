import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] stones = new int[n + 1];
		int[] cost = new int[n + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			stones[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 2; i <= n; i++) {
			cost[i] = (i - 1) * (1 + Math.abs(stones[1] - stones[i]));
		}

		for (int i = 2; i < n; i++) {
			for (int j = i + 1; j <= n; j++) {
				if (k < cost[i]) {
					break;
				}
				cost[j] = Math.min(cost[j], (j - i) * (1 + Math.abs(stones[i] - stones[j])));
			}

			if (cost[n] <= k) {
				System.out.println("YES");
				return;
			}
		}

		System.out.println("NO");
	}
}