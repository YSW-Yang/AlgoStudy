import java.io.*;
import java.util.*;

public class Main {
	public static class Node {
		int idx;
		int val;

		public Node(int idx, int val) {
			this.idx = idx;
			this.val = val;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		Deque<Node> dq = new ArrayDeque<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int cur = Integer.parseInt(st.nextToken());
			while(!dq.isEmpty() && dq.peekLast().val > cur) {
				dq.pollLast();
			}
			dq.addLast(new Node(i, cur));
			
			if(dq.peekFirst().idx <= i - L) {
				dq.pollFirst();
			}
			
			sb.append(dq.peek().val).append(' ');
		}

		System.out.println(sb);
	}
}