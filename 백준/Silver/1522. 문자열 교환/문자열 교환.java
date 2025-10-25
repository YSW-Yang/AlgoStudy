import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int aTotalSize = 0;
		int bSize = 0;
		int result = Integer.MAX_VALUE;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'a') {
				aTotalSize++;
			}
		}

		for (int i = 0; i < aTotalSize; i++) {
			if (s.charAt(i) == 'b') {
				bSize++;
			}
		}
		result = bSize;

		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i - 1) == 'b')
				bSize--;

			if (s.charAt((i + aTotalSize - 1) % s.length()) == 'b')
				bSize++;

			if (result > bSize)
				result = bSize;

		}

		System.out.println(result);
	}
}
