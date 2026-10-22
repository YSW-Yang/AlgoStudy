import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int sv : scoville){
            pq.add((long) sv);
        }
        
        while(pq.peek() < K){
            if(pq.size() < 2){
                return -1;
            }
            
            long first = pq.poll();
            long second = pq.poll();
            pq.add(first + second * 2);
            answer++;
        }
        
        return answer;
    }
}