import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());

		for (int testCase = 0; testCase < T; testCase++) {
			st = new StringTokenizer(br.readLine());
			int[] playerScores = new int[2];
			for (int i = 0; i < 2; i++) {
				int totalScore = 0;
				for (int j = 0; j < 3; j++) {
					double x = Double.parseDouble(st.nextToken());
					double y = Double.parseDouble(st.nextToken());

					double distSquared = (x * x) + (y * y);
					if (distSquared <= 9) {
						totalScore += 100;
					} else if (distSquared <= 36) {
						totalScore += 80;
					} else if (distSquared <= 81) {
						totalScore += 60;
					} else if (distSquared <= 144) {
						totalScore += 40;
					} else if (distSquared <= 225) {
						totalScore += 20;
					}
				}
				playerScores[i] = totalScore;
			}

			sb.append("SCORE: ").append(playerScores[0]).append(" to ").append(playerScores[1]).append(", ");
			if (playerScores[0] == playerScores[1]) {
				sb.append("TIE.").append("\n");
			} else if (playerScores[0] > playerScores[1]) {
				sb.append("PLAYER 1 WINS.").append("\n");
			} else {
				sb.append("PLAYER 2 WINS.").append("\n");
			}
		}

		System.out.println(sb.toString());
	}
}