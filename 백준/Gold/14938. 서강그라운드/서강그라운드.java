import java.io.*;
import java.util.*;

public class Main {
	public static int n;
	public static int m;
	public static int r;
	public static int[] items;
	public static int INF;
	public static List<Node>[] list;

	public static class Node implements Comparable<Node> {
		int to;
		int cost;

		public Node(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node other) {
			return Integer.compare(this.cost, other.cost);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int answer = 0;
		INF = Integer.MAX_VALUE;
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		items = new int[n + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			items[i] = Integer.parseInt(st.nextToken());
		}

		list = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			list[from].add(new Node(to, cost));
			list[to].add(new Node(from, cost));
		}

		for (int i = 1; i <= n; i++) {
			answer = Math.max(answer, dijkstra(i));
		}

		System.out.println(answer);
	}

	private static int dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		int[] dist = new int[n + 1];
		Arrays.fill(dist, INF);
		dist[start] = 0;
		pq.add(new Node(start, 0));

		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			if (dist[cur.to] < cur.cost) {
				continue;
			}

			for (Node next : list[cur.to]) {
				if (dist[next.to] > dist[cur.to] + next.cost) {
					dist[next.to] = dist[cur.to] + next.cost;
					pq.add(new Node(next.to, dist[next.to]));
				}
			}
		}

		int sum = 0;
		for (int i = 1; i <= n; i++) {
			if (dist[i] <= m) {
				sum += items[i];
			}
		}

		return sum;
	}
}