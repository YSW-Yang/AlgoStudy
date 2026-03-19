import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] students = new int[n + 1];
        Arrays.fill(students, 1);
        Arrays.sort(lost);
        
        for(int r : reserve){
            students[r]++;
        }
        
        for(int l : lost){
            students[l]--;
        }
        
        for(int i = 0; i < lost.length; i++){
            if(students[lost[i]] == 0){
                if(lost[i] - 1 >= 1 && students[lost[i] - 1] >= 2){
                    students[lost[i]]++;
                    students[lost[i] - 1]--;
                }else if(lost[i] + 1 <= n && students[lost[i] + 1] >= 2){
                    students[lost[i]]++;
                    students[lost[i] + 1]--;
                }
            }
        }
        
        for(int i = 1; i <= n; i++){
            if(students[i] >= 1){
                answer++;
            }
        }
        
        
        return answer;
    }
}