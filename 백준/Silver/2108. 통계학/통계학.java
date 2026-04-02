import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Main {
	public static class Mode implements Comparable<Mode> {
		int num;
		int count;

		public Mode(int num, int count) {
			this.num = num;
			this.count = count;
		}

		@Override
		public int compareTo(Mode o) {
			if (o.count == this.count) {
				return this.num - o.num;
			}
			return o.count - this.count;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashMap<Integer, Integer> frequencyMap = new HashMap<>();
		int[] numbers = new int[N];
		ArrayList<Mode> modes = new ArrayList<>();

		long sum = 0;
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(br.readLine());
			sum += numbers[i];
			frequencyMap.put(numbers[i], frequencyMap.getOrDefault(numbers[i], 0) + 1);
		}
		Arrays.sort(numbers);
		for (int key : frequencyMap.keySet()) {
			modes.add(new Mode(key, frequencyMap.get(key)));
		}
		Collections.sort(modes);
		int mean = (int) Math.round((double) sum / N);
		int median = numbers[N / 2];
		int mode = modes.get(0).num;
		if (modes.size() > 1 && modes.get(0).count == modes.get(1).count) {
			mode = modes.get(1).num;
		}
		int range = numbers[N - 1] - numbers[0];

		System.out.println(mean + "\n" + median + "\n" + mode + "\n" + range);
	}
}
