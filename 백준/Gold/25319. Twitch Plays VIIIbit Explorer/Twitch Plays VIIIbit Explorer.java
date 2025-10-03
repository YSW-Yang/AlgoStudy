import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

class Location {
	int row;
	int col;

	public Location(int row, int col) {
		this.row = row;
		this.col = col;
	}
}

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		HashMap<Character, ArrayList<Location>> hashMap = new HashMap<Character, ArrayList<Location>>();
		HashMap<Character, Integer> hashmap1 = new HashMap<Character, Integer>();
		String[] strArr = br.readLine().split(" ");
		int N = Integer.parseInt(strArr[0]);
		int M = Integer.parseInt(strArr[1]);
		char[][] dungeon = new char[N][M];
		int C = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				dungeon[i][j] = s.charAt(j);
			}
		}

		String s = br.readLine();
		for (int i = 0; i < s.length(); i++) {
			hashMap.put(s.charAt(i), new ArrayList<Location>());
			if (hashmap1.containsKey(s.charAt(i))) {
				hashmap1.put(s.charAt(i), hashmap1.get(s.charAt(i)) + 1);
			} else {
				hashmap1.put(s.charAt(i), 1);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (hashMap.containsKey(dungeon[i][j])) {
					hashMap.get(dungeon[i][j]).add(new Location(i, j));
				}
			}
		}

		for (int i = 0; i < s.length(); i++) {
			s.charAt(i);
			int count = hashMap.get(s.charAt(i)).size() / hashmap1.get(s.charAt(i));
			if (C > count) {
				C = count;
			}
		}

		int currentRow = 0;
		int currentCol = 0;
		for (int i = 0; i < C; i++) {
			for (int j = 0; j < s.length(); j++) {
				Location nextLocation = hashMap.get(s.charAt(j)).get(0);
				int nextRow = nextLocation.row - currentRow;
				int nextCol = nextLocation.col - currentCol;

				appendPath(sb, nextRow, "D", "U");
				appendPath(sb, nextCol, "R", "L");

				sb.append("P");
				currentRow = nextLocation.row;
				currentCol = nextLocation.col;
				hashMap.get(s.charAt(j)).remove(0);
			}
		}

		int goalRow = N - 1 - currentRow;
		int goalCol = M - 1 - currentCol;
		appendPath(sb, goalRow, "D", "U");
		appendPath(sb, goalCol, "R", "L");

		System.out.println(C + " " + sb.length() + "\n" + sb.toString());
	}

	private static void appendPath(StringBuilder sb, int delta, String plusChar, String minusChar) {
		if (delta > 0) {
			for (int k = 0; k < delta; k++) {
				sb.append(plusChar);
			}
		} else if (delta < 0) {
			for (int k = 0; k < (delta * -1); k++) {
				sb.append(minusChar);
			}
		}
	}

}
