package gold.gold3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Problem14890 {
    static int n;
    static int L;
    static int answer = 0;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < n; i++) {
            if (check(board[i])) {
                answer++; // 행
            }

            int a = i;
            int[] col = IntStream.range(0, n).map(j -> board[j][a]).toArray();
            if (check(col)) {
                answer++; // 열
            }
        }
        System.out.println(answer);
    }

    private static boolean check(int[] line) {
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n - 1; i++) {
            int diff = line[i] - line[i + 1];

            if (diff == 0) {
                continue;
            }

            if (Math.abs(diff) > 1) {
                return false;
            }

            // 내리막길
            if (diff == 1) {
                for (int j = 1; j <= L; j++) {
                    int idx = i + j;
                    if (idx >= n || visited[idx] || line[idx] != line[i + 1]) {
                        return false;
                    }
                }
                for (int j = 1; j <= L; j++) {
                    visited[i + j] = true;
                }
            }

            // 오르막길
            else if (diff == -1) {
                for (int j = 0; j < L; j++) {
                    int idx = i - j;
                    if (idx < 0 || visited[idx] || line[idx] != line[i]) {
                        return false;
                    }
                }
                for (int j = 0; j < L; j++) {
                    visited[i - j] = true;
                }
            }
        }

        return true;
    }
}
