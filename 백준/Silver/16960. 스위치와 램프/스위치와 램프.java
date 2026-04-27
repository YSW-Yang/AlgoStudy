import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] lamps = new int[M + 1];
		List<Integer>[] buttons = new ArrayList[N + 1];
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new ArrayList<>();
		}
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int size = Integer.parseInt(st.nextToken());
			for (int j = 1; j <= size; j++) {
				int lamp = Integer.parseInt(st.nextToken());
				buttons[i].add(lamp);
				lamps[lamp]++;
			}
		}
		
		for (int i = 1; i <= N; i++) {
			boolean canRemove = true;
			for(int lamp :buttons[i]) {
				if(lamps[lamp]-1 == 0) {
					canRemove = false;
				}
			}
			
			if(canRemove) {
				System.out.println(1);
				return;
			}
		}
		
		System.out.println(0);
	}
}
