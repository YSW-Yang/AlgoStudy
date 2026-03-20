import java.util.*;
class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        
        Arrays.sort(rocks);
        
        int left = 1;
        int right = distance;
        while(left <= right) {
            int mid = (left + right) / 2;
            int removeCount = 0;
            int previewRock = 0;
            for(int i = 0; i < rocks.length; i++) {
                if(rocks[i] - previewRock < mid) {
                    removeCount++;
                }else {
                    previewRock = rocks[i];
                }
            }

            if (distance - previewRock < mid) {
                removeCount++;
            }
            
            if (removeCount <= n) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return answer;
    }
}