import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int testCase = 0; testCase < T; testCase++) {
			String[] strArr = br.readLine().split(" ");
			int a = Integer.parseInt(strArr[0]);
			int b = Integer.parseInt(strArr[1]);
			int c = Integer.parseInt(strArr[2]);
			int dividend = Math.max(a, b); // 나누어지는 수
			int divider = Math.min(a, b); // 나누는 수
			int remainder = dividend % divider;

			if (c > dividend) {
				System.out.println("NO");
				continue;
			}

			while (remainder != 0) {
				dividend = divider;
				divider = remainder;
				remainder = dividend % divider;
			}

			if (c % divider == 0) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
}
