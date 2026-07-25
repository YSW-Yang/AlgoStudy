import java.util.*;
class Solution {
    public int solution(String message, int[][] spoiler_ranges) {
        int answer = 0;
        Set<String> spoilerWord = new HashSet<>();
        Set<String> nonSpoilerWord = new HashSet<>();
        
        int curIndex = 0;
        String[] messageWordArr = message.split(" ");
        for(String word : messageWordArr){
            int start = curIndex;
            int end = start + word.length() - 1;
            curIndex = end + 2;
            
            boolean isSpoiler = false;
            for(int[] range : spoiler_ranges){
                if(start <= range[1] && end >= range[0]){
                    spoilerWord.add(word);
                    isSpoiler = true;
                    break;
                }
            }
            
            if(!isSpoiler){
                nonSpoilerWord.add(word);
            }
        }
        
        for(String word : spoilerWord){
            if(!nonSpoilerWord.contains(word)){
                answer++;
            }
        }
        
        return answer;
    }
}