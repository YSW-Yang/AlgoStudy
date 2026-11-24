import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static int M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		char[][] map = new char[N][M];
		String[] strArr = br.readLine().split(" ");
		int sRow = Integer.parseInt(strArr[0]) - 1;
		int sCol = Integer.parseInt(strArr[1]) - 1;

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		int count = 1;
		while (!bfs(sRow, sCol, map)) {
			count++;
		}
		System.out.println(count);
	}

	public static boolean bfs(int sRow, int sCol, char[][] map) {
		Queue<int[]> queue = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][M];
		int[][] directions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
		queue.add(new int[] { sRow, sCol });
		visited[sRow][sCol] = true;

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int row = cur[0];
			int col = cur[1];

			if (map[row][col] == '#') {
				return true;
			}

			for (int i = 0; i < 4; i++) {
				int nr = row + directions[i][0];
				int nc = col + directions[i][1];

				if (nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc]) {
					continue;
				}
				
				visited[nr][nc] = true;
				
				if (map[nr][nc] == '1') {
					map[nr][nc] = '0';
				} else {
					queue.add(new int[] { nr, nc });
				}

			}
		}

		return false;
	}
}