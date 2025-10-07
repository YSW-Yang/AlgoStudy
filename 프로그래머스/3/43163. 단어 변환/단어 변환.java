import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        Queue<String> queue = new ArrayDeque<>();
        Set<String> hashset = new HashSet<>();
        queue.add(begin);
        hashset.add(begin);
        
        for(int i = 0; i < words.length; i++){
            if(target.equals(words[i])){
                break;
            }
            if(i == words.length - 1){
                return 0;
            }
        }
        
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                String currentString = queue.poll();
                if(currentString.equals(target)){
                    return answer;
                }
                
                for(int i = 0; i < words.length; i++){
                    if(!hashset.contains(words[i])){
                        int cnt = 0;
                        for(int j = 0; j < begin.length(); j++){
                            if(currentString.charAt(j)!=words[i].charAt(j)){
                                cnt++;
                            }
                        }
                        if(cnt == 1){
                            queue.add(words[i]);
                            hashset.add(words[i]);
                        }
                    }
                }
            }
            answer++;
        }
        
        return 0;
    }
}