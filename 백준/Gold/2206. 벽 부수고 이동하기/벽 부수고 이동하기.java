import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	public static class PlayerInfo {
		int row;
		int col;
		int wallBreakCount;

		public PlayerInfo(int row, int col, int wallBreakCount) {
			this.row = row;
			this.col = col;
			this.wallBreakCount = wallBreakCount;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		int N = Integer.parseInt(inputs[0]);
		int M = Integer.parseInt(inputs[1]);
		int[][] map = new int[N][M];
		boolean[][][] visited = new boolean[N][M][2];
		Queue<PlayerInfo> queue = new ArrayDeque<PlayerInfo>();
		int[][] direction = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

		for (int i = 0; i < N; i++) {
			inputs = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(inputs[j]);
			}
		}
		queue.add(new PlayerInfo(0, 0, 0));
		visited[0][0][0] = true;

		int count = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			count++;
			while (size-- > 0) {
				PlayerInfo curInfo = queue.poll();
				int currentRow = curInfo.row;
				int currentCol = curInfo.col;
				int currentWBC = curInfo.wallBreakCount;
				if (currentRow == N - 1 && currentCol == M - 1) {
					System.out.println(count);
					return;
				}

				for (int i = 0; i < 4; i++) {
					int nextRow = currentRow + direction[i][0];
					int nextCol = currentCol + direction[i][1];

					if (nextRow >= 0 && nextRow < N && nextCol >= 0 && nextCol < M) {
						if (map[nextRow][nextCol] == 0) {
							if (!visited[nextRow][nextCol][currentWBC]) {
								queue.add(new PlayerInfo(nextRow, nextCol, currentWBC));
								visited[nextRow][nextCol][currentWBC] = true;
							}
						} else if (currentWBC == 0) {
							if (!visited[nextRow][nextCol][1]) {
								queue.add(new PlayerInfo(nextRow, nextCol, 1));
								visited[nextRow][nextCol][1] = true;
							}
						}
					}
				}
			}
		}

		System.out.println(-1);
	}
}