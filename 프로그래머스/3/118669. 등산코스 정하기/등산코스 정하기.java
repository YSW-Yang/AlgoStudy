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
            return Integer.compare(this.cost, other.cost);
        }
    }
    
    public List<Node>[] adj;
    public final int INF = Integer.MAX_VALUE;
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = new int[2];
        adj = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++){
            adj[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < paths.length ; i++){
            int from = paths[i][0];
            int to = paths[i][1];
            int cost = paths[i][2];
            
            adj[from].add(new Node(to, cost));
            adj[to].add(new Node(from, cost));
        }
        
        boolean[] isSummit = new boolean[n + 1];
        for (int summit : summits) {
            isSummit[summit] = true;
        }

        boolean[] isGate = new boolean[n + 1];
        for (int gate : gates) {
            isGate[gate] = true;
        }
        
        int intensity = Integer.MAX_VALUE;
        Arrays.sort(summits);
        int[] intensitys = dijkstra(gates, n, isGate, isSummit);
            
        for(int summit : summits){
            if(intensity > intensitys[summit]){
                intensity = intensitys[summit];
                answer[0] = summit;
                answer[1] = intensity;
            }
        }
        
        return answer;
    }
    
    public int[] dijkstra(int[] gates, int n, boolean[] isGate, boolean[] isSummit){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] intensitys = new int[n + 1];
        Arrays.fill(intensitys, INF);
        
        for(int gate : gates){
            pq.add(new Node(gate, 0));
            intensitys[gate] = 0;
        }
        
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            
            if(intensitys[cur.to] < cur.cost){
                continue;
            }
            
            if (isSummit[cur.to]) {
                continue;
            }
            
            for(Node next : adj[cur.to]){
                int nextIntensity = Math.max(cur.cost, next.cost);
                
                if (isGate[next.to]) {
                    continue;
                }
                
                if(intensitys[next.to] > nextIntensity){
                    intensitys[next.to] = nextIntensity;
                    pq.add(new Node(next.to, intensitys[next.to]));
                }
            }
        }
        
        return intensitys;
    }
}