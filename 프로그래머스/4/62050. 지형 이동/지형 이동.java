import java.util.*;
class Solution {
    
    private int[] parent;
    
    private int find(int x){
        if(x == parent[x]){
            return x;
        }
        
        parent[x] = find(parent[x]);
        return parent[x];
    }
    
    private boolean union(int a, int b){
        int pa = find(a);
        int pb = find(b);
        
        if(pa != pb){
            parent[pb] = pa;
            return true;
        }
        
        return false;
    }
    
    public int solution(int[][] land, int height) {
        int answer = 0;
        int N = land.length;
        int[][] landNode = new int[N][N];
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][N];
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        
        int nodeIndex = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j]){
                    nodeIndex++;
                    queue.add(new int[] {i, j});
                    visited[i][j] = true;
                    
                    while(!queue.isEmpty()){
                        int[] cur = queue.poll();
                        int row = cur[0];
                        int col = cur[1];
                        landNode[row][col] = nodeIndex;
                        
                        for(int[] direction : directions){
                            int newRow = row + direction[0];
                            int newCol = col + direction[1];
                            
                            if(newRow >= 0 && newRow < N && newCol >= 0 && newCol < N && !visited[newRow][newCol] && Math.abs(land[row][col] - land[newRow][newCol]) <= height){
                                queue.add(new int[] {newRow, newCol});
                                visited[newRow][newCol] = true;
                            }
                        }
                    }
                }
            }
        }
        
        parent = new int[nodeIndex + 1];
        for(int i = 1; i <= nodeIndex; i++){
            parent[i] = i;
        }
        
        List<int[]> edgeList = new ArrayList<>();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                for(int[] direction : directions){
                    int newRow = i + direction[0];
                    int newCol = j + direction[1];
                    
                    if(newRow >= 0 && newRow < N && newCol >= 0 && newCol < N && landNode[i][j] != landNode[newRow][newCol]){
                        int from = landNode[i][j];
                        int to = landNode[newRow][newCol];
                        int cost = Math.abs(land[i][j] - land[newRow][newCol]);
                        edgeList.add(new int[] {from, to, cost});
                    }
                }
            }
        }
        Collections.sort(edgeList, (o1, o2) -> Integer.compare(o1[2], o2[2]));
        
        int count = 0;
        for(int[] edge : edgeList){
            if(count == nodeIndex - 1){
                break;
            }
            
            int from = edge[0];
            int to = edge[1];
            int cost = edge[2];
            if(union(from, to)){
                answer += cost;
                count++;
            }
        }
        
        return answer;
    }
}