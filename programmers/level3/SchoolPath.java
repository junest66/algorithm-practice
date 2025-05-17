import java.util.*;

class Solution {
    static int[][] d = {{1, 0}, {0, 1}};
    public int solution(int m, int n, int[][] puddles) {
        int MOD = 1_000_000_007;
        int[][] dp = new int[n+1][m+1];
        boolean[][] isPuddle = new boolean[n + 1][m + 1];
        for(int[] x : puddles) {
            isPuddle[x[1]][x[0]] = true;
        }
        dp[1][1] = 1;
        int answer = 0;

        for (int y = 1; y <= n; y++) {
            for (int x = 1; x <= m; x++) {
                if (isPuddle[y][x]) {
                    dp[y][x] = 0;
                    continue;
                }
                if (y > 1) dp[y][x] = (dp[y][x] + dp[y - 1][x]) % MOD;
                if (x > 1) dp[y][x] = (dp[y][x] + dp[y][x - 1]) % MOD;
            }
        }
        return dp[n][m];
    }
}
