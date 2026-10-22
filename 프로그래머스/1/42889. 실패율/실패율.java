import java.util.*;
class Solution {
    class FailRate implements Comparable<FailRate>{
        int stage;
        float failRate;
        
        public FailRate(int stage, float failRate){
            this.stage = stage;
            this.failRate = failRate;
        }
        
        @Override
        public int compareTo(FailRate other){
            if(this.failRate == other.failRate){
                return this.stage - other.stage;
            }
            return Float.compare(other.failRate, this.failRate);
        }
    }
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] currentStage = new int[N + 2];
        int totalUser = stages.length;
        FailRate[] failRates = new FailRate[N];
        
        for(int stage : stages){
            currentStage[stage]++;
        }
        
        
        for(int i = 0; i < N; i++){
            int challengers = currentStage[i + 1];
            if(totalUser == 0){
                failRates[i] = new FailRate(i + 1, 0);
            }else{
                failRates[i] = new FailRate(i + 1, (float) challengers / totalUser);
                totalUser -= challengers;
            }
        }
        Arrays.sort(failRates);
        
        for(int i = 0; i < N; i++){
            answer[i] = failRates[i].stage;
        }
        return answer;
    }
}