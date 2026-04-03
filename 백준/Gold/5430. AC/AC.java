import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 0; testCase < T; testCase++) {
			ArrayDeque<Integer> deque = new ArrayDeque<>();
			boolean isConversion = false;
			boolean isError = false;
			String command = br.readLine();
			int size = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(),"[],");
			
			for (int i = 0; i < size; i++) {
				deque.add(Integer.parseInt(st.nextToken()));
			}

			for (int i = 0; i < command.length(); i++) {
				if (command.charAt(i) == 'R') {
					isConversion = !isConversion;
				} else {
					if (deque.isEmpty()) {
						isError = true;
						break;
					}

					if (isConversion) {
						deque.pollLast();
					} else {
						deque.pollFirst();
					}
				}
			}

			if (isError) {
				sb.append("error").append("\n");
			} else {
				sb.append("[");
				while (!deque.isEmpty()) {
					sb.append(isConversion ? deque.pollLast() : deque.pollFirst());
					if (deque.size() >= 1) {
						sb.append(",");
					}
				}
				sb.append("]").append("\n");
			}
		}

		System.out.println(sb);
	}
}