import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		boolean[][] board = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			for (int j = 0; j < m; j++) {
				board[i][j] = (input.charAt(j) == 'W');
			}
		}

		int minCount = Integer.MAX_VALUE;
		for (int i = 0; i <= n - 8; i++) {
			for (int j = 0; j <= m - 8; j++) {
				int count = 0;
				for (int k = 0; k < 8; k++) {
					for (int l = 0; l < 8; l++) {
						boolean correctColor = ((k + l) % 2 == 0);
						if (board[i + k][j + l] != correctColor) {
							count++;
						}
					}
				}
				count = Math.min(64 - count, count);
				minCount = Math.min(minCount, count);
			}
		}

		System.out.println(minCount);
	}
}