import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int testCase = 0; testCase < T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			Integer[] importances = new Integer[n];
			int target = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			Queue<Integer> queue = new ArrayDeque<>();

			for (int i = 0; i < n; i++) {
				importances[i] = Integer.parseInt(st.nextToken());
				queue.add(importances[i]);
			}

			Arrays.sort(importances, (p1, p2) -> {
				return p2 - p1;
			});

			int index = 0;
			while (true) {
				if (queue.peek() == importances[index]) {
					if (target == 0) {
						break;
					}
					queue.poll();
					index++;
					target--;
				} else {
					queue.add(queue.poll());
					if (target == 0) {
						target = queue.size() - 1;
					} else {
						target--;
					}
				}
			}

			System.out.println(index + 1);
		}
	}
}
