package gold.gold3;

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

public class Problem14466 {
    static int[][] road;
    static List<Integer> list;
    static int n;
    static int k;
    static int r;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        road = new int[n * n][n * n];
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken()) - 1;
            int c1 = Integer.parseInt(st.nextToken()) - 1;
            int r2 = Integer.parseInt(st.nextToken()) - 1;
            int c2 = Integer.parseInt(st.nextToken()) - 1;
            road[r1 * n + c1][r2 * n + c2] = 1;
            road[r2 * n + c2][r1 * n + c1] = 1;
        }
        list = new ArrayList<>(k);
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            list.add(n * y + x);
        }
        int answer = 0;
        for (int i = 0; i < list.size(); i++) {
            answer += func(i);
        }
        System.out.println(answer);
    }

    private static int func(int a) {
        Queue<Integer> queue = new LinkedList<>();
        int[] d = new int[n * n];
        Arrays.fill(d, -1);
        d[list.get(a)] = 0;
        queue.offer(list.get(a));
        while (!queue.isEmpty()) {
            Integer index = queue.poll();
            int y = index / n;
            int x = index % n;
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (ny < 0 || nx < 0 || ny >= n || nx >= n) {
                    continue;
                }
                if (d[ny * n + nx] != -1 || road[index][ny * n + nx] == 1) { //길인 경우
                    continue;
                }
                d[ny * n + nx] = 0;
                queue.offer(ny * n + nx);
            }
        }
        int result = 0;
        for (int j = a + 1; j < list.size(); j++) {
            if (d[list.get(j)] == -1) {
                result++;
            }
        }
        return result;
    }
}
