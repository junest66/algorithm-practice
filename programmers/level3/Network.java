import java.util.*;

class Solution {
    static boolean[] visited;
    static List<Integer>[] adjList;

    public int solution(int n, int[][] computers) {
        adjList = new ArrayList[n];
        for(int i = 0; i < n ; i++) {
            adjList[i] = new ArrayList<>();
        }

        for(int i = 0; i < computers.length; i++) {
            for(int j = 0; j < computers[i].length; j++) {
                if(i != j && computers[i][j] == 1) {
                    adjList[i].add(j);
                }
            }
        }
        visited = new boolean[n];
        int answer = 0;
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                bfs(i);
                answer++;
            }
        }
        return answer;
    }

    private void bfs(int i) {
        Deque<Integer> que = new ArrayDeque<>();
        visited[i] = true;
        que.offer(i);
        while(!que.isEmpty()) {
            Integer current = que.poll();
            for(Integer next : adjList[current]) {
                if(!visited[next]) {
                    que.offer(next);
                    visited[next] = true;
                }
            }
        }
    }
}
