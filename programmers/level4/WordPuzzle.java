import java.util.*;

class Solution {
    public int solution(String[] strs, String t) {
        int[] dp = new int[t.length() + 1];
        Set<String> set = new HashSet<>(List.of(strs));

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; // 초기 상태: 빈 문자열을 만들기 위한 조각 수는 0

        for (int i = 1; i <= t.length(); i++) {
            for (int j = 1; j <= 5 && j <= i; j++) {
                String sub = t.substring(i - j, i);
                if (set.contains(sub) && dp[i - j] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - j] + 1);
                }
            }
        }

        return dp[t.length()] == Integer.MAX_VALUE ? -1 : dp[t.length()];
    }
}
