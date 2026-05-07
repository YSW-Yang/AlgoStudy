class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        s = s.toLowerCase();
        String[] arr = s.split(" ");
        
        for(String word: arr){
            if(word.equals("")){
                sb.append(" ");
            }else{
                sb.append(word.substring(0, 1).toUpperCase()).append(word.substring(1)).append(" ");
            }
        }
        
        return sb.toString().substring(0, s.length());
    }
}