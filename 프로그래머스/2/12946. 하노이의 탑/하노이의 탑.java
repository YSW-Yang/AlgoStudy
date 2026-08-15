import java.util.*;

class Solution {
    private List<int[]> record;

    public int[][] solution(int n) {
        record = new ArrayList<>();
        hanoi(n, 1, 3, 2);
        
        int[][] answer = new int[record.size()][2];
        for (int i = 0; i < record.size(); i++) {
            answer[i] = record.get(i);
        }
        return answer;
    }

    private void hanoi(int n, int from, int to, int aux) {
        if (n == 1) {
            record.add(new int[]{from, to});
            return;
        }
        hanoi(n - 1, from, aux, to);
        record.add(new int[]{from, to});
        hanoi(n - 1, aux, to, from);
    }
}