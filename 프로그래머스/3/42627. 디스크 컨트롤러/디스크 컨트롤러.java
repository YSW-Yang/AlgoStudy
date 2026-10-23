import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        Arrays.sort(jobs, (o1, o2) -> Integer.compare(o1[0], o2[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
        
        int time = 0;
        int index = 0;
        int count = 0;
        int n = jobs.length;
        
        while(count < n){
            while(index < n && time >= jobs[index][0]){
                pq.add(jobs[index]);
                index++;
            }
            
            if(pq.isEmpty()){
                time = jobs[index][0];
            }else{
                int[] job = pq.poll();
                time += job[1];
                answer += time - job[0];
                count++;
            }
        }
        
        return answer/n;
    }
}