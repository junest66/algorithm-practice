package gold.gold5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Problem13910 {
    static int n;
    static int m;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            set.add(arr[i]);
            for (int j = i + 1; j < m; j++) {
                set.add(arr[i] + arr[j]);
            }
        }
        for (Integer i : set) {
            if (i <= n) {
                dp[i] = 1;
            }
        }

        for (int i = 1; i <= n; i++) {
            if (set.contains(i)) {
                continue;
            }
            for (int size : set) {
                if (i - size > 0 && dp[i - size] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - size] + 1);
                }
            }
        }
        dp[n] = dp[n] != Integer.MAX_VALUE ? dp[n] : -1;
        System.out.println(dp[n]);

    }
}
