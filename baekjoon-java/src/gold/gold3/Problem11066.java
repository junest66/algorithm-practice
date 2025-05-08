package gold.gold3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem11066 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int K = Integer.parseInt(br.readLine());
            int[] files = new int[K];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < K; i++) {
                files[i] = Integer.parseInt(st.nextToken());
            }

            System.out.println(getMinCost(K, files));
        }
    }

    static int getMinCost(int K, int[] files) {
        int[][] dp = new int[K][K];
        int[] sum = new int[K];

        // 누적합 초기화
        sum[0] = files[0];
        for (int i = 1; i < K; i++) {
            sum[i] = files[i] + sum[i - 1];
        }

        // 초기값
        for (int i = 0; i < K; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            dp[i][i] = 0;
        }

        for (int gap = 1; gap < K; gap++) {
            for (int s = 0; s < K - gap; s++) {
                int e = s + gap;
                for (int m = s; m < e; m++) {
                    int cost = dp[s][m] + dp[m + 1][e] + sum[e] - (s == 0 ? 0 : sum[s - 1]);
                    dp[s][e] = Math.min(dp[s][e], cost);
                }
            }
        }

        return dp[0][K - 1];
    }
}
