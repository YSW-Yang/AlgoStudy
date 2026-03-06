import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		String targetNickname = st.nextToken();
		HashMap<String, Integer> answerCounts = new HashMap<String, Integer>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String nickname = st.nextToken();
			String chat = st.nextToken();

			if (nickname.equals(targetNickname)) {
				System.out.println(answerCounts.getOrDefault(chat, 0));
				return;
			}

			answerCounts.put(chat, answerCounts.getOrDefault(chat, 0) + 1);
		}
	}
}