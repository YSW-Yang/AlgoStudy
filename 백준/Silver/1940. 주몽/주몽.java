import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[] materials = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			materials[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(materials);

		int left = 0;
		int right = N - 1;
		int count = 0;
		while (left < right) {
			int sum = materials[left] + materials[right];
			if (sum > M) {
				right--;
			} else if (sum < M) {
				left++;
			} else {
				left++;
				right--;
				count++;
			}
		}

		System.out.println(count);
	}
}
