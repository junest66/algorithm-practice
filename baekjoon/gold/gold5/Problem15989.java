package gold.gold5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem15989 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            solution(n);
        }

    }

    private static void solution(int n) {
        //dp[i][j]  i를 만드는데 끝자리가 j면서 오름차순
        //dp[i][1] = d[i-1][1]   i를 만드는데 끝자리가 1이면서 오름차순으로 i를 만드는 경우
        //dp[i][2] = d[i-2][1] + d[i-2][2]   i를 만드는데 끝자리가 2이면서 오름차순으로 i를 만드는 경우
        //dp[i][3] = d[i-2][1] + d[i-2][2] + d[i-3][3]   i를 만드는데 끝자리가 3이면서 오름차순으로 만드는 경우
        int[][] dp = new int[10002][4];
        dp[1][1] = 1;
        dp[2][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;
        for (int i = 4; i <= n; i++) {
            dp[i][1] = dp[i - 1][1];
            dp[i][2] = dp[i - 2][1] + dp[i - 2][2];
            dp[i][3] = dp[i - 3][1] + dp[i - 3][2] + dp[i-3][3];
        }
        System.out.println(dp[n][1] + dp[n][2] + dp[n][3]);

    }
}
