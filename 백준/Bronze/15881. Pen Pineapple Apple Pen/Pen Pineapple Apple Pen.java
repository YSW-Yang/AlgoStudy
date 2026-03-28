import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String input = br.readLine();
		int count = 0;
		for (int i = 0; i < n - 3; i++) {
			if (input.charAt(i) == 'p') {
				if (input.charAt(i + 1) == 'P' && input.charAt(i + 2) == 'A' && input.charAt(i + 3) == 'p') {
					count++;
					i += 3;
				}
			}
		}

		System.out.println(count);
	}
}