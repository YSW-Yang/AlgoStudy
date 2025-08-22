// 이거 왜 시간초과 안나냐 ㅋㅋㅋ 나중에 stack으로 다시 풀어보자
import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        for(int i = 0; i < prices.length; i++){
            int time = 0;
            for(int j = i + 1; j < prices.length; j++){
                time++;
                if(prices[i] > prices[j] || j == prices.length - 1){
                    answer[i] = time;
                    break;
                }
            }
        }
        
        return answer;
    }
}