import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] lines = new int[N][2];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			lines[i][0] = Integer.parseInt(st.nextToken());
			lines[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(lines, (a, b) -> {
			if (a[0] == b[0]) {
				return Integer.compare(a[1], b[1]);
			}
			return Integer.compare(a[0], b[0]);
		});

		int start = lines[0][0];
		int end = lines[0][1];
		int sumLength = 0;
		for (int i = 1; i < N; i++) {
			if (lines[i][0] > end) {
				sumLength += end - start;
				start = lines[i][0];
				end = lines[i][1];
			} else {
				end = Math.max(end, lines[i][1]);
			}
		}
		sumLength += end - start;

		System.out.println(sumLength);
	}
}