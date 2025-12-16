import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		String[] cmd = new String[N];

		for (int i = 0; i < N; i++) {
			cmd[i] = br.readLine();
		}

		for (int i = 0; i < cmd[0].length(); i++) {
			boolean isSame = true;
			for (int j = 0; j < N - 1; j++) {
				if (cmd[j].charAt(i) != cmd[j + 1].charAt(i)) {
					isSame = false;
					break;
				}
			}
			
			sb.append(isSame ? cmd[0].charAt(i) : '?');
		}

		System.out.println(sb.toString());
	}
}