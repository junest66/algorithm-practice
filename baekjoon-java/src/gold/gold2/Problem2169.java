package gold.gold2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2169 {
    static int[][] board;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = board[0][0];
        for (int i = 1; i < m; i++) {
            dp[0][i] = dp[0][i - 1] + board[0][i];
        }

        for (int i = 1; i < n; i++) {
            int[][] arr = new int[2][m];
            //왼 -> 오
            for (int j = 0; j < m; j++) {
                if (j == 0) {
                    arr[0][j] = dp[i - 1][j] + board[i][j];
                } else {
                    arr[0][j] = Math.max(dp[i - 1][j], arr[0][j - 1]) + board[i][j];
                }
            }

            //오 -> 왼
            for (int j = m - 1; j >= 0; j--) {
                if (j == m - 1) {
                    arr[1][j] = dp[i - 1][j] + board[i][j];
                } else {
                    arr[1][j] = Math.max(dp[i - 1][j], arr[1][j + 1]) + board[i][j];
                }
                dp[i][j] = Math.max(arr[0][j], arr[1][j]);
            }
        }
        System.out.println(dp[n - 1][m - 1]);
    }
}
