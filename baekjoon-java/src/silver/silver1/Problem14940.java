package silver.silver1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem14940 {
    static int n;
    static int m;
    static int[][] arr;
    static int[][] dist;
    static boolean[][] visited;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        dist = new int[n][m];
        visited = new boolean[n][m];

        int[] start = new int[2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 2) {
                    start[0] = i;
                    start[1] = j;
                } else if (arr[i][j] == 1) {
                    dist[i][j] = -1;
                } else {
                    dist[i][j] = 0;
                }
            }
        }
        Queue<int[]> que = new LinkedList<>();
        que.offer(start);
        visited[start[0]][start[1]] = true;
        dist[start[0]][start[1]] = 0;
        while (!que.isEmpty()) {
            int[] current = que.poll();
            int cY = current[0];
            int cX = current[1];
            for (int i = 0; i < 4; i++) {
                int ny = dy[i] + cY;
                int nx = dx[i] + cX;
                if (ny < 0 || nx < 0 || ny >= n || nx >= m) {
                    continue;
                }
                if (arr[ny][nx] == 0 || dist[ny][nx] != -1) { //0이거나 이미 방문했거나
                    continue;
                }
                dist[ny][nx] = dist[cY][cX] + 1;
                que.offer(new int[]{ny, nx});
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(dist[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
