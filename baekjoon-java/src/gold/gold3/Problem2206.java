package gold.gold3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Problem2206 {
    static int n;
    static int m;
    static int answer = Integer.MAX_VALUE;
    static int[][] board;
    static boolean[][][] visit;
    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {1, -1, 0, 0};

    static class Node {
        int y, x, count;
        boolean bonus;

        public Node(int y, int x, int count, boolean bonus) {
            this.y = y;
            this.x = x;
            this.count = count;
            this.bonus = bonus;
        }
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        visit = new boolean[n][m][2];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                board[i][j] = str.charAt(j) - '0';
            }
        }

        Deque<Node> que = new ArrayDeque<>();
        if (board[0][0] == 1) {
            que.offer(new Node(0, 0, 1, true));
            visit[0][0][1] = true;
        } else {
            que.offer(new Node(0, 0, 1, false));
            visit[0][0][0] = true;
        }

        while (!que.isEmpty()) {
            Node current = que.poll();
            if (current.y == n - 1 && current.x == m - 1) {
                answer = Math.min(answer, current.count);
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int ny = dy[i] + current.y;
                int nx = dx[i] + current.x;

                if (ny >= n || nx >= m || ny < 0 || nx < 0) {
                    continue;
                }

                if (board[ny][nx] == 1 && !current.bonus && !visit[ny][nx][1]) {
                    que.offer(new Node(ny, nx, current.count + 1, true));
                    visit[ny][nx][1] = true;
                }
                int currentBroken = current.bonus ? 1 : 0;
                if (board[ny][nx] == 0 && !visit[ny][nx][currentBroken]) {
                    visit[ny][nx][currentBroken] = true;
                    que.offer(new Node(ny, nx, current.count + 1, current.bonus));
                }
            }
        }
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }
}
