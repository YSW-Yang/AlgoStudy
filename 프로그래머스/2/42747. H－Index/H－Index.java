import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        int count = citations.length;
        for(int i = 0; i < citations.length; i++){
            if(citations[i] > 0){
                if(count >= citations[i]){
                    answer = citations[i];
                }else{
                    if(count > answer){
                        answer = count;
                    }
                }
            }
            count--;
        }
        
        return answer;
    }
}