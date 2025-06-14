package silver.silver1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem15990 {
    static int t;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("baekjoon-java/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        t = Integer.parseInt(st.nextToken());
        int[] arr = new int[t];
        int max = 0;
        for (int i = 0; i < t; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }
        int[][] dp = new int[max + 1][3]; //i원을 만들때 마지막수 가 j인 경우의수
        if (max >= 1) {
            dp[1][0] = 1;      // 1
        }
        if (max >= 2) {
            dp[2][1] = 1;      // 2
        }
        if (max >= 3) {                  // 3을 만드는 세 가지 끝수
            dp[3][0] = 1;  // 2 + 1
            dp[3][1] = 1;  // 1 + 2
            dp[3][2] = 1;  // 3
        }
        for (int i = 4; i <= max; i++) {
            if (i >= 1) {
                dp[i][0] = (dp[i - 1][1] + dp[i - 1][2]) % 1000000009;
            }
            if (i >= 2) {
                dp[i][1] = (dp[i - 2][0] + dp[i - 2][2]) % 1000000009;
            }
            if (i >= 3) {
                dp[i][2] = (dp[i - 3][0] + dp[i - 3][1]) % 1000000009;
            }
        }
        for (int n : arr) {
            long result = ((long) dp[n][0] + dp[n][1] + dp[n][2]) % 1000000009;
            System.out.println(result);
        }
    }

}
