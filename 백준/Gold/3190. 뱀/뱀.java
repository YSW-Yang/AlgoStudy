import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	public static class Command {
		int time;
		String command;

		public Command(int time, String command) {
			this.time = time;
			this.command = command;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N + 1][N + 1];
		ArrayDeque<Integer[]> queue = new ArrayDeque<>();
		queue.add(new Integer[] { 1, 1 });
		map[1][1] = 1;
		int direction = 1;
		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };

		int K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			map[row][col] = 3;
		}

		int L = Integer.parseInt(br.readLine());
		Command[] commands = new Command[L];
		for (int i = 0; i < L; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			String c = st.nextToken();
			commands[i] = new Command(t, c);
		}

		int time = 0;
		int index = 0;
		while (true) {
			time++;
			int nextRow = queue.peekLast()[0] + dr[direction];
			int nextCol = queue.peekLast()[1] + dc[direction];

			if (nextRow > 0 && nextRow <= N && nextCol > 0 && nextCol <= N && map[nextRow][nextCol] != 1) {
				queue.add(new Integer[] { nextRow, nextCol });

				if (map[nextRow][nextCol] != 3) {
					Integer[] tail = queue.pollFirst();
					map[tail[0]][tail[1]] = 0;
				}

				map[nextRow][nextCol] = 1;
			} else {
				break;
			}

			if (index < L && time == commands[index].time) {
				if (commands[index].command.equals("D")) {
					direction = (direction + 1) % 4;
				} else {
					direction = (direction + 3) % 4;
				}
				index++;
			}
		}

		System.out.println(time);
	}
}