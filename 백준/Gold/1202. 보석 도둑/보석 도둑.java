import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static class Jewel implements Comparable<Jewel> {
		int weight;
		int price;

		public Jewel(int weight, int price) {
			this.weight = weight;
			this.price = price;
		}

		@Override
		public int compareTo(Jewel other) {
			return this.weight - other.weight;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		Jewel[] jewels = new Jewel[N];
		int[] bags = new int[K];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int weight = Integer.parseInt(st.nextToken());
			int price = Integer.parseInt(st.nextToken());
			jewels[i] = new Jewel(weight, price);
		}
		Arrays.sort(jewels);

		for (int i = 0; i < K; i++) {
			bags[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(bags);

		long totalPrice = 0;
		int jewelIndex = 0;
		for (int i = 0; i < K; i++) {
			while (jewelIndex < N && jewels[jewelIndex].weight <= bags[i]) {
				pq.add(jewels[jewelIndex].price);
				jewelIndex++;
			}

			if (!pq.isEmpty()) {
				totalPrice += pq.poll();
			}
		}

		System.out.println(totalPrice);
	}
}
