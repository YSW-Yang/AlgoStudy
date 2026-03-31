import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String input = br.readLine();
		int[] nums = new int[input.length()];

		for (int i = 0; i < input.length(); i++) {
			int num = input.charAt(i) - '0';
			nums[i] = num;
		}
		Arrays.sort(nums);

		for (int i = nums.length - 1; i >= 0; i--) {
			sb.append(nums[i]);
		}
		System.out.println(sb);
	}
}