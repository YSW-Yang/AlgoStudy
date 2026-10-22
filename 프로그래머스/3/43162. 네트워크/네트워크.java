import java.util.*;
class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new ArrayDeque<>();
        
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                answer++;
                queue.add(i);
                visited[i] = true;
                while(!queue.isEmpty()){
                    int cur = queue.poll();
                    
                    for(int j = 0; j < n; j++){
                        if(!visited[j] && computers[cur][j] == 1){
                            queue.add(j);
                            visited[j] = true;
                        }
                    }
                }
            }
        }
        
        return answer;
    }
}