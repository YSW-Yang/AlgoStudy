import java.util.Queue;
import java.util.ArrayDeque;
class Solution {
	public int solution(int[][] maps) {
		int answer = 0, count = 1;
		Queue<Integer> arrQueue = new ArrayDeque();
		int[][] arr = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
		boolean[][] visited = new boolean[maps.length][maps[0].length];
		visited[0][0] = true;
		int sRow = 0;
		int sCol = 0;

		while (true) {
			count++;
			for (int k = 0; k < arr.length; k++) {
				int nRow = sRow + arr[k][0];
				int nCol = sCol + arr[k][1];
				if (nRow >= 0 && nRow < maps.length && nCol >= 0 && nCol < maps[0].length && !visited[nRow][nCol]
						&& maps[nRow][nCol] == 1) {
					arrQueue.add(nRow);
					arrQueue.add(nCol);
					arrQueue.add(count);
					visited[nRow][nCol] = true;
				}
			}
			if (!arrQueue.isEmpty()) {
				sRow = arrQueue.poll();
				sCol = arrQueue.poll();
				count = arrQueue.poll();
				if (sRow == maps.length - 1 && sCol == maps[0].length - 1) {
					return count;
				}
			} else {
				return -1;
			}
		}
	}
}