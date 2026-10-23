import java.util.*;
class Solution {
    int[] parent;
    
    public int find(int x){
        if(x == parent[x]){
            return x;
        }
        
        parent[x] = find(parent[x]);
        return parent[x];
    }
    
    public boolean union(int a, int b){
        int pa = find(a);
        int pb = find(b);
        
        if(pa != pb){
            parent[pb] = pa;
            return true;
        }
        
        return false;
    }
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        Arrays.sort(costs, (o1, o2) -> Integer.compare(o1[2], o2[2]));
        parent = new int[n + 1];
        for(int i = 1; i <= n; i++){
            parent[i] = i;
        }
        
        int count = 0;
        for(int[] edge : costs){
            int from = edge[0];
            int to = edge[1];
            int cost = edge[2];
            
            if(union(from, to)){
                answer += cost;
                count++;
            }
            
            if(count == n - 1){
                break;
            }
        }
        
        return answer;
    }
}