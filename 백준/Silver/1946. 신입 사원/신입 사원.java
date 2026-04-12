import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 0; testCase < T; testCase++) {
			int N = Integer.parseInt(br.readLine());
			int[] volunteers = new int[N + 1];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int docRank = Integer.parseInt(st.nextToken());
				int interviewRank = Integer.parseInt(st.nextToken());
				volunteers[docRank] = interviewRank;
			}
			
			int count = 1;
			int minInterviewRank = volunteers[1];
			for (int i = 2; i <= N; i++) {
				if (minInterviewRank > volunteers[i]) {
					minInterviewRank = volunteers[i];
					count++;
				}
			}

			System.out.println(count);
		}
	}
}