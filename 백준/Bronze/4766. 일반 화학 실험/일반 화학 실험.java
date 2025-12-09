import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		double prev = Double.parseDouble(br.readLine());
		while (true) {
			String input = br.readLine().trim();
			if (input.equals("999")) {
				break;
			}
			double cur = Double.parseDouble(input);

			String result = String.format("%.2f", cur - prev);
			sb.append(result).append("\n");

			prev = cur;
		}

		System.out.println(sb.toString());
	}
}