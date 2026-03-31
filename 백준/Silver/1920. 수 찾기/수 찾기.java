import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);

		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < M; i++) {
			int left = 0;
			int right = N - 1;
			boolean found = false;
			int target = Integer.parseInt(st.nextToken());
			while (left <= right) {
				int mid = (left + right) / 2;
				if (target > nums[mid]) {
					left = mid + 1;
				} else if (target < nums[mid]) {
					right = mid - 1;
				} else {
					found = true;
					break;
				}
			}

			if (found) {
				sb.append(1).append("\n");
			} else {
				sb.append(0).append("\n");
			}
		}

		System.out.println(sb);
	}
}