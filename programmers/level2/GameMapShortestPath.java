import java.util.*;

class Solution {
    static int[][] dist;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int n;
    static int m;

    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        dist = new int[n][m];
        Deque<int[]> que = new ArrayDeque<>();
        dist[0][0] = 1;
        que.offer(new int[]{0,0});
        while(!que.isEmpty()) {
            int[] current = que.poll();
            int cy = current[0];
            int cx = current[1];

            for(int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];
                if(ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
                if(dist[ny][nx] != 0 || maps[ny][nx] != 1) continue;
                que.add(new int[]{ny, nx});
                dist[ny][nx] = dist[cy][cx] + 1;
            }
        }

        return dist[n-1][m-1] == 0 ? -1 : dist[n-1][m-1];
    }
}
