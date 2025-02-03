package silver.silver1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem2178 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] visited;
    static int[][] arr;
    static int n;
    static int m;
    static int count = 1;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(str.substring(j, j + 1));
            }
        }
        bfs(0, 0);
        System.out.println(arr[n-1][m-1]);
    }

    private static void bfs(int i, int j) {
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{i, j});
        visited[i][j] = true;
        while (!que.isEmpty()) {
            int[] now = que.poll();
            for (int k = 0; k < 4; k++) {
                int ny = now[0] + dy[k];
                int nx = now[1] + dx[k];
                if (nx < 0 || ny < 0 || nx >= m || ny >= n) {
                    continue;
                }
                if (arr[ny][nx] == 0 || visited[ny][nx]) {
                    continue;
                }
                visited[ny][nx] = true;
                arr[ny][nx] = arr[now[0]][now[1]] + 1;
                que.offer(new int[]{ny, nx});
            }
        }
    }
}
