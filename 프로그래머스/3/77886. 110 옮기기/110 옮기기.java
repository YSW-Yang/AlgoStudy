class Solution {
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        
        for(int i = 0; i < s.length; i++){
            StringBuilder sb = new StringBuilder();
            int count110 = 0;
            String str = s[i];
            
            for(int j = 0; j < str.length(); j++){
                sb.append(str.charAt(j));
                
                if(sb.length() >= 3 && sb.charAt(sb.length() - 3) == '1' && sb.charAt(sb.length() - 2) == '1' && sb.charAt(sb.length() - 1) == '0'){
                    sb.delete(sb.length() - 3, sb.length());
                    count110++;
                }
            }
            
            int lastZeroIndex = -1;
            for(int j = sb.length() - 1; j >= 0; j--){
                if(sb.charAt(j) == '0'){
                    lastZeroIndex = j;
                    break;
                }
            }
            
            StringBuilder result = new StringBuilder();
            if(lastZeroIndex == -1){
                for(int j = 0; j < count110; j++){
                    result.append("110");
                }
                result.append(sb);
            }else{
                result.append(sb.substring(0, lastZeroIndex + 1));
                for(int j = 0; j < count110; j++){
                    result.append("110");
                }
                result.append(sb.substring(lastZeroIndex + 1));
            }
            
            answer[i] = result.toString();
        }
        
        return answer;
    }
}