import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
        int pType = nums.length / 2;
        
        for(int i = 0; i < nums.length; i++){
            hashmap.put(nums[i], 1);
        }
        
        if(pType < hashmap.size()){
            answer = pType;
        }else{
            answer = hashmap.size();
        }
        
        return answer;
    }
}