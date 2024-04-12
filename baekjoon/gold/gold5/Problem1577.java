package gold.gold5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem1577 {
    static long[][] dp;
    static int[][][] repair;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine());
        dp = new long[m+1][n+1];
        repair = new int[m+1][n+1][2];

        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int y = Math.max(b,d);
            int x = Math.max(a,c);
            if(b==d) {
                repair[y][x][0] = -1;
            } else {
                repair[y][x][1] = -1;
            }
        }

        for(int i = 1; i <= m; i++) {
            if(repair[i][0][1] == -1) {
                break;
            }
            dp[i][0] = 1;
        }

        for(int i = 1; i <= n; i++) {
            if(repair[0][i][0] == -1) {
                break;
            }
            dp[0][i] = 1;
        }

        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <=n; j++) {
                long sum = 0;

                if(repair[i][j][0] != -1) { //옆에서 오는거
                    sum += dp[i][j-1];
                }
                if(repair[i][j][1] != -1) { // 위에서 오는거
                    sum += dp[i-1][j];
                }
                dp[i][j] = sum;
            }
        }
//        for(int i = 0; i <= m; i++) {
//            for (int j = 0; j <= n; j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }
        System.out.println(dp[m][n]);
    }
}
