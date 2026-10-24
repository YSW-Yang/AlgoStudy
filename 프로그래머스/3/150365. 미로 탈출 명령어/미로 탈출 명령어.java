class Solution {
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        int minDist = Math.abs(r - x) + Math.abs(c - y);
        if(k - minDist < 0 || (k - minDist) % 2 != 0){
            return "impossible";
        }
        
        StringBuilder sb = new StringBuilder();
        int[][] directions = {{1, 0}, {0, -1}, {0, 1}, {-1, 0}};
        char[] move = {'d', 'l', 'r', 'u'};
        
        while(sb.length() < k){
            for(int i = 0; i < 4; i++){
                int nx = x + directions[i][0];
                int ny = y + directions[i][1];
                if(nx < 1 || nx > n || ny < 1 || ny > m){
                    continue;
                }
                minDist = Math.abs(r - nx) + Math.abs(c - ny);
                if(minDist + sb.length() + 1 <= k && (k - (minDist + sb.length() + 1)) % 2 == 0){
                    sb.append(move[i]);
                    x = nx;
                    y = ny;
                    break;
                }
            }
        }
        
        return sb.toString();
    }
}