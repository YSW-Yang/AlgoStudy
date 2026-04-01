import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] meetings = new int[N][2];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			meetings[i][0] = Integer.parseInt(st.nextToken());
			meetings[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(meetings, (t1, t2) -> {
			if (t1[1] == t2[1]) {
				return t1[0] - t2[0];
			}
			return t1[1] - t2[1];
		});

		int count = 0;
		int prevEndTime = 0;
		for (int i = 0; i < N; i++) {
			if (prevEndTime <= meetings[i][0]) {
				prevEndTime = meetings[i][1];
				count++;
			}
		}

		System.out.println(count);
	}
}