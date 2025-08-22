import java.util.*;
class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        
        queue.offer(new int[] {0, 0}); // 1번째는 합계, 2번째는 시작 인덱스
        
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int currentSum = current[0];
            int currentIndex = current[1];
            
            if(currentIndex == numbers.length){
                if(currentSum == target){
                    answer++;
                }
                continue;
            }
            
            //더하기
            queue.offer(new int[] {currentSum + numbers[currentIndex], currentIndex + 1}); ;
            
            //빼기
            queue.offer(new int[] {currentSum - numbers[currentIndex], currentIndex + 1}); 
        }
        
        return answer;
    }
}