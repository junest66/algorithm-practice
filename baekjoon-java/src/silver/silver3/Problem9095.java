package silver.silver3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem9095 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("baekjoon-java/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] dp = new int[n + 1];
            dp[0] = 1; //0을 만드는 횟수는 1가지
            for (int i = 1; i <= n; i++) {
                if (i >= 1) dp[i] += dp[i - 1];
                if (i >= 2) dp[i] += dp[i - 2];
                if (i >= 3) dp[i] += dp[i - 3];
            }
            System.out.println(dp[n]);
        }
    }
}
