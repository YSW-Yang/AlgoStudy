import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Integer[] sortPriorities = new Integer[priorities.length];
        Queue<Integer> executeQueue = new ArrayDeque<Integer>();
        Queue<Integer> ImportantQueue = new ArrayDeque<Integer>();
        
        for(int i = 0; i < priorities.length; i++){
            sortPriorities[i] = priorities[i];
            executeQueue.offer(priorities[i]);
        }
        
        Arrays.sort(sortPriorities, Comparator.reverseOrder());
        for(int i = 0; i < priorities.length; i++){
            ImportantQueue.add(sortPriorities[i]);
        }
        
        while(!ImportantQueue.isEmpty()){
            
            if(executeQueue.peek() == ImportantQueue.peek()){
                ImportantQueue.poll();
                executeQueue.poll();
                answer++;
                if(location == 0){
                    break;
                }
                location--;
            }else{
                int temp = executeQueue.poll();
                executeQueue.add(temp);
                if(location == 0){
                    location = executeQueue.size() - 1;
                }else{
                    location--;
                }
            }
        }
        
        
        return answer;
    }
}