import java.util.*;
class Solution {
    public class Edge implements Comparable<Edge>{
    	int from;
    	int to;
    	int cost;
    
    	public Edge(int from, int to, int cost){
    	    this.from = from;
    	    this.to = to;
        	this.cost = cost;
    	}
    
    	@Override
    	public int compareTo(Edge other){
        	return Integer.compare(this.cost, other.cost);
    	}
	}

	public int[] parents;
	public int find(int x){
	    if(parents[x] == x){
    	    return x;
    	}
    
    	return parents[x] = find(parents[x]);
	}

	public boolean union(int a, int b){
    	int pa = find(a);
    	int pb = find(b);
    
    	if(pa != pb){
    	    parents[pb] = pa;
        	return true;
    	}
    
	    return false;
	}
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        parents = new int[n];
        List<Edge> edgeList = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            parents[i] = i;
        }
        
        for(int[] edge : costs){
            int from = edge[0];
            int to = edge[1];
            int cost = edge[2];
            
            edgeList.add(new Edge(from, to, cost));
        }
        Collections.sort(edgeList);
        
        int count = 0;
        for(Edge edge : edgeList){
            if(union(edge.from, edge.to)){
                answer += edge.cost;
                count++;
                
                if(count == n - 1){
                    break;
                }
            }
        }
        
        return answer;
    }
}