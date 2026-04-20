import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N + 1];
		int MOD = 10007;
		dp[1] = 1;

		for (int i = 2; i <= N; i++) {
			if (i % 2 == 0) {
				dp[i] = ((dp[i - 1] * 2) + 1) % MOD;
			} else {
				dp[i] = ((dp[i - 1] * 2) - 1) % MOD;
			}
		}

		System.out.println(dp[N]);
	}
}