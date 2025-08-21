import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        // .sort 문자열을 정렬하면 사전순으로 정렬된다. 예) 119 12 114 181 223 >> 114 119 12 181 223
        Arrays.sort(phone_book);
        
        for(int i = 0; i < phone_book.length - 1; i++){
            if(phone_book[i + 1].indexOf(phone_book[i]) == 0){
                answer = false;
                break;
            }
        }
        
        return answer;
    }
}