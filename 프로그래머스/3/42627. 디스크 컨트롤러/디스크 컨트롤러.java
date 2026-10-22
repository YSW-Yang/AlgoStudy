import java.util.*;
class Solution {
    class Info implements Comparable<Info>{
        int num;
        int requestTime;
        int requiredTime;
        
        public Info(int num, int requestTime, int requiredTime){
            this.num = num;
            this.requestTime = requestTime;
            this. requiredTime = requiredTime;
        }
        
        @Override
        public int compareTo(Info other){
            if(this.requiredTime == other.requiredTime){
                if(this.requestTime == other.requestTime){
                    return Integer.compare(this.num, other.num);
                }
                
                return Integer.compare(this.requestTime, other.requestTime);
            }
            
            return Integer.compare(this.requiredTime, other.requiredTime);
        }
    }
    
    class Command implements Comparable<Command>{
        int num;
        int requestTime;
        int requiredTime;
        
        public Command(int num, int requestTime, int requiredTime){
            this.num = num;
            this.requestTime = requestTime;
            this.requiredTime = requiredTime;
        }
        
        @Override
        public int compareTo(Command other){
            return Integer.compare(this.requestTime, other.requestTime);
        }
    }
    
    public int solution(int[][] jobs) {
        int answer = 0;
        int n = jobs.length;
        PriorityQueue<Info> pq = new PriorityQueue<>();
        PriorityQueue<Command> commands = new PriorityQueue<>();
        Stack<int[]> stack = new Stack<>();
        
        for(int i = 0; i < n; i++){
            commands.add(new Command(i, jobs[i][0], jobs[i][1]));
        }
        
        int time = 0;
        while(stack.size() + pq.size() + commands.size() >= 1){
            while(!commands.isEmpty() && commands.peek().requestTime <= time){
                Command command = commands.poll();
                pq.add(new Info(command.num, command.requestTime, command.requiredTime));
            }
            
            if(!stack.isEmpty()){
                if(stack.peek()[1] <= time){
                    stack.pop();
                }
            }
            
            if(stack.isEmpty() && !pq.isEmpty()){
                Info job = pq.poll();
                stack.push(new int[] {time, time + job.requiredTime});
                answer += time + job.requiredTime - job.requestTime;
            } 
            
            time++;
        }
        
        return answer/n;
    }
}