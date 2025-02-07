package gold.gold5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem12865 {
    static int n;
    static int k;
    static int[] w;
    static int[] v;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        w = new int[n + 1];
        v = new int[n + 1];
        dp = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) { // 순서 번호
            for (int j = 1; j <= k; j++) { //가방 무게
                if (w[i] > j) { //가방에 넣을 수 없는 경우 => 이전꺼 그대로
                    dp[i][j] = dp[i - 1][j];
                } else { //가방에 넣을 수는 있는 경우
                    //넣은거와, 안넣는거의 최대 가치로
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]);
                }
            }
        }
        System.out.println(dp[n][k]);
    }
}
