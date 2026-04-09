import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[][] stone = new long[N][N];
		int r0 = 0;
		int c0 = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				stone[i][j] = Long.parseLong(st.nextToken());
				if (stone[i][j] == 0) {
					r0 = i;
					c0 = j;
				}
			}
		}

		int targetRow = (r0 == 0) ? 1 : 0;
		long targetSum = 0;
		for (int j = 0; j < N; j++) {
			targetSum += stone[targetRow][j];
		}

		long currentSum = 0;
		for (int j = 0; j < N; j++) {
			currentSum += stone[r0][j];
		}

		long M = targetSum - currentSum;
		if (M <= 0) {
			System.out.println(-1);
			return;
		}

		stone[r0][c0] = M;
		if (isValid(stone, N, targetSum)) {
			System.out.println(M);
		} else {
			System.out.println(-1);
		}
	}

	private static boolean isValid(long[][] stone, int N, long targetSum) {
		long d1 = 0, d2 = 0;
		for (int i = 0; i < N; i++) {
			long rowSum = 0, colSum = 0;
			for (int j = 0; j < N; j++) {
				rowSum += stone[i][j];
				colSum += stone[j][i];
			}
			if (rowSum != targetSum || colSum != targetSum)
				return false;

			d1 += stone[i][i];
			d2 += stone[i][N - 1 - i];
		}
		return d1 == targetSum && d2 == targetSum;
	}
}