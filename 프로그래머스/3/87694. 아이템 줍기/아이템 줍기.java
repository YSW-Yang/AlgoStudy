import java.util.*;

class Location{
    int y;
    int x; 
    Location(int y, int x){
        this.y = y;
        this.x = x;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Location location = (Location) obj;
        return y == location.y && x == location.x;
    }

    @Override
    public int hashCode() {
        return Objects.hash(y, x);
    }
}

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        boolean[][] borderLines = new boolean[101][101];
        boolean[][] visited = new boolean[101][101];
        Set<Location> area = new HashSet<>();
        Queue<Location> locations = new ArrayDeque<>();
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        
        for(int i = 0; i < rectangle.length; i++){
            int x1 = rectangle[i][0] * 2;
            int y1 = rectangle[i][1] * 2;
            int x2 = rectangle[i][2] * 2;
            int y2 = rectangle[i][3] * 2;
            
            for(int j = x1 + 1; j < x2; j++){
                for(int k = y1 + 1; k < y2; k++){
                    area.add(new Location(k, j));
                }
            }
        }
        
        for(int i = 0; i < rectangle.length; i++){
            int x1 = rectangle[i][0] * 2;
            int y1 = rectangle[i][1] * 2;
            int x2 = rectangle[i][2] * 2;
            int y2 = rectangle[i][3] * 2;
            
            for(int j = x1; j <= x2; j++){
                if(!area.contains(new Location(y1 , j))){
                    borderLines[y1][j] = true;
                }
                
                if(!area.contains(new Location(y2 , j))){
                    borderLines[y2][j] = true;
                }
            }
            
            for(int j = y1; j <= y2; j++){
                if(!area.contains(new Location(j , x1))){
                    borderLines[j][x1] = true;
                }
                
                if(!area.contains(new Location(j , x2))){
                    borderLines[j][x2] = true;
                }
            }
        }
        
        locations.add(new Location(characterY * 2, characterX * 2));
        visited[characterY * 2][characterX * 2] = true;
        while(!locations.isEmpty()){
            int size = locations.size();
            while(size-- > 0){
                Location currentLocation = locations.poll();
                if(currentLocation.x == itemX * 2 && currentLocation.y == itemY * 2){
                    return answer / 2;
                }
                
                for(int i = 0; i < 4; i++){
                    int newX = currentLocation.x + dx[i];
                    int newY = currentLocation.y + dy[i];
                    if(newX > 0 && newX <= 100 && newY > 0 && newY <= 100 && borderLines[newY][newX] && !visited[newY][newX]){
                        locations.add(new Location(newY, newX));
                        visited[newY][newX] = true;
                    }
                }
            }
            answer++;
        }
        return answer;
    }
}