import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(arr[0]);
        int index = 0;
        for(int i = 1; i < arr.length; i++){
            if(result.get(index) != arr[i]){
                result.add(arr[i]);
                index++;
            }
        }
        
        answer = new int[result.size()];
        for(int i = 0; i < result.size(); i++){
            answer[i] = result.get(i);
        }

        return answer;
    }
}