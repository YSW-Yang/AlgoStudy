import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

class Store {
	long price;
	long difference;

	public Store(long price, long difference) {
		this.price = price;
		this.difference = difference;
	}
	
	public long getPrice() {
		return price;
	}
	
	public long getDifference() {
		return difference;
	}
}

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strArr = br.readLine().split(" ");
		int N = Integer.parseInt(strArr[0]);
		int A = Integer.parseInt(strArr[1]);
		int B = Integer.parseInt(strArr[2]);
		Store[] p = new Store[N];
		Store[] q = new Store[N];
		long result = 0;

		for (int i = 0; i < N; i++) {
			strArr = br.readLine().split(" ");
			int pPrice = Integer.parseInt(strArr[0]);
			int qPrice = Integer.parseInt(strArr[1]);
			int pDifference = pPrice - qPrice;
			int qDifference = qPrice - pPrice;
			p[i] = new Store(pPrice, pDifference);
			q[i] = new Store(qPrice, qDifference);
		}

		Arrays.sort(p, Comparator.comparing(Store::getDifference).thenComparing(Store::getPrice));
		Arrays.sort(q, Comparator.comparing(Store::getDifference).thenComparing(Store::getPrice, Comparator.reverseOrder()));

		for (int i = 0; i < A; i++) {
			result += p[i].price;
		}
		for (int i = 0; i < B; i++) {
			result += q[i].price;
		}

		System.out.println(result);
	}

}
