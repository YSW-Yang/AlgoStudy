import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashSet<String> set = new HashSet<>();
		ArrayList<String> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			set.add(br.readLine());
		}

		for (int i = 0; i < M; i++) {
			String s = br.readLine();
			if (set.contains(s)) {
				list.add(s);
			}
		}

		list.sort((s1, s2) -> {
			return s1.compareTo(s2);
		});

		sb.append(list.size()).append("\n");
		for (String name : list) {
			sb.append(name).append("\n");
		}

		System.out.println(sb);
	}
}