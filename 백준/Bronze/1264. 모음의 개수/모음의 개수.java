import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String vowels = "aeiouAEIOU";
		while (true) {
			String input = br.readLine();
			if (input.equals("#")) {
				System.out.println(sb.toString());
				return;
			}

			int count = 0;
			for (int i = 0; i < input.length(); i++) {
				char alp = input.charAt(i);
				if (vowels.indexOf(alp) != -1) {
					count++;
				}
			}
			sb.append(count).append("\n");
		}
	}
}