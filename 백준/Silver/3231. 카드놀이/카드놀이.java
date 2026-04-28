import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N + 1];

		for (int i = 0; i < N; i++) {
			int index = Integer.parseInt(br.readLine());
			arr[index] = i;
		}

		int count = 0;
		for (int i = 2; i <= N; i++) {
			if (arr[i] < arr[i - 1]) {
				count++;
			}
		}

		System.out.println(count);
	}
}