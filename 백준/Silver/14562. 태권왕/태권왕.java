import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

class Record {
	int S;
	int T;
	int count;

	public Record(int S, int T, int count) {
		this.S = S;
		this.T = T;
		this.count = count;
	}
}

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Record> queue = new ArrayDeque<Record>();

		int t = Integer.parseInt(br.readLine());
		for (int testCase = 0; testCase < t; testCase++) {
			String[] strArr = br.readLine().split(" ");
			int S = Integer.parseInt(strArr[0]);
			int T = Integer.parseInt(strArr[1]);
			queue.add(new Record(S, T, 0));

			while (!queue.isEmpty()) {
				Record currentRecord = queue.poll();

				if (currentRecord.S == currentRecord.T) {
					System.out.println(currentRecord.count);
					break;
				}

				// 발차기 A인 경우
				Record nextA = new Record(currentRecord.S * 2, currentRecord.T + 3, currentRecord.count + 1);
				if (nextA.S <= nextA.T) {
					queue.add(nextA);
				}
				// 발차기 B인 경우
				Record nextB = new Record(currentRecord.S + 1, currentRecord.T, currentRecord.count + 1);
				if (nextB.S <= nextB.T) {
					queue.add(nextB);
				}
			}
			queue.clear();
		}
	}
}