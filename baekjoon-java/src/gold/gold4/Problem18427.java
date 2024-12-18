package gold.gold4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Problem18427 {
    static int n;
    static int m;
    static int h;
    static List<Integer>[] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        arr = new List[n + 1];
        dp = new int[n + 1][h + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList();
            String[] s = br.readLine().split(" ");
            arr[i] = Arrays.stream(s)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        }
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= h; j++) {
                for (Integer a : arr[i]) {
                    if (j >= a) {
                        dp[i][j] += dp[i - 1][j - a];
                        dp[i][j] %= 10007;
                    }
                }
                dp[i][j] += dp[i-1][j];
                dp[i][j] %= 10007;
            }
        }
        System.out.println(dp[n][h]);
    }
}
