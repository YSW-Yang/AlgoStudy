import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[][] ground = new int[N][M];
		Queue<Integer[]> queue = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][M];
		int[][] direction = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

		boolean found = false;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				ground[i][j] = Integer.parseInt(st.nextToken());
				if (ground[i][j] == 0) {
					found = true;
				} else if (ground[i][j] == 1) {
					queue.add(new Integer[] { i, j });
					visited[i][j] = true;
				}
			}
		}
		if (!found) {
			System.out.println(0);
			return;
		}

		int time = -1;
		while (!queue.isEmpty()) {
			int size = queue.size();
			time++;
			while (size-- > 0) {
				Integer[] curr = queue.poll();
				int currRow = curr[0];
				int currCol = curr[1];
				for (int i = 0; i < 4; i++) {
					int nextRow = currRow + direction[i][0];
					int nextCol = currCol + direction[i][1];
					if (nextRow >= 0 && nextRow < N && nextCol >= 0 && nextCol < M && !visited[nextRow][nextCol]
							&& ground[nextRow][nextCol] == 0) {
						queue.add(new Integer[] { nextRow, nextCol });
						visited[nextRow][nextCol] = true;
						ground[nextRow][nextCol] = 1;
					}
				}
			}
		}

		found = false;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (ground[i][j] == 0) {
					found = true;
				}
			}
		}

		System.out.println(found ? -1 : time);
	}
}