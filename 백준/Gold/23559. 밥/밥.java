import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int[] diff = new int[N];
		int remainingMoney = (X - 1000 * N);
		int totalTaste = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			diff[i] = a - b;
			totalTaste += b;
		}

		Arrays.sort(diff);
		int maxUpgradeCount = remainingMoney / 4000;
		for (int i = N - 1; i >= 0 && maxUpgradeCount > 0; i--) {
			if (diff[i] > 0) {
				totalTaste += diff[i];
				maxUpgradeCount--;
			} else {
				break;
			}

		}

		System.out.println(totalTaste);
	}
}