import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static final int INF = 200_000_000;

	public static class Info implements Comparable<Info> {
		int to;
		long cost;

		public Info(int to, long cost) {
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Info other) {
			return (int) (this.cost - other.cost);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		PriorityQueue<Info> pq = new PriorityQueue<>();
		List<Info>[] list = new ArrayList[N + 1];
		long[][] distances = new long[3][N + 1];
		boolean[][] visited = new boolean[3][N + 1];
		int[] depart = new int[3];
		depart[0] = 1;
		for (int i = 0; i < 3; i++) {
			Arrays.fill(distances[i], INF);
		}
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list[a].add(new Info(b, c));
			list[b].add(new Info(a, c));
		}
		st = new StringTokenizer(br.readLine());
		depart[1] = Integer.parseInt(st.nextToken());
		depart[2] = Integer.parseInt(st.nextToken());

		distances[0][depart[0]] = 0;
		distances[1][depart[1]] = 0;
		distances[2][depart[2]] = 0;
		for (int i = 0; i < 3; i++) {
			pq.add(new Info(depart[i], 0));

			while (!pq.isEmpty()) {
				Info currentInfo = pq.poll();
				int to = currentInfo.to;
				visited[i][to] = true;
				for (Info nextInfo : list[to]) {
					if (!visited[i][nextInfo.to] && distances[i][nextInfo.to] > currentInfo.cost + nextInfo.cost) {
						distances[i][nextInfo.to] = currentInfo.cost + nextInfo.cost;
						pq.add(new Info(nextInfo.to, distances[i][nextInfo.to]));
					}
				}
			}
		}

		long result = Math.min(distances[0][depart[1]] + distances[1][depart[2]] + distances[2][N],
				distances[0][depart[2]] + distances[2][depart[1]] + distances[1][N]);

		System.out.println((result >= INF) ? -1 : result);
	}
}