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
			String A = st.nextToken();
			String B = st.nextToken();

			if (A.length() != B.length()) {
				sb.append(A).append(" & ").append(B).append(" are NOT anagrams.").append('\n');
				continue;
			}

			int[] counts = new int[26];
			for (int i = 0; i < A.length(); i++) {
				counts[A.charAt(i) - 'a']++;
			}

			for (int i = 0; i < B.length(); i++) {
				counts[B.charAt(i) - 'a']--;
			}

			boolean isAnagram = true;
			for (int i : counts) {
				if (i != 0) {
					isAnagram = false;
					break;
				}
			}

			if (isAnagram) {
				sb.append(A).append(" & ").append(B).append(" are anagrams.").append('\n');
			} else {
				sb.append(A).append(" & ").append(B).append(" are NOT anagrams.").append('\n');
			}
		}

		System.out.println(sb);
	}
}
