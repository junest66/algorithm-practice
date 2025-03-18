import java.util.*;

class Solution {
//     static int[] dp;
//     public int solution(int n) {
//         dp = new int[n+1];
//         Arrays.fill(dp, -1);
//         return pibo(n);
//     }

//     private int pibo(int n) {
//         if(dp[n] != -1) {
//             return dp[n];
//         }
//         if(n == 0) {
//             dp[n] = 0;
//         } else if(n == 1) {
//             dp[n] = 1;
//         } else {
//             dp[n] =  (pibo(n-1) + pibo(n-2)) % 1234567;
//         }
//         return dp[n];
//     }

    public int solution(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
        }
        return dp[n];
    }
}
