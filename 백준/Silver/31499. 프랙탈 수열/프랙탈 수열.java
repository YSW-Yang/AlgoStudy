import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		int N = Integer.parseInt(inputs[0]);
		int M = Integer.parseInt(inputs[1]);
		long result = 1;

		for (int i = 1; i <= N; i++) {
			result = (result * i) % M;
			
			if (result == 0) break;
		}

		System.out.println(result);
	}
}