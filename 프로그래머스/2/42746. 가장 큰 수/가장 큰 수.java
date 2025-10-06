import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        Integer[] copyNumbers = new Integer[numbers.length];
        for(int i = 0; i < numbers.length; i++){
            copyNumbers[i] = numbers[i];
        }

        Arrays.sort(copyNumbers, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                String strA = a.toString();
                String strB = b.toString();

                return (strB + strA).compareTo(strA + strB);
            }
        });
        
        if (copyNumbers[0].equals(0)) {
            return "0";
        }

        for (int num : copyNumbers) {
            sb.append(num);
        }
        
        answer = sb.toString();
        
        return answer;
    }
}