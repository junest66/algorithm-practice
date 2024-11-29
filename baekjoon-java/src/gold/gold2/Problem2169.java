package gold.gold2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem2169 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0] = arr[0][0];
        for (int i = 1; i < m; i++) {
            dp[0][i] = dp[0][i - 1] + arr[0][i];
        }
        int[][] temp = new int[2][m];
        for (int i = 1; i < n; i++) {
            //왼쪽이랑, 위쪽만 먼저
            for (int j = 0; j < m; j++) {
                //첫번째는 위에서만 내려올수있음
                if (j == 0) {
                    temp[0][j] = dp[i - 1][j] + arr[i][j];
                } else {
                    temp[0][j] = Math.max(temp[0][j - 1], dp[i - 1][j]) + arr[i][j];
                }
            }

            //오른쪽이랑 비교
            for (int j = m - 1; j >= 0; j--) {
                //마지막은 위에서만 내려올수있음
                if (j == m - 1) {
                    temp[1][j] = dp[i - 1][j] + arr[i][j];
                } else {
                    temp[1][j] = Math.max(temp[1][j + 1], dp[i - 1][j]) + arr[i][j];
                }
            }
            for (int j = 0; j < m; j++) {
                dp[i][j] = Math.max(temp[0][j], temp[1][j]);
            }
        }
        System.out.println(dp[n-1][m-1]);
    }
}
