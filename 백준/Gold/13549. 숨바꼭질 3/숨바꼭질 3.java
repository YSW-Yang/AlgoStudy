import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static class Info {
		int point;
		int time;

		public Info(int point, int time) {
			this.point = point;
			this.time = time;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int limit = 100000;
		int[] map = new int[limit + 1];
		Arrays.fill(map, limit);
		map[N] = 0;
		map[K] = Math.abs(N - K);
		ArrayDeque<Info> queue = new ArrayDeque<>();
		queue.add(new Info(N, 0));
		while (!queue.isEmpty()) {
			Info currnetInfo = queue.poll();

			if (currnetInfo.point == K) {
				break;
			}

			// 순간이동
			int nextPoint = currnetInfo.point;
			while ((nextPoint *= 2) <= limit) {
				if (currnetInfo.time < map[nextPoint]) {
					map[nextPoint] = currnetInfo.time;
					queue.addFirst(new Info(nextPoint, currnetInfo.time));
				}
				if (nextPoint == 0) {
					break;
				}
			}

			// 오른쪽 이동
			if ((currnetInfo.point + 1) <= limit) {
				if (currnetInfo.time + 1 < map[currnetInfo.point + 1]) {
					map[currnetInfo.point + 1] = currnetInfo.time + 1;
					queue.addLast(new Info(currnetInfo.point + 1, currnetInfo.time + 1));
				}
			}

			// 왼쪽 이동
			if ((currnetInfo.point - 1) >= 0) {
				if (currnetInfo.time + 1 < map[currnetInfo.point - 1]) {
					map[currnetInfo.point - 1] = currnetInfo.time + 1;
					queue.addLast(new Info(currnetInfo.point - 1, currnetInfo.time + 1));
				}
			}
		}

		System.out.println(map[K]);
	}
}