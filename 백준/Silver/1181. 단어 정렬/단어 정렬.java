import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashSet<String> set = new HashSet<>();
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			set.add(br.readLine());
		}
		ArrayList<String> list = new ArrayList<String>(set);

		list.sort((s1, s2) -> {
			if (s1.length() == s2.length()) {
				return s1.compareTo(s2);
			}
			return s1.length() - s2.length();
		});

		for (String s : list) {
			sb.append(s).append("\n");
		}

		System.out.println(sb);
	}
}