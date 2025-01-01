package gold.gold4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Problem3190 {
    static int n;
    static int k;
    static int[][] arr;
    static int[][] apple;
    static Map<Integer, String> map = new HashMap<>();
    static int time = 0;
    static int[] tail = new int[2];

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        apple = new int[n][n];
        StringTokenizer st;
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            apple[y - 1][x - 1] = 1;
        }
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            String s = st.nextToken();
            map.put(a, s);
        }
        for (int i = 0; i < n; i++) {
            Arrays.fill(arr[i], -1);
        }
        arr[0][0] = 0;
        tail[0] = 0;
        tail[1] = 0;
        dfs(0, 0, 0);
        System.out.println(time);
    }

    private static void dfs(int y, int x, int direction) {
        int[] go = go(y, x, direction);
        time++;
        int nextY = go[0];
        int nextX = go[1];
        if (nextY >= n || nextX >= n || nextY < 0 || nextX < 0 || arr[nextY][nextX] != -1) {
            return;
        }
        int nextDirection = direction;
        if (map.containsKey(time)) {
            nextDirection = changeDirection(direction, map.get(time));
        }
        if (apple[nextY][nextX] == 1) {
            arr[nextY][nextX] = nextDirection;
            apple[nextY][nextX] = 0;
        } else {
            arr[nextY][nextX] = nextDirection;
            nextTail();
        }
        dfs(nextY, nextX, nextDirection);
    }

    private static void nextTail() {
        int[] nextTail = go(tail[0], tail[1], arr[tail[0]][tail[1]]);
        arr[tail[0]][tail[1]] = -1;
        tail[0] = nextTail[0];
        tail[1] = nextTail[1];
    }

    private static int changeDirection(int direction, String s) {
        if (s.equals("D")) {
            int next = direction + 1;
            return next >= 4 ? 0 : next;
        } else {
            int next = direction - 1;
            return next < 0 ? 3 : next;
        }
    }

    private static int[] go(int y, int x, int direction) {
        if (direction == 0) { // 오른쪽
            return new int[]{y, x + 1};
        } else if (direction == 1) { //아래쪽
            return new int[]{y + 1, x};
        } else if (direction == 2) { //왼쪽
            return new int[]{y, x - 1};
        } else { //위쪽
            return new int[]{y - 1, x};
        }
    }
}
