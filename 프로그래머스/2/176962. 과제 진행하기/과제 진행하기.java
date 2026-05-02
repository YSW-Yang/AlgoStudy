import java.util.*;

class Solution {
    class Info {
        String name;
        int time;
        int remainPlay;
        
        public Info(String name, int time, int remainPlay){
            this.name = name;
            this.time = time;
            this.remainPlay = remainPlay;
        }
    }
    
    public String[] solution(String[][] plans) {
        
        int N = plans.length;
        String[] answer = new String[N];
        Stack<Info> stack = new Stack<>();
        
        Arrays.sort(plans, (a, b) -> {
            return a[1].compareTo(b[1]);
        });
        
        String[] times = plans[0][1].split(":");
        int startTime = Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
        
        int index = 0;
        for(String[] sArr: plans){
            String name = sArr[0];
            times = sArr[1].split(":");
            int time = Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
            int remainPlay =  Integer.parseInt(sArr[2]);
            
            while(!stack.isEmpty() && startTime < time){
                Info cur = stack.pop();
                int playTime = time - startTime;
                
                if(playTime >= cur.remainPlay){
                    answer[index++] = cur.name;
                    startTime += cur.remainPlay;
                }else {
                    stack.push(new Info(cur.name, time, cur.remainPlay - playTime));
                    startTime = time; 
                }
            }
            
            stack.push(new Info(name, time, remainPlay));
            startTime = time;
        }
        
        while(!stack.isEmpty()){
            Info cur = stack.pop();
            answer[index++] = cur.name;
        }
        
        return answer;
    }
}