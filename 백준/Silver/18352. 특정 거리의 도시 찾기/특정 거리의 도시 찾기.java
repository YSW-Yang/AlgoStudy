import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static final int INF = 500_000;

	public static class Node implements Comparable<Node> {
		int idx;
		int cost;

		public Node(int idx, int cost) {
			this.idx = idx;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node other) {
			return this.cost - other.cost;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		ArrayList<Integer>[] list = new ArrayList[N + 1];
		int[] distances = new int[N + 1];
		PriorityQueue<Node> queue = new PriorityQueue<>();
		Arrays.fill(distances, INF);
		distances[X] = 0;
		queue.add(new Node(X, 0));

		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			list[from].add(to);
		}

		while (!queue.isEmpty()) {
			Node curr = queue.poll();
			int currIdx = curr.idx;
			int currCost = curr.cost;

			if (distances[currIdx] < currCost) {
				continue;
			}

			for (int next : list[currIdx]) {
				if (distances[next] > distances[currIdx] + 1) {
					distances[next] = distances[currIdx] + 1;
					queue.add(new Node(next, distances[next]));
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			if (distances[i] == K) {
				sb.append(i).append("\n");
			}
		}

		System.out.println(sb.length() == 0 ? -1 : sb);
	}
}