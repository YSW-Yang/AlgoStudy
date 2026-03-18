import java.util.*;
class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = -1;
        int[][] map = new int[101][101];
        Queue<Integer[]> queue = new ArrayDeque<>();
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        boolean visited[][] = new boolean[101][101];
        
        for(int[] rec : rectangle){
            int x1 = rec[0] * 2;
            int y1 = rec[1] * 2;
            int x2 = rec[2] * 2;
            int y2 = rec[3] * 2;
            
            for(int i = x1; i <= x2; i++) {
                for(int j = y1; j <= y2; j++) {
                    map[i][j] = 1;
                }
            }
        }
        
        for(int[] rec : rectangle){
            int x1 = rec[0] * 2;
            int y1 = rec[1] * 2;
            int x2 = rec[2] * 2;
            int y2 = rec[3] * 2;
            
            for(int i = x1 + 1; i < x2; i++) {
                for(int j = y1 + 1; j < y2; j++) {
                    map[i][j] = 0;
                }
            }
        }
        
        queue.add(new Integer[]{characterX*2, characterY*2});
        visited[characterX*2][characterY*2] = true;
        
        while(!queue.isEmpty()){
            answer++;
            int size = queue.size();
            while(size-- > 0){
                Integer[] currentPoint = queue.poll();
                int currentRow = currentPoint[0];
                int currentCol = currentPoint[1];
                
                if(currentRow == itemX*2 && currentCol == itemY*2){
                    answer /= 2; 
                    return answer;
                }
                
                for(int i = 0; i < 4; i++){
                    int nextRow = currentRow + directions[i][0];
                    int nextCol = currentCol + directions[i][1];
                    
                    if(nextRow >= 0 && nextRow <= 100 && nextCol >= 0 && nextCol <= 100 && !visited[nextRow][nextCol] && map[nextRow][nextCol] == 1){
                        queue.add(new Integer[]{nextRow, nextCol});
                        visited[nextRow][nextCol] = true;
                    }
                }
            }
        }
        
        return answer;
    }
}