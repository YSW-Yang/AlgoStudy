import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		int[] res = new int[N];
		Stack<Integer> stack = new Stack<>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			while (!stack.isEmpty() && A[stack.peek()] < A[i]) {
				res[stack.pop()] = A[i];
			}
			stack.push(i);
		}

		while (!stack.isEmpty()) {
			res[stack.pop()] = -1;
		}

		for (int i = 0; i < N; i++) {
			sb.append(res[i]).append(" ");
		}

		System.out.println(sb);
	}
}