import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static final int INF = 1_000_000;

	public static class Node implements Comparable<Node> {
		int index;
		int cost;

		public Node(int index, int cost) {
			this.index = index;
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
		int N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		ArrayList<Node>[] adj = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			adj[from].add(new Node(to, cost));
		}

		int maxCost = 0;
		for (int i = 1; i <= N; i++) {
			maxCost = Math.max(maxCost, dijkstra(i, X, adj, N));
		}

		System.out.println(maxCost);
	}

	public static int dijkstra(int start, int end, ArrayList<Node>[] adj, int N) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		int[] distance = new int[N + 1];
		Arrays.fill(distance, INF);
		distance[start] = 0;
		pq.add(new Node(start, 0));

		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			int curIdx = cur.index;
			int curCost = cur.cost;

			if (distance[curIdx] < curCost) {
				continue;
			}

			for (Node node : adj[curIdx]) {
				if (distance[node.index] > curCost + node.cost) {
					distance[node.index] = curCost + node.cost;
					pq.add(new Node(node.index, distance[node.index]));
				}
			}
		}

		int res1 = distance[end];

		Arrays.fill(distance, INF);
		distance[end] = 0;
		pq.add(new Node(end, 0));
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			int curIdx = cur.index;
			int curCost = cur.cost;

			if (distance[curIdx] < curCost) {
				continue;
			}

			for (Node node : adj[curIdx]) {
				if (distance[node.index] > curCost + node.cost) {
					distance[node.index] = curCost + node.cost;
					pq.add(new Node(node.index, distance[node.index]));
				}
			}
		}

		int res2 = distance[start];

		return res1 + res2;
	}
}