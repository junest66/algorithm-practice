package gold.gold5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem22251 {
    public static boolean[][] board = new boolean[10][7];
    public static int[][] arr = new int[10][10];

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        board[0] = new boolean[]{true, true, true, false, true, true, true};
        board[1] = new boolean[]{false, false, true, false, false, true, false};
        board[2] = new boolean[]{true, false, true, true, true, false, true};
        board[3] = new boolean[]{true, false, true, true, false, true, true};
        board[4] = new boolean[]{false, true, true, true, false, true, false};
        board[5] = new boolean[]{true, true, false, true, false, true, true};
        board[6] = new boolean[]{true, true, false, true, true, true, true};
        board[7] = new boolean[]{true, false, true, false, false, true, false};
        board[8] = new boolean[]{true, true, true, true, true, true, true};
        board[9] = new boolean[]{true, true, true, true, false, true, true};

        arr = new int[10][10];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (i == j) {
                    continue;
                } else {
                    if (arr[i][j] == 0) {
                        arr[i][j] = func(i, j);
                        arr[j][i] = arr[i][j];
                    }
                }
            }
        }
        String currentStr = String.format("%0" + k + "d", x);
        StringBuilder current;
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int count = 0;
            boolean success = true;
            current = new StringBuilder(String.valueOf(i));
            while (current.length() < k) {
                current.insert(0, "0");
            }
            if (currentStr.equals(current.toString())) {
                continue;
            }
            for (int j = 0; j < current.length(); j++) {
                count += arr[currentStr.charAt(j) - '0'][current.charAt(j) - '0'];
                if (count > p) {
                    success = false;
                    break;
                }
            }
            if (success) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    private static int func(int i, int j) {
        int count = 0;
        for (int k = 0; k < 7; k++) {
            if (board[i][k] != board[j][k]) {
                count++;
            }
        }
        return count;
    }
}
