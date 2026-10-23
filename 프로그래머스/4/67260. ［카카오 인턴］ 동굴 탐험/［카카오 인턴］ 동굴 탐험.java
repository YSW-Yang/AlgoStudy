import java.util.*;
class Solution {
    public boolean solution(int n, int[][] path, int[][] order) {
        boolean answer = true;
        List<List<Integer>> tree = new ArrayList<>();
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[n];
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n];
        
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
            tree.add(new ArrayList<>());
        }
        
        for(int[] p : path){
            int u = p[0];
            int v = p[1];
            tree.get(u).add(v);
            tree.get(v).add(u);
        }
        
        queue.add(0);
        visited[0] = true;
        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int v : tree.get(cur)){
                if(!visited[v]){
                    queue.add(v);
                    visited[v] = true;
                    graph.get(cur).add(v);
                    inDegree[v]++;
                }
            }
        }
        
        for(int[] o : order){
            int u = o[0];
            int v = o[1];
            graph.get(u).add(v);
            inDegree[v]++;
        }
        
        for(int i = 0; i < n; i++){
            if(inDegree[i] == 0){
                queue.add(i);
            }
        }
        
        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int v : graph.get(cur)){
                inDegree[v]--;
                if(inDegree[v] == 0){
                    queue.add(v);
                }
            }
        }
        
        for(int[] o : order){
            int v = o[1];
            if(inDegree[v] != 0){
                return false;
            }
        }
        
        return answer;
    }
}