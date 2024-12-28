package gold.gold4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem14722 {
    static int n;
    static int[][] arr;
    static int[][][] d;
    static int answer;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n + 1][n + 1];
        d = new int[n + 1][n + 1][3];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        func();
        System.out.println(answer);
    }

    static void func() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int current = arr[i][j];
                for (int k = 0; k < 3; k++) {
                    d[i][j][k] = Math.max(d[i][j][k], d[i - 1][j][k]);
                    d[i][j][k] = Math.max(d[i][j][k], d[i][j - 1][k]);
                }
                if (current == 0) {
                    d[i][j][0] = Math.max(d[i][j][0], d[i - 1][j][2] + 1);
                    d[i][j][0] = Math.max(d[i][j][0], d[i][j - 1][2] + 1);
                }
                if (current == 1) {
                    if (d[i - 1][j][0] != 0) {
                        d[i][j][1] = Math.max(d[i][j][1], d[i - 1][j][0] + 1);
                    }
                    if (d[i][j - 1][0] != 0) {
                        d[i][j][1] = Math.max(d[i][j][1], d[i][j - 1][0] + 1);
                    }
                }
                if (current == 2) {
                    if (d[i - 1][j][1] != 0) {
                        d[i][j][2] = Math.max(d[i][j][2], d[i - 1][j][1] + 1);
                    }
                    if (d[i][j - 1][1] != 0) {
                        d[i][j][2] = Math.max(d[i][j][2], d[i][j - 1][1] + 1);
                    }
                }
            }
        }
        answer = Math.max(d[n][n][0], Math.max(d[n][n][1], d[n][n][2]));
    }
}
