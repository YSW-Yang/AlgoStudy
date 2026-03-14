import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashMap<String, ArrayList<Integer>> hashmap = new HashMap<>();

		StringTokenizer st = new StringTokenizer(br.readLine());

		boolean found = false;
		int minLen = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			String key = st.nextToken();
			if (!hashmap.containsKey(key)) {
				hashmap.put(key, new ArrayList<Integer>());
			}
			ArrayList<Integer> list = hashmap.get(key);
			list.add(i);

			if (list.size() > 4) {
				int curDiff = i - list.get(list.size() - 5);

				if (minLen > curDiff) {
					minLen = curDiff;
					found = true;
				}
			}
		}

		if (found) {
			System.out.println(minLen + 1);
		} else {
			System.out.println(-1);
		}
	}
}