package gold.gold4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem4485 {
    static int[][] d = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int index = 1;
        int[][] arr;
        int[][] dp;
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }
            arr = new int[n][n];
            dp = new int[n][n];
            StringTokenizer st;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
                Arrays.fill(dp[i], Integer.MAX_VALUE);
            }
            dp[0][0] = arr[0][0];
            PriorityQueue<int[]> pq = new PriorityQueue<>(
                    Comparator.comparing(a -> a[2])); // 가중치 오름차순 0 -> y, 1 -> x, 2 -> dist
            pq.offer(new int[]{0, 0, dp[0][0]});
            while (!pq.isEmpty()) {
                int[] current = pq.poll();
                int cy = current[0];
                int cx = current[1];
                int cd = current[2];
                if (dp[cy][cx] < cd) {
                    continue;
                }
                for (int[] x : d) {
                    int ny = x[0] + cy;
                    int nx = x[1] + cx;
                    if (ny < 0 || nx < 0 || ny >= n || nx >= n) {
                        continue;
                    }
                    int nextCost = dp[cy][cx] + arr[ny][nx];
                    if (nextCost < dp[ny][nx]) {
                        dp[ny][nx] = nextCost;
                        pq.offer(new int[]{ny, nx, nextCost});
                    }
                }
            }
            System.out.println("Problem " + index++ + ": " + dp[n - 1][n - 1]);
        }
    }
}
