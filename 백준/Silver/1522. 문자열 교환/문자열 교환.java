import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int aTotalSize = 0;
		int result = Integer.MAX_VALUE;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'a') {
				aTotalSize++;
			}
		}

		for (int i = 0; i < s.length(); i++) {
			int start = i;
			int bSize = 0;
			for (int j = 0; j < aTotalSize; j++) {
				if (s.charAt(start % s.length()) == 'b') {
					bSize++;
				}
				start++;
			}

			if (result > bSize) {
				result = bSize;
			}
		}

		System.out.println(result);
	}
}
