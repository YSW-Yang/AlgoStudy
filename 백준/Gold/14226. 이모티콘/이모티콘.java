import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	public static class EmoticonState {
		int screenEmoticons;
		int clipboardEmoticons;

		public EmoticonState(int screenCount, int clipboardCount) {
			this.screenEmoticons = screenCount;
			this.clipboardEmoticons = clipboardCount;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int S = Integer.parseInt(br.readLine());
		Queue<EmoticonState> queue = new ArrayDeque<>();
		boolean[][] visited = new boolean[1001][1001];
		int time = 0;
		queue.add(new EmoticonState(1, 0));
		visited[1][0] = true;

		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size-- > 0) {
				EmoticonState cur = queue.poll();
				if (cur.screenEmoticons == S) {
					System.out.println(time);
					return;
				}

				if (!visited[cur.screenEmoticons][cur.screenEmoticons]) {
					visited[cur.screenEmoticons][cur.screenEmoticons] = true;
					queue.add(new EmoticonState(cur.screenEmoticons, cur.screenEmoticons));
				}

				if (cur.clipboardEmoticons > 0) {
					int nextScreen = cur.screenEmoticons + cur.clipboardEmoticons;
					if (nextScreen <= 1000 && !visited[nextScreen][cur.clipboardEmoticons]) {
						visited[nextScreen][cur.clipboardEmoticons] = true;
						queue.add(new EmoticonState(nextScreen, cur.clipboardEmoticons));
					}
				}

				if (cur.screenEmoticons > 0) {
					int nextScreen = cur.screenEmoticons - 1;
					if (!visited[nextScreen][cur.clipboardEmoticons]) {
						visited[nextScreen][cur.clipboardEmoticons] = true;
						queue.add(new EmoticonState(nextScreen, cur.clipboardEmoticons));
					}
				}
			}
			time++;
		}
	}

}
