package gold.gold5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem9084 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int[] type = new int[num];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < num; j++) {
                type[j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            int won = Integer.parseInt(st.nextToken());
            solution(num, type, won);
        }
    }

    private static void solution(int num, int[] type, int won) {
        // Table: dp[i] = j   i: won  j : 경우의수
        int[] dp = new int[10001];
        dp[0] = 1;
        for (int i : type) {
            for (int j = 1; j <= won; j++) {
                if (j - i < 0) {
                    continue;
                }
                dp[j] += dp[j - i];
            }
        }
        System.out.println(dp[won]);
    }
}
