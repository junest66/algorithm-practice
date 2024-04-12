package gold.gold4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem16929 {
    static int n;
    static int k;
    static char[][] board;
    static boolean[][] check;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int startX;
    static int startY;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        board = new char[n][k];
        check = new boolean[n][k];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < k; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                startX = j;
                startY = i;
                if (dfs(j, i, 0)) {
                    System.out.println("Yes");
                    return;
                }
            }
        }
        System.out.println("No");

    }

    private static boolean dfs(int currentX, int currentY, int count) {
        if(check[currentY][currentX]) {
            if(startX == currentX && startY == currentY && count >= 4) {
                return true;
            } else {
                return false;
            }
        }

        check[currentY][currentX] = true;
        for(int i = 0; i < 4; i++) {
            int nx = currentX + dx[i];
            int ny = currentY + dy[i];
            if(nx < 0 || ny < 0 || nx >= k || ny >= n || board[currentY][currentX] != board[ny][nx]) {
                continue;
            }
            if(dfs(nx, ny, count + 1)) {
                return true;
            }
        }
        check[currentY][currentX] = false;
        return false;
    }
}
