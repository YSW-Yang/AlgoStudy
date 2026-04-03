import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = br.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(line);
			String s = st.nextToken();
			String t = st.nextToken();

			int indexS = 0;
			int indexT = 0;
			while (indexT < t.length()) {
				if (s.charAt(indexS) == t.charAt(indexT)) {
					indexS++;
				}
				indexT++;

				if (indexS == s.length()) {
					break;
				}
			}

			sb.append(indexS == s.length() ? "Yes" : "No").append("\n");
		}

		System.out.println(sb);
	}
}
