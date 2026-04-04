import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		int left = 0;
		int right = N - 1;
		long result = Long.MAX_VALUE;
		int resLeft = 0;
		int resRight = 0;
		while (left < right) {
			long sum = arr[left] + arr[right];
			long abs = Math.abs(sum);
			if (result > abs) {
				result = abs;
				resLeft = arr[left];
				resRight = arr[right];
			}

			if (sum > 0) {
				right--;
			} else if (sum == 0) {
				System.out.println(arr[left] + " " + arr[right]);
				return;
			} else {
				left++;
			}
		}

		System.out.println(resLeft + " " + resRight);
	}
}