class Solution {
    public int solution(int sticker[]) {
        if (sticker.length == 1) return sticker[0];
        int n = sticker.length;
        int[][] dp = new int[n][2];
        dp[0][1] = sticker[0];
        for (int i = 1; i < n - 1; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + sticker[i];
        }
        int answer = Math.max(dp[n - 2][0], dp[n - 2][1]);

        dp = new int[n][2];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + sticker[i];
        }
        answer = Math.max(answer, Math.max(dp[n - 1][0], dp[n - 1][1]));
        return answer;
    }
}
