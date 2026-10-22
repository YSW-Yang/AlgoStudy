import java.util.*;
class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = -1;
        int[][] map = new int[101][101];
        boolean[][] visited = new boolean[101][101];
        Queue<int[]> queue = new ArrayDeque<>();
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        characterX *= 2;
        characterY *= 2;
        itemX *= 2;
        itemY *= 2;
        queue.add(new int[] {characterX, characterY, 0});
        visited[characterY][characterX] = true;
        
        for(int[] point : rectangle){
            int x1 = point[0] * 2;
            int y1 = point[1] * 2;
            int x2 = point[2] * 2;
            int y2 = point[3] * 2;
            
            for(int i = x1; i <= x2; i++){
                for(int j = y1; j <= y2; j++){
                    map[j][i] = 1;
                }
            }
        }
        
        for(int[] point : rectangle){
            int x1 = point[0] * 2;
            int y1 = point[1] * 2;
            int x2 = point[2] * 2;
            int y2 = point[3] * 2;
            
            for(int i = x1 + 1; i < x2; i++){
                for(int j = y1 + 1; j < y2; j++){
                    map[j][i] = 0;
                }
            }
        }
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int count = cur[2];
            
            if(x == itemX && y == itemY){
                return count / 2;
            }
            
            for(int[] direction : directions){
                int nextY = y + direction[0];
                int nextX = x + direction[1];
                
                if(nextX >= 0 && nextX <= 100 && nextY >= 0 && nextY <= 100 && !visited[nextY][nextX] && map[nextY][nextX] == 1){
                    queue.add(new int[] {nextX, nextY, count + 1});
                    visited[nextY][nextX] = true;
                }
            }
        }
        
        return answer;
    }
}