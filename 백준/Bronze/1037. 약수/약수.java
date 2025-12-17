import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;

		while (n-- > 0) {
			int num = Integer.parseInt(st.nextToken());

			max = num > max ? num : max;
			min = num < min ? num : min;
		}

		System.out.println(max * min);
	}
}