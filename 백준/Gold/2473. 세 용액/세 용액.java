import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] arr = new long[N];
		long[] res = new long[3];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(arr);

		Long min = Long.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			int left = i + 1;
			int right = N - 1;

			while (left < right) {
				long sum = arr[i] + arr[left] + arr[right];

				if (min > Math.abs(sum)) {
					res[0] = arr[i];
					res[1] = arr[left];
					res[2] = arr[right];

					min = Math.abs(sum);
				}
				if (sum == 0) {
					break;
				}

				if (sum > 0) {
					right--;
				} else {
					left++;
				}
			}
		}

		System.out.println(res[0] + " " + res[1] + " " + res[2] + " ");
	}
}
