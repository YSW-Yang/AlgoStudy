import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int testCase = 0; testCase < T; testCase++) {
			int V = Integer.parseInt(br.readLine());
			int[] nums = new int[1001];
			int maxCount = 0;
			int favoritNum = 0;
			for (int i = 0; i < V; i++) {
				nums[Integer.parseInt(br.readLine())]++;
			}

			for (int i = 1; i <= 1000; i++) {
				if (maxCount < nums[i]) {
					maxCount = nums[i];
					favoritNum = i;
				}
			}

			sb.append(favoritNum).append('\n');
		}

		System.out.println(sb);
	}
}