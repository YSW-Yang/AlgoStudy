import java.io.*;
import java.util.*;

public class Main {
	private static class BookInfo implements Comparable<BookInfo> {
		String name;
		int sellCount;

		public BookInfo(String name, int sellCount) {
			this.name = name;
			this.sellCount = sellCount;
		}

		@Override
		public int compareTo(BookInfo other) {
			if (other.sellCount == this.sellCount) {
				return this.name.compareTo(other.name);
			}
			return Integer.compare(other.sellCount, this.sellCount);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashMap<String, Integer> hashmap = new HashMap<>();
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			hashmap.put(s, hashmap.getOrDefault(s, 0) + 1);
		}

		List<BookInfo> list = new ArrayList<BookInfo>();
		for (Map.Entry<String, Integer> entry : hashmap.entrySet()) {
			list.add(new BookInfo(entry.getKey(), entry.getValue()));
		}
		Collections.sort(list);

		System.out.println(list.get(0).name);
	}
}