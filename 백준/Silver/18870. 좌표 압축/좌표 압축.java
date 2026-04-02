import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] origin = new int[N];
		int[] sorted = new int[N];
		HashMap<Integer, Integer> rankMap = new HashMap<>(N);

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			origin[i] = sorted[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(sorted);
		int count = 0;
		for (int value : sorted) {
			if (!rankMap.containsKey(value)) {
				rankMap.put(value, count);
				count++;
			}
		}

		for (int key : origin) {
			sb.append(rankMap.get(key)).append(' ');
		}

		System.out.println(sb);
	}
}
