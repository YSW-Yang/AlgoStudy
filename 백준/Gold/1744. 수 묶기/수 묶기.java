import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int plusCount = 0;
		int minusCount = 0;
		int zeroCount = 0;
		int maxMinus = -1001;
		int maxMinusIndex = -1;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if (arr[i] == 0) {
				zeroCount++;
			} else if (arr[i] > 0) {
				plusCount++;
			} else if (arr[i] < 0) {
				if(maxMinus < arr[i]) {
					maxMinus = arr[i];
					maxMinusIndex = i;
				}
				minusCount++;
			}
		}
		
		if (minusCount % 2 == 1 && zeroCount >= 1) {
			arr[maxMinusIndex] = 0;
			minusCount--;
		}
		
		int[] positive = new int[plusCount];
		int[] negative = new int[minusCount];
		int pIndex = 0;
		int nIndex = 0;
		for(int i = 0; i < N; i++) {
			if(arr[i] > 0) {
				positive[pIndex++] = arr[i];
			}else if(arr[i] < 0) {
				negative[nIndex++] = arr[i];
			}
		}

		int sum = 0;
		Arrays.sort(positive);
		Arrays.sort(negative);
		for (int i = pIndex - 1; i >= 0; i -= 2) {
			if (i == 0) {
				sum += positive[i];
			} else {
				if (positive[i] * positive[i - 1] > positive[i] + positive[i - 1]) {
					sum += positive[i] * positive[i - 1];
				} else {
					sum += positive[i] + positive[i - 1];
				}
			}
		}
		
		for (int i = 0; i < nIndex; i += 2) {
			if (i == nIndex - 1) {
				sum += negative[i];
			} else {
				if (negative[i] * negative[i + 1] > negative[i] + negative[i + 1]) {
					sum += negative[i] * negative[i + 1];
				} else {
					sum += negative[i] + negative[i + 1];
				}
			}
		}

		System.out.println(sum);
	}
}