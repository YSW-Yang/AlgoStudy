import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] inputs = br.readLine().split(" ");
		int N = Integer.parseInt(inputs[0]);
		int M = Integer.parseInt(inputs[1]);

		ArrayList<Integer>[] graph = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			inputs = br.readLine().split(" ");
			int from = Integer.parseInt(inputs[0]);
			int to = Integer.parseInt(inputs[1]);
			graph[from].add(to);
			graph[to].add(from);
		}

		for (int i = 2; i <= N; i++) {
			int count = 0;
			for (int j = 0; j < graph[i].size(); j++) {
				if (graph[i].get(j) < i) {
					count++;
				}
			}

			if (count == 0) {
				sb.append("N");
			} else if (count == i - 1) {
				sb.append("E");
			} else {
				System.out.println(-1);
				return;
			}
		}

		System.out.println(sb.toString());
	}
}