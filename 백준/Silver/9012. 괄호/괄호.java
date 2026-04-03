import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int testCase = 0; testCase < T; testCase++) {
			String vps = br.readLine();
			sb.append(checkVPS(vps)).append("\n");
		}

		System.out.println(sb);
	}

	public static String checkVPS(String vps) {
		int count = 0;
		for (int i = 0; i < vps.length(); i++) {
			if (vps.charAt(i) == '(') {
				count++;
			} else {
				if (count == 0) {
					return "NO";
				}
				count--;
			}
		}
		return (count == 0) ? "YES" : "NO";
	}
}
