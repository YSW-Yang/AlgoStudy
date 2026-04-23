import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			long n = Long.parseLong(st.nextToken());
			long m = Long.parseLong(st.nextToken());

			long count = m - n + 1;
			long res = (n + m) * count / 2;
			sb.append("Scenario #").append(testCase).append(":\n");
			sb.append(res).append("\n\n");
		}

		System.out.println(sb);
	}
}