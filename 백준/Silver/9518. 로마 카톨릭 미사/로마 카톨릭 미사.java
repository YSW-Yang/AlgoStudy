import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		char[][] map = new char[R][S];
		int[][] directions = { { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 } };

		for (int i = 0; i < R; i++) {
			String input = br.readLine();
			for (int j = 0; j < S; j++) {
				map[i][j] = input.charAt(j);
			}
		}

		int maxCount = -1;
		int sitRow = -1;
		int sitCol = -1;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < S; j++) {
				int count = 0;
				if (map[i][j] == '.') {
					for (int k = 0; k < 8; k++) {
						int nextRow = i + directions[k][0];
						int nextCol = j + directions[k][1];

						if (nextRow >= 0 && nextRow < R && nextCol >= 0 && nextCol < S
								&& map[nextRow][nextCol] == 'o') {
							count++;
						}
					}
					if (maxCount < count) {
						maxCount = count;
						sitRow = i;
						sitCol = j;
					}
				}
			}
		}

		if (sitRow != -1) {
			map[sitRow][sitCol] = 'o';
		}

		int clapCount = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < S; j++) {
				if (map[i][j] == 'o') {
					for (int k = 2; k < 6; k++) {
						int nextRow = i + directions[k][0];
						int nextCol = j + directions[k][1];

						if (nextRow >= 0 && nextRow < R && nextCol >= 0 && nextCol < S
								&& map[nextRow][nextCol] == 'o') {
							clapCount++;
						}
					}
				}
			}
		}

		System.out.println(clapCount);
	}
}