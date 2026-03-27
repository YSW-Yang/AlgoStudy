import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		String result = "";

		int maxCount = 0;
		int start = n / 2;
		for (int i = start; i <= n; i++) {
			int preNum = n;
			int currentNum = i;
			int count = 2;
			sb.append(preNum).append(" ").append(currentNum).append(" ");
			while (preNum - currentNum >= 0) {
				int next = preNum - currentNum;
				preNum = currentNum;
				currentNum = next;
				sb.append(currentNum).append(" ");
				count++;
			}

			if (maxCount < count) {
				maxCount = count;
				result = sb.toString();
			}
			sb.setLength(0);
		}

		System.out.println(maxCount + "\n" + result);
	}
}