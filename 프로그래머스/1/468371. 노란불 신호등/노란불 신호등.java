class Solution {
    public int solution(int[][] signals) {
        int answer = -1;
        int len = 1;
        for(int[] signal : signals){
            int g = signal[0];
            int y = signal[1];
            int r = signal[2];
            
            len *= (g + y + r);
        }
        
        int[] arr = new int[len + 1];
        for(int[] signal : signals){
            int g = signal[0];
            int y = signal[1];
            int r = signal[2];
            
            int offset = g + y + r;
            for(int i = 1; i <= len; i += offset){
                for(int j = 0; j < y; j++){
                    arr[g + i + j]++;
                }
            }
        }
        
        for(int i = 1; i <= len; i++){
            if(arr[i] == signals.length){
                return i;
            }
        }
        
        return answer;
    }
}