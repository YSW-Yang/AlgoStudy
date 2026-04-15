import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String input = br.readLine();
		int[] count = new int[10];

		int sum = 0;
		for (int i = 0; i < input.length(); i++) {
			int num = input.charAt(i) - '0';
			count[num]++;
			sum += num;
		}
		if (sum % 3 != 0 || count[0] == 0) {
			System.out.println(-1);
			return;
		}

		for (int i = 9; i >= 0; i--) {
			while (count[i] > 0) {
				sb.append(i);
				count[i]--;
			}
		}

		System.out.println(sb);
	}
}