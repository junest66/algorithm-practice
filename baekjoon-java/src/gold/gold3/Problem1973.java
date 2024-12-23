package gold.gold3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1973 {
    static int n;
    static int[][] arr;
    static int answer = -1;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                answer = Math.max(dfs(i, j), answer);
            }
        }
        System.out.println(answer);
    }

    public static int dfs(int y, int x) {
        if (dp[y][x] != 0) {
            return dp[y][x];
        }
        dp[y][x] = 1;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                if (arr[ny][nx] > arr[y][x]) {
                    dp[y][x] = Math.max(dp[y][x], dfs(ny, nx) + 1);
                }
            }
        }
        return dp[y][x];
    }
}
