package gold.gold4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1633 {
    static int[] white = new int[1001];
    static int[] black = new int[1001];
    static int n;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String line = br.readLine();
            if (line == null || line.isEmpty()) {
                break;
            }
            String[] parts = line.split(" ");
            white[n] = Integer.parseInt(parts[0]);
            black[n] = Integer.parseInt(parts[1]);
            n++;
        }

        int[][][] dp = new int[n + 1][16][16];
        dp = new int[1001][16][16];
        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= 15; w++) {
                for (int b = 0; b <= 15; b++) {
                    dp[i][w][b] = dp[i - 1][w][b];
                    if (w > 0) {
                        dp[i][w][b] = Math.max(dp[i][w][b], dp[i - 1][w - 1][b] + white[i - 1]);
                    }
                    if (b > 0) {
                        dp[i][w][b] = Math.max(dp[i][w][b], dp[i - 1][w][b - 1] + black[i - 1]);
                    }
                }
            }
        }

        // 결과 출력
        System.out.println(dp[n][15][15]);
    }

    private static void func(int index, int white, int black) {
        if (index == n) {
            return;
        }
        if (white == 15 && black == 15) {
            return;
        }

    }
}
