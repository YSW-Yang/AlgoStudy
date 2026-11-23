import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int answer = 2 * n - 1;
		int[][] map = new int[n][n];
		boolean[][][] visited = new boolean[2 * n][n][n];
		int[][] directions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] { 0, 0, 0 });
		visited[0][0][0] = true;

		for (int i = 0; i < n; i++) {
			String[] strArr = br.readLine().split("");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(strArr[j]);
			}
		}

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int row = cur[0];
			int col = cur[1];
			int count = cur[2];

			if (answer <= count) {
				continue;
			}

			if (row == n - 1 && col == n - 1) {
				answer = count;
			}

			for (int i = 0; i < 4; i++) {
				int nextRow = row + directions[i][0];
				int nextCol = col + directions[i][1];

				if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < n && !visited[count][nextRow][nextCol]
						&& map[nextRow][nextCol] == 1) {
					queue.add(new int[] { nextRow, nextCol, count });
					visited[count][nextRow][nextCol] = true;
				}
			}

			for (int i = 0; i < 4; i++) {
				int nextRow = row + directions[i][0];
				int nextCol = col + directions[i][1];

				if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < n && !visited[count + 1][nextRow][nextCol]
						&& map[nextRow][nextCol] == 0) {
					queue.add(new int[] { nextRow, nextCol, count + 1 });
					visited[count + 1][nextRow][nextCol] = true;
				}
			}
		}

		System.out.println(answer);
	}
}