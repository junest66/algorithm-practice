import java.util.*;

class Solution {
    public int solution(int n, int[] money) {
        //i원을 만드는데 가지수
        int[] dp = new int[n+1];
        Arrays.sort(money);

        //arr[0] 을 사용하려면 arr[]
        int answer = 0;
        dp[0] = 1;
        for (int j = 0; j < money.length; j++) {
            for (int i = money[j]; i <= n; i++) {
                dp[i] += dp[i - money[j]];
                dp[i] %= 1000000007;
            }
        }
        return dp[n] %= 1000000007;
    }
}
