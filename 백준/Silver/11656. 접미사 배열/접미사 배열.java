import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		ArrayList<String> list = new ArrayList<>();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < input.length(); i++) {
			list.add(input.substring(i));
		}

		Collections.sort(list);
		for (String s : list) {
			sb.append(s).append('\n');
		}
		System.out.println(sb);
	}
}