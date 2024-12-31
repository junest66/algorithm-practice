package gold.gold4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2758 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        int n, m;
        long[][] dp = new long[11][2001];

        for (int j = 0; j <= 2000; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i < 11; i++) {
            for (int j = 1; j < 2001; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j / 2];
            }
        }

        for (int i = 0; i < t; i++) {
            String[] s = br.readLine().split(" ");
            n = Integer.parseInt(s[0]);
            m = Integer.parseInt(s[1]);
            System.out.println(dp[n][m]);
        }
    }
}
