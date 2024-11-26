package gold.gold2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem1943 {
    static int n;
    static int[][] coins;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < 3; k++) {
            n = Integer.parseInt(br.readLine());
            int sum = 0;
            coins = new int[n][2];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int coin = Integer.parseInt(st.nextToken());
                coins[i][0] = coin;
                int cnt = Integer.parseInt(st.nextToken());
                coins[i][1] = cnt;
                sum += coin * cnt;
            }
            if (sum % 2 != 0) {
                sb.append("0");
            } else {
                sb.append(solve(sum / 2));
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static int solve(int mid) {
        int[] dp = new int[mid + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            int[] coin = coins[i];
            for (int j = 0; j <= mid; j++) {
                if (dp[j] == Integer.MAX_VALUE) {
                    continue;
                }
                if (j + coin[0] <= mid && dp[j] < coin[1]) {
                    dp[j + coin[0]] = Math.min(dp[j + coin[0]], dp[j] + 1);
                }
                dp[j] = 0;
            }
        }
        if (dp[mid] != Integer.MAX_VALUE) {
            return 1;
        } else {
            return 0;
        }
    }
}
