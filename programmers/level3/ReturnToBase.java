import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        // destination 에서 각 위치까지의 최단경로
        List<Integer>[] graph = new ArrayList[n+1];
        for(int i = 0;  i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int[] x : roads) {
            graph[x[0]].add(x[1]);
            graph[x[1]].add(x[0]);
        }

        int[] dist = new int[n+1];
        Arrays.fill(dist, -1);
        dist[destination] = 0;

        Deque<Integer> que = new ArrayDeque<>();
        que.offer(destination);

        while(!que.isEmpty()) {
            int current = que.poll();

            for(int next : graph[current]) {
                if(dist[next] == -1) {
                    dist[next] = dist[current] + 1;
                    que.offer(next);
                }
            }
        }

        int[] answer = new int[sources.length];
        for (int i = 0; i < sources.length; i++) {
            answer[i] = dist[sources[i]];
        }
        return answer;
    }
}
