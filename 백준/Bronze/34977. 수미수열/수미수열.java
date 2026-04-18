import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N / 2; i++) {
			boolean isSame = true;
			for (int j = 0; j <= i; j++) {
				if (nums[j] != nums[N - 1 - i + j]) {
					isSame = false;
					break;
				}
			}
			if (isSame) {
				System.out.println("yes");
				return;
			}
		}

		System.out.println("no");
	}
}