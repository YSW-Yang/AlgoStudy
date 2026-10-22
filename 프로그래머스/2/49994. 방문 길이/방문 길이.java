
import java.util.*;
class Solution {
    public int solution(String dirs) {
        int answer = 0;
        HashMap<Character, int[]> directions = new HashMap<>();
        directions.put('U', new int[] {-1, 0});
        directions.put('D', new int[] {1, 0});
        directions.put('R', new int[] {0, 1});
        directions.put('L', new int[] {0, -1});
        
        HashSet<String> path = new HashSet<>();
        int row = 0;
        int col = 0;
        for(int i = 0; i < dirs.length(); i++){
            int[] direction = directions.get(dirs.charAt(i));
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            
            if(newRow <= 5 && newRow >= -5 && newCol <= 5 && newCol >= -5){
                path.add(row + " " + col + " " + newRow + " " + newCol);
                path.add(newRow + " " + newCol + " " + row + " " + col);
                row = newRow;
                col = newCol;
            }
        }
        answer = path.size()/2;
        
        return answer;
    }
}