package gold.gold5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Problem2294 {
    static int n;
    static int k;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("baekjoon-java/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(Integer.parseInt(br.readLine()));
        }

        int[] dp = new int[k + 1];
        Arrays.fill(dp, k + 1);
        dp[0] = 0;

        for (int coin : set) {
            for (int i = coin; i <= k; i++) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        System.out.println(dp[k] == k + 1 ? -1 : dp[k]);
    }
}
