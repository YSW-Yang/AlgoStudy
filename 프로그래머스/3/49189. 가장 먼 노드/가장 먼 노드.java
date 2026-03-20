import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        ArrayList<Integer>[] edgeList = new ArrayList[n + 1];
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new ArrayDeque<>();
        
        for(int i = 1; i <= n; i++) {
            edgeList[i] =  new ArrayList<>();
        }
        
        for(int[] node : edge) {
            edgeList[node[0]].add(node[1]);
            edgeList[node[1]].add(node[0]);
        }
        queue.add(1);
        visited[1] = true;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            answer = size;
            
            while(size-- > 0){
                int start = queue.poll();
                
                for(int node : edgeList[start]){
                    if(!visited[node]){
                        queue.add(node);
                        visited[node] = true;
                    }
                }
            }
        }
        
        return answer;
    }
}