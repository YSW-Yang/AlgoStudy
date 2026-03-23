import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int temp = n;
		int count = 0;
		int sum = -1;
		while (n != sum) {
			int a = temp / 10;
			int b = temp % 10;
			sum = (a + b);
			sum = (sum % 10) + (b * 10);
			temp = sum;
			count++;
		}

		System.out.println(count);
	}
}