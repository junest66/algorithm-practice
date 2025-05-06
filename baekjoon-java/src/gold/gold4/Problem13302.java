package gold.gold4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem13302 {
    static int n;
    static int m;
    static boolean[] holiday;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        holiday = new boolean[n + 1];
        dp = new int[n + 1][41];
        if (m > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                holiday[Integer.parseInt(st.nextToken())] = true;
            }
        }
        for (int i = 0; i <= n; i++) { //Day
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = 0; // 시작 지점

        for (int i = 0; i < n; i++) { //day
            for (int j = 0; j <= 40; j++) { //coupon
                if (dp[i][j] == Integer.MAX_VALUE) {
                    continue;
                }
                if (holiday[i + 1]) { //다음날이 안 가는 날인 경우
                    dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j]);
                    continue;
                }
                dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + 10000);
                if (i + 3 <= n) {
                    dp[i + 3][j + 1] = Math.min(dp[i + 3][j + 1], dp[i][j] + 25000);
                }

                if (i + 5 <= n) {
                    dp[i + 5][j + 2] = Math.min(dp[i + 5][j + 2], dp[i][j] + 37000);
                }

                if (j >= 3) {
                    dp[i + 1][j - 3] = Math.min(dp[i + 1][j - 3], dp[i][j]);
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i <= 40; i++) {
            if (dp[n][i] != Integer.MAX_VALUE) {
                result = Math.min(result, dp[n][i]);
            }
        }

        System.out.println(result);

    }
}
