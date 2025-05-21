import java.util.*;

class Solution {
    static Map<String, List<Integer>> map = new HashMap<>();
    static String[][] ticketArr;
    static boolean[] visited;
    static String answerStr = "";
    static String[] answer;
    static boolean isAnswer = false;

    public String[] solution(String[][] tickets) {
        ticketArr = tickets;
        visited = new boolean[tickets.length];

        Arrays.sort(tickets, (a, b) -> {
            if (a[0].equals(b[0])) return a[1].compareTo(b[1]);
            return a[0].compareTo(b[0]);
        });
        for(int i = 0; i < tickets.length; i++) {
            map.computeIfAbsent(tickets[i][0], k -> new ArrayList<>()).add(i);
        }
        dfs(0, new ArrayList<>(List.of("ICN")));
        return answer;
    }

    private void dfs(int depth, List<String> list) {
        if(isAnswer) {
            return;
        }
        if(depth == visited.length) {
            isAnswer = true;
            answer = list.toArray(new String[0]);
            return;
        }

        String str = list.get(list.size()-1); //마지막 사용했던 문자
        if(!map.containsKey(str)) {
            return;
        }
        for(Integer x : map.get(str)) {
            if(!visited[x]) {
                visited[x] = true;
                list.add(ticketArr[x][1]);
                dfs(depth + 1, list);
                list.remove(list.size() - 1);
                visited[x] = false;
            }
        }
    }
}
