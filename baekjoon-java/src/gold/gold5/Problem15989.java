package gold.gold5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem15989 {
    static int t;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("baekjoon-java/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        int[] arr = {1, 2, 3};
        int[] nArr = new int[t];
        int max = 0;
        for (int i = 0; i < t; i++) {
            nArr[i] = Integer.parseInt(br.readLine());
            max = Math.max(nArr[i], max);
        }
        int[] dp = new int[max + 1];
        dp[0] = 1;
        for (int x : arr) {
            for (int i = 1; i <= max; i++) {
                if (i >= x) {
                    dp[i] += dp[i - x];
                }
            }
        }
        for (int i : nArr) {
            System.out.println(dp[i]);
        }
    }
}
