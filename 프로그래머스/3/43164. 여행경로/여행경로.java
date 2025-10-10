import java.util.*;

class Solution {
    public List<String> route;
    public boolean[] visited;
    public List<String[]> routeList;
    
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        routeList = new ArrayList<>();
        route = new ArrayList<>();

        Arrays.sort(tickets, (a, b) -> {
            if (a[0].equals(b[0])) {
                return a[1].compareTo(b[1]);
            }
            return a[0].compareTo(b[0]);
        });

        route.add("ICN");
        dfs("ICN", 0, tickets.length, tickets);
        // 사전순 정렬
        Collections.sort(routeList, (a, b) -> {
            for (int i = 0; i < a.length; i++) {
                int cmp = a[i].compareTo(b[i]);
                if (cmp != 0) return cmp;
            }
            return 0;
        });

        return routeList.get(0);
    }

    private void dfs(String target, int count, int ticketsLength, String[][] tickets) {
        if (count == ticketsLength) {
            routeList.add(route.toArray(new String[0]));
            return;
        }

        for (int i = 0; i < ticketsLength; i++) {
            if (!visited[i] && tickets[i][0].equals(target)) {
                visited[i] = true;
                route.add(tickets[i][1]);
                dfs(tickets[i][1], count + 1, tickets.length, tickets);
                visited[i] = false;
                route.remove(route.size() - 1); // backtrack
            }
        }
    }
}
