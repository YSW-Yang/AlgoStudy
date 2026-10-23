import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;

class Solution {

	private static int[] parent;
	private static ArrayList<Edge> edgeList;

	private static int findSet(int a) {
		if (parent[a] == a) {
			return a;
		}

		return parent[a] = findSet(parent[a]);
	}

	private static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);

		if (aRoot == bRoot) {
			return false;
		}

		parent[bRoot] = aRoot;
		return true;
	}

	private static class Edge implements Comparable<Edge> {
		int from;
		int to;
		int weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}

	}

	public int solution(int[][] land, int height) {
		int answer = 0;
		int n = land.length;
		int[][] landNumber = new int[n][n];
		boolean[][] visited = new boolean[n][n];
		int count = 0;
		int[][] direction = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
		Queue<int[]> queue = new ArrayDeque<int[]>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j]) {
					queue.add(new int[] { i, j });
					visited[i][j] = true;
					count++;
					landNumber[i][j] = count;
					while (!queue.isEmpty()) {
						int[] sd = queue.poll();
						for (int k = 0; k < direction.length; k++) {
							int nRow = sd[0] + direction[k][0];
							int nCol = sd[1] + direction[k][1];
							if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < n && !visited[nRow][nCol]) {
								int difference = Math.abs(land[nRow][nCol] - land[sd[0]][sd[1]]);
								if (difference <= height) {
									queue.add(new int[] { nRow, nCol });
									visited[nRow][nCol] = true;
									landNumber[nRow][nCol] = count;
								}
							}
						}

					}
				}
			}
		}

		parent = new int[count + 1];
		edgeList = new ArrayList<Solution.Edge>();
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < direction.length; k++) {
					int nRow = i + direction[k][0];
					int nCol = j + direction[k][1];
					if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < n && landNumber[nRow][nCol] != landNumber[i][j]) {
						edgeList.add(new Edge(landNumber[i][j], landNumber[nRow][nCol],
								Math.abs(land[nRow][nCol] - land[i][j])));
					}
				}
			}
		}
		Collections.sort(edgeList);

		for (Edge e : edgeList) {
			if (union(e.from, e.to)) {
				answer += e.weight;
			}
		}

		return answer;
	}
}