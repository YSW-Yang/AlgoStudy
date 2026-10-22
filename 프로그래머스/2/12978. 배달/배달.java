import java.util.*;
class Solution {
    public class Node implements Comparable<Node>{
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
    
    private final int INF = 100_000_000;
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        List<Node>[] list = new ArrayList[N + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        pq.add(new Node(1, 0));
        dist[1] = 0;
        
        for(int i = 1; i <= N; i++){
            list[i] = new ArrayList<>();
        }
        
        for(int[] r : road){
            int from = r[0];
            int to = r[1];
            int cost = r[2];
            list[from].add(new Node(to, cost));
            list[to].add(new Node(from, cost));
        }
        
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int from = cur.to;
            int cost = cur.cost;
            
            if(dist[from] < cost){
                continue;
            }
            
            for(Node neighbor : list[from]){
                if(dist[neighbor.to] > cost + neighbor.cost){
                    dist[neighbor.to] = cost + neighbor.cost;
                    pq.add(new Node(neighbor.to, dist[neighbor.to]));
                }
            }
        }
        
        for(int cost : dist){
            if(cost <= K){
                answer++;
            }
        }

        return answer;
    }
}