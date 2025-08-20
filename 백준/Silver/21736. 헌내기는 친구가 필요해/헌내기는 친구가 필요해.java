import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	public static boolean visited[][];
	public static String[][] campus;
	public static int N;
	public static int M;
	public static Queue<Integer[]> queue;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strArr = br.readLine().split(" ");
		N = Integer.parseInt(strArr[0]);
		M = Integer.parseInt(strArr[1]);
		campus = new String[N][M];
		visited = new boolean[N][M];
		queue = new ArrayDeque<Integer[]>();

		for (int i = 0; i < N; i++) {
			strArr = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				campus[i][j] = strArr[j];
				if (strArr[j].equals("I")) {
					visited[i][j] = true;
					queue.offer(new Integer[] { i, j });
				}
			}
		}

		bfs();
	}

	public static void bfs() {
		int count = 0;
		int[][] move = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

		while (!queue.isEmpty()) {
			Integer[] currentLocation = queue.poll();

			for (int i = 0; i < move.length; i++) {
				int newRow = currentLocation[0] + move[i][0];
				int newCol = currentLocation[1] + move[i][1];
				if (newRow >= 0 && newRow < N && newCol >= 0 && newCol < M && !campus[newRow][newCol].equals("X")
						&& !visited[newRow][newCol]) {
					if (campus[newRow][newCol].equals("P")) {
						count++;
					}
					visited[newRow][newCol] = true;
					queue.offer(new Integer[] { newRow, newCol });
				}
			}
		}
		if (count > 0) {
			System.out.println(count);
		} else {
			System.out.println("TT");
		}
	}
}