import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> categoryMap = new HashMap<String, Integer>();
        for(String[] str : clothes){
            String category = str[1];
            categoryMap.put(category, categoryMap.getOrDefault(category, 0) + 1);
        }
        
        for(int count :categoryMap.values()){
            answer *= (count + 1);
        }
        
        return answer - 1;
    }
}