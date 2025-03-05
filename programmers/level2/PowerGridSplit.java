import java.util.*;

class Solution {
    static List<Integer>[] adjList;
    static boolean[] visited;
    static int count;
    static int current, ban;
    static int answer = Integer.MAX_VALUE;

    public int solution(int n, int[][] wires) {
        adjList = new ArrayList[n+1]; //1
        visited = new boolean[n+1];
        for(int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for(int[] x : wires) {
            adjList[x[0]].add(x[1]);
            adjList[x[1]].add(x[0]);
        }

        for(int[] x : wires) {
            func(x[0], x[1]);
        }

        return answer;
    }

    private void func(int x, int y) {
        current = x;
        ban = y;
        count = 0;
        int a = dfs(x);
        Arrays.fill(visited, false);

        current = y;
        ban = x;
        count = 0;
        int b = dfs(y);
        Arrays.fill(visited, false);
        answer = Math.min(Math.abs(a - b), answer);
    }

    private int dfs(int n) {
        count++;
        visited[n] = true;
        for(Integer x : adjList[n]) {
            if(n == current && x == ban) {
                continue;
            }
            if(!visited[x]) {
                dfs(x);
            }
        }
        return count;
    }
}
