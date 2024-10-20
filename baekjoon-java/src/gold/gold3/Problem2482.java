package gold.gold3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2482 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int[][] dp = new int[n+1][n+1];
        for(int i = 1; i <= n; i++) {
            dp[i][1] = i;
            dp[i][0] = 1;
        }
        for(int i = 2; i < n; i++) {
            for(int j = 2; j <= k; j++) {
                dp[i][j]  = (dp[i-2][j-1] + dp[i-1][j]) % 1000000003;  // n-2개에서 k-1개를 뽑아서 n개순번을 뽑는경우 +  n-1개에서 k개를 뽑아서 n개 순번 안뽑는 경우
            }
        }
        dp[n][k] = (dp[n-3][k-1] + dp[n-1][k]) % 1000000003;
        System.out.println(dp[n][k]);
    }
}
