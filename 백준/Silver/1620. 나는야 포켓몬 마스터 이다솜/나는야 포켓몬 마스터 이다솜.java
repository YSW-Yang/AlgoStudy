import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<String, Integer> nameToNum = new HashMap<>();
		String[] numToName = new String[N + 1];
		for (int i = 1; i <= N; i++) {
			String name = br.readLine();
			nameToNum.put(name, i);
			numToName[i] = name;
		}

		for (int i = 0; i < M; i++) {
			String name = br.readLine();
			if (nameToNum.containsKey(name)) {
				sb.append(nameToNum.get(name)).append("\n");
			} else {
				int index = Integer.parseInt(name);
				sb.append(numToName[index]).append("\n");
			}
		}

		System.out.println(sb);
	}
}
