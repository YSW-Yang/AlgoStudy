import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int[] origin = new int[n];
		int[] sorted = new int[n];
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < n; i++) {
			origin[i] = sorted[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(sorted);
		int oIndex = 0;
		int sIndex = 0;
		while (sIndex < n) {
			if (stack.isEmpty()) {
				stack.push(sorted[sIndex]);
				sIndex++;
				sb.append("+").append("\n");
			} else if (stack.peek() == origin[oIndex]) {
				stack.pop();
				oIndex++;
				sb.append("-").append("\n");
			} else {
				stack.push(sorted[sIndex]);
				sIndex++;
				sb.append("+").append("\n");
			}
		}
		int size = stack.size();
		while (size-- > 0) {
			if (stack.peek() == origin[oIndex]) {
				stack.pop();
				oIndex++;
				sb.append("-").append("\n");
			}
		}

		if (stack.isEmpty()) {
			System.out.println(sb);
		} else {

			System.out.println("NO");
		}

	}
}
