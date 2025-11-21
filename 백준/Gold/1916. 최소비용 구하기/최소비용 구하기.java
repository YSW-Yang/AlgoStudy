import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	final static int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		String[] strArr;
		int[][] graph = new int[N + 1][N + 1];
		int[] dist = new int[N + 1];
		boolean[] visited = new boolean[N + 1];

		for (int i = 0; i < graph.length; i++) {
			Arrays.fill(graph[i], INF);
			graph[i][i] = 0;
			dist[i] = INF;
		}

		for (int i = 0; i < M; i++) {
			strArr = br.readLine().split(" ");
			int from = Integer.parseInt(strArr[0]);
			int to = Integer.parseInt(strArr[1]);
			int weight = Integer.parseInt(strArr[2]);

			graph[from][to] = Math.min(graph[from][to], weight);
		}
		strArr = br.readLine().split(" ");
		int start = Integer.parseInt(strArr[0]);
		int end = Integer.parseInt(strArr[1]);

		dist[start] = 0;
		for (int i = 0; i < N; i++) {
			int min = INF;
			int minIndex = -1;

			for (int j = 1; j < N + 1; j++) {
				if (!visited[j] && dist[j] < min) {
					min = dist[j];
					minIndex = j;
				}
			}

			if (minIndex == -1) {
				break;
			}

			visited[minIndex] = true;

			for (int j = 1; j < N + 1; j++) {
				if (!visited[j] && graph[minIndex][j] != INF) {
					if (dist[j] > dist[minIndex] + graph[minIndex][j]) {
						dist[j] = dist[minIndex] + graph[minIndex][j];
					}
				}
			}
		}

		System.out.println(dist[end] == INF ? -1 : dist[end]);
	}
}
