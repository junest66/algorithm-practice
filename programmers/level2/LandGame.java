import java.util.*;

class Solution {
    static int[][] dp;
    int solution(int[][] land) {
        dp = new int[land.length][4];
        for(int i = 0; i < 4; i++) { //1행
            dp[0][i] = land[0][i];
        }

        for(int i = 1; i < land.length; i++) {
            for(int j = 0; j < 4; j++) {
                dp[i][j] = func(i, j) + land[i][j];
            }
        }

        return Arrays.stream(dp[land.length - 1]).max().getAsInt();
    }

    private int func(int i, int j) {  //같은행이 아닌 세개의 최대
        int maxValue = 0;
        for(int k = 0; k < 4; k++) {
            if(j == k) continue;
            maxValue = Math.max(maxValue, dp[i-1][k]);
        }
        return maxValue;
    }
}
