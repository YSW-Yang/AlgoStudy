import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] days = new int[n];
		for (int i = 0; i < n; i++) {
			days[i] = Integer.parseInt(st.nextToken());
		}

		int anger = 0;
		long totalAnger = 0;
		for (int i = 0; i < n; i++) {
			if (days[i] == 1) {
				anger++;
			} else {
				anger--;
			}

			totalAnger += anger;
		}

		System.out.println(totalAnger);
	}
}