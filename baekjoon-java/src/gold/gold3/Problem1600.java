package gold.gold3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem1600 {
    public static int dx[] = {1, 0, -1, 0};
    public static int dy[] = {0, 1, 0, -1};
    public static int wx[] = {1, 2, 2, 1, -1, -2, -2, -1};
    public static int wy[] = {-2, -1, 1, 2, 2, 1, -1, -2};
    public static int[][] board;
    public static int[][][] dist;
    public static int n, m;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[205][205];
        dist = new int[205][205][31];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                Arrays.fill(dist[i][j], -1);
            }
        }
        solution(k, board);
    }

    public static class Node {
        int y, x, count;

        public Node(int y, int x, int count) {
            this.y = y;
            this.x = x;
            this.count = count;
        }
    }

    private static void solution(int k, int[][] board) {
        int answer = -1;
        dist[0][0][0] = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0, 0));
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            int currentY = current.y;
            int currentX = current.x;
            int currentC = current.count;
            if (currentY == m - 1 && currentX == n - 1) {
                answer = dist[currentY][currentX][currentC];
                break;
            }
            if (current.count < k) {
                for (int i = 0; i < 8; i++) {
                    int nx = currentX + wx[i];
                    int ny = currentY + wy[i];
                    if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                        continue;
                    }
                    if (dist[ny][nx][currentC + 1] != -1 || board[ny][nx] != 0) {
                        continue;
                    }
                    queue.offer(new Node(ny, nx, current.count + 1));
                    dist[ny][nx][currentC + 1] = dist[currentY][currentX][currentC] + 1;
                }
            }
            for (int i = 0; i < 4; i++) {
                int nx = currentX + dx[i];
                int ny = currentY + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }
                if (dist[ny][nx][currentC] != -1 || board[ny][nx] != 0) {
                    continue;
                }
                queue.offer(new Node(ny, nx, current.count));
                dist[ny][nx][currentC] = dist[currentY][currentX][currentC] + 1;
            }
        }
        System.out.println(answer);
    }
}
