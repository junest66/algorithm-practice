package gold.gold4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem16234 {
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = 0;
        boolean[][] visit;
        int[][] board;
        while (true) {
            visit = new boolean[n][n];
            board = new int[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(board[i], -1);
            }
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visit[i][j]) {
                        Queue<int[]> que = new LinkedList<>();
                        que.offer(new int[]{i, j});
                        int sum = 0;
                        List<int[]> list = new ArrayList<>();
                        while (!que.isEmpty()) {
                            int[] poll = que.poll();
                            int currentY = poll[0];
                            int currentX = poll[1];
                            for (int k = 0; k < 4; k++) {
                                int ny = currentY + dy[k];
                                int nx = currentX + dx[k];
                                if (ny < 0 || nx < 0 || ny >= n || nx >= n) {
                                    continue;
                                }
                                int abs = Math.abs((arr[currentY][currentX]) - arr[ny][nx]);
                                if (visit[ny][nx] || (l > abs || abs > r)) {
                                    continue;
                                }
                                count++;
                                que.offer(new int[]{ny, nx});
                                sum += arr[ny][nx];
                                list.add(new int[]{ny, nx});
                                visit[ny][nx] = true;
                            }
                            visit[currentY][currentX] = true;
                        }
                        if (list.size() != 0) {
                            sum += arr[i][j];
                            list.add(new int[]{i, j});
                            int avg = sum / list.size();
                            for (int[] ints : list) {
                                board[ints[0]][ints[1]] = avg;
                            }
                        }
                    }
                }
            }
            if (count == 0) {
                break;
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] != -1) {
                        arr[i][j] = board[i][j];
                    }
                }
            }
            answer++;
        }
        System.out.println(answer);
    }
}
