import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int count = 0;

		if (n == 0) {
			System.out.println(1);
		} else if (n < 0) {
			System.out.println(32);
		} else {
			while (n > 0) {
				n /= 2;
				count++;
			}
			System.out.println(count);
		}
	}
}