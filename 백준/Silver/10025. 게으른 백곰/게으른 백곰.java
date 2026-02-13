import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] iceWeights = new int[1000001];

		int minLocation = 1000000;
		int maxLocation = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int iceWeight = Integer.parseInt(st.nextToken());
			int location = Integer.parseInt(st.nextToken());
			iceWeights[location] = iceWeight;
			minLocation = Math.min(minLocation, location);
			maxLocation = Math.max(maxLocation, location);
		}

		long sumIceWeight = 0;
		long maxSumIceWeight = sumIceWeight;
		int windowSize = 2 * k + 1;
		for (int i = 0; i <= 1000000; i++) {
			sumIceWeight += iceWeights[i];

			if (i >= windowSize) {
				sumIceWeight -= iceWeights[i - windowSize];
			}

			maxSumIceWeight = Math.max(maxSumIceWeight, sumIceWeight);
		}

		System.out.println(maxSumIceWeight);
	}
}