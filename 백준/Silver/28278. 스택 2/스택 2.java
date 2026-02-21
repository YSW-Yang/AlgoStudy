import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());
			if (command == 1) {
				int x = Integer.parseInt(st.nextToken());
				stack.push(x);
			} else if (command == 2) {
				if (stack.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(stack.pop());
				}
			} else if (command == 3) {
				System.out.println(stack.size());
			} else if (command == 4) {
				System.out.println(stack.isEmpty() ? 1 : 0);
			} else if (command == 5) {
				System.out.println(stack.isEmpty() ? -1 : stack.peek());
			}
		}
	}
}