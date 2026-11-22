import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {0, 0};
        TreeMap<Integer, Integer> treemap = new TreeMap<>();
        
        for(String operation : operations){
            String[] oper = operation.split(" ");
            if(oper[0].equals("I")){
                int num = Integer.parseInt(oper[1]);
                treemap.put(num, treemap.getOrDefault(num, 0) + 1);
            }else{
                if(treemap.isEmpty()){
                   continue;
                }
                
                if(oper[1].equals("1")){
                    int max = treemap.lastKey();
                    if(treemap.get(max) == 1){
                        treemap.remove(max);
                    }else{
                        treemap.put(max, treemap.get(max) - 1);
                    }
                }else if(oper[1].equals("-1")){
                    int min = treemap.firstKey();
                    if(treemap.get(min) == 1){
                        treemap.remove(min);
                    }else{
                        treemap.put(min, treemap.get(min) - 1);
                    }
                }
            }
        }
        if(!treemap.isEmpty()){
            answer[0] = treemap.lastKey();
            answer[1] = treemap.firstKey();
        }
        
        return answer;
    }
}