import java.util.*;
class Solution {
    public static class Node implements Comparable<Node>{
        int to;
        int cost;
        
        public Node(int to, int cost){
            this.to = to;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Node other){
            return this.cost - other.cost;
        }
    }
    
    public final int INF = 20_000_000;
    public List<Node>[] adj;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        adj = new ArrayList[n + 1];
        
        for(int i = 1; i <= n; i++){
            adj[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < fares.length; i++){
            int from = fares[i][0];
            int to = fares[i][1];
            int cost = fares[i][2];
            adj[from].add(new Node(to, cost));
            adj[to].add(new Node(from, cost));
        }
        
        int[] distS = dijkstra(s, n);
        int[] distA = dijkstra(a, n);
        int[] distB = dijkstra(b, n);
        for(int i = 1; i <= n; i++){
            answer = Math.min(answer, distS[i] + distA[i] + distB[i]);
        }
        
        return answer;
    }
    
    public int[] dijkstra(int start, int n){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            
            if(dist[cur.to] < cur.cost){
                continue;
            }
            
            for(Node next : adj[cur.to]){
                if(dist[next.to] > dist[cur.to] + next.cost){
                    dist[next.to] = dist[cur.to] + next.cost;
                    pq.add(new Node(next.to, dist[next.to]));
                }
            }
        }
        
        return dist;
    }
}