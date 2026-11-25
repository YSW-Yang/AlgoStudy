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
		st = new StringTokenizer(br.readLine());
		int sRow = Integer.parseInt(st.nextToken()) - 1;
		int sCol = Integer.parseInt(st.nextToken()) - 1;
		int eRow = Integer.parseInt(st.nextToken()) - 1;
		int eCol = Integer.parseInt(st.nextToken()) - 1;

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		System.out.println(bfs(sRow, sCol, eRow, eCol, map));
	}

	public static int bfs(int sRow, int sCol, int eRow, int eCol, char[][] map) {
		Deque<int[]> queue = new ArrayDeque<>();
		int[][] dist = new int[N][M];
		int[][] directions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
		int INF = Integer.MAX_VALUE;
		queue.add(new int[] { sRow, sCol });
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				dist[i][j] = INF;
			}
		}
		dist[sRow][sCol] = 1;

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int row = cur[0];
			int col = cur[1];

			if (row == eRow && col == eCol) {
				return dist[row][col];
			}

			for (int i = 0; i < 4; i++) {
				int nr = row + directions[i][0];
				int nc = col + directions[i][1];

				if (nr < 0 || nr >= N || nc < 0 || nc >= M || dist[nr][nc] != INF) {
					continue;
				}

				if (map[nr][nc] == '1') {
					queue.addLast(new int[] { nr, nc });
					dist[nr][nc] = dist[row][col] + 1;
				} else {
					queue.addFirst(new int[] { nr, nc });
					dist[nr][nc] = dist[row][col];
				}

			}
		}

		return -1;
	}
}