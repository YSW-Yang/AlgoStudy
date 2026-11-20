import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] lectures = new int[N];
		int left = 0;
		int right = 0;
		for(int i = 0; i < N; i++) {
			lectures[i] = Integer.parseInt(st.nextToken());
			left = Math.max(left, lectures[i]);
			right += lectures[i];
		}
		
		int result = right;
		while(left <= right) {
			int mid = left + (right - left)/2;
			int sum = 0;
			int count = 0;
			for(int i = 0; i < N; i++) {
				if(sum == 0) {
					count++;
				}
				
				sum += lectures[i];
				if(sum == mid) {
					sum = 0;
				}else if(sum > mid) {
					sum = lectures[i];
					count++;
				}
				
				if(count > M) {
					break;
				}
			}
			
			if(count <= M) {
				result = mid;
				right = mid - 1;
			}else {
				left = mid + 1;
			}
		}
		
		System.out.println(result);
	}
}