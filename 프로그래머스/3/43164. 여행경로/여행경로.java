import java.util.*;

class Solution {
    boolean[] visited;
    List<String> answer;
    List<String> path;

    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        answer = new ArrayList<>();
        path = new ArrayList<>();

        // 티켓을 사전순으로 정렬
        Arrays.sort(tickets, (a, b) -> a[1].compareTo(b[1]));

        // DFS 시작 (항상 ICN 출발)
        dfs("ICN", "ICN", tickets, 0);

        // 사전순으로 정렬된 경로 중 첫 번째 반환
        return answer.get(0).split(" ");
    }

    public void dfs(String current, String route, String[][] tickets, int count) {
        if (count == tickets.length) {
            answer.add(route);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(current)) {
                visited[i] = true;
                dfs(tickets[i][1], route + " " + tickets[i][1], tickets, count + 1);
                visited[i] = false; // 백트래킹
            }
        }
    }
}
