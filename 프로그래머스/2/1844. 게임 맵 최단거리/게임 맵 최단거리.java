import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        queue.add(new int[] {0, 0});
        visited[0][0] = true;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            answer++;
            while(size-- > 0){
                int[] cur = queue.poll();
                int row = cur[0];
                int col = cur[1];
                
                if(row == n - 1 && col == m - 1){
                    return answer;
                }
                
                for(int[] direction : directions){
                    int newRow = row + direction[0];
                    int newCol = col + direction[1];
                    
                    if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && !visited[newRow][newCol] && maps[newRow][newCol] == 1){
                        queue.add(new int[] {newRow, newCol});
                        visited[newRow][newCol] = true;
                    }
                }
            }
        }
        
        return -1;
    }
}