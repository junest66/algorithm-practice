package silver.silver3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1463 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("baekjoon-java/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        //n에서 1.3으로나누기, 2.2로 나누기, 3. 1뺴기 - 1로 만들기 최솟값
        //dp[i] = i를 만들기까지 걸린 최소 횟수
        int[] dp = new int[n + 1];
        dp[1] = 0; //이미 목표
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + 1; //이전에서 1을 사용
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }
        System.out.println(dp[n]);
    }
}
