package silver.silver2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem15988 {
    static int t;
    static final int VALUE = 1000000009;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("baekjoon-java/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        int max = 0;
        int[] arr = new int[t];
        for (int i = 0; i < t; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }
        int[] dp = new int[max + 1];
        dp[0] = 1;
        for (int i = 1; i <= max; i++) {
            if (i >= 1) {
                dp[i] = (dp[i] + dp[i - 1]) % VALUE;
            }
            if (i >= 2) {
                dp[i] = (dp[i] + dp[i - 2]) % VALUE;
            }
            if (i >= 3) {
                dp[i] = (dp[i] + dp[i - 3]) % VALUE;
            }
        }
        for (int x : arr) {
            System.out.println(dp[x]);
        }
    }
}
