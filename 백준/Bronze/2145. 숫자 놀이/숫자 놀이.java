import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			int N = Integer.parseInt(br.readLine());

			if (N == 0) {
				break;
			}

			while (N > 9) {
				int sum = 0;

				while (N > 0) {
					sum += N % 10;
					N /= 10;
				}

				N = sum;
			}

			sb.append(N).append('\n');
		}

		System.out.print(sb);
	}
}