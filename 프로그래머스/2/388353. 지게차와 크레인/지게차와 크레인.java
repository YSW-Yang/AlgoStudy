import java.util.*;
class Solution {
    public boolean[][] storageMap;
    public int n;
    public int m;
    
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        n = storage.length;
        m = storage[0].length();
        storageMap = new boolean[n][m];
        answer = n*m;
        
        for(String request : requests){
            List<int[]> list = new ArrayList<>();
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(request.length() == 1){
                        if(request.charAt(0) == storage[i].charAt(j) && !storageMap[i][j]){
                            if(bfs(i,j)){
                                list.add(new int[] {i, j});
                            }
                        }
                    }else{
                        if(request.charAt(0) == storage[i].charAt(j) && !storageMap[i][j]){
                            storageMap[i][j] = true;
                            answer--;
                        }
                    }
                }
            }
            
            for(int[] point : list){
                storageMap[point[0]][point[1]] = true;
                answer--;
            }
        }
        return answer;
    }
    
    public boolean bfs(int row, int col){
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        queue.add(new int[] {row, col});
        visited[row][col] = true;
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            for(int[] direction : directions){
                int newRow = cur[0] + direction[0];
                int newCol = cur[1] + direction[1];
                
                if(newRow < 0 || newRow >= n || newCol < 0 || newCol >= m){
                    return true;
                }else if(storageMap[newRow][newCol] && !visited[newRow][newCol]){
                    queue.add(new int[] {newRow, newCol});
                    visited[newRow][newCol] = true;
                }
            }
        }
        
        return false;
    }
}