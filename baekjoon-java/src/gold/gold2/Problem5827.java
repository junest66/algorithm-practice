package gold.gold2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem5827 {
    static char[][] arr;
    static int[] start;
    static int n;
    static int m;
    static int[] dx = {1, -1};

    static class Node implements Comparable<Node> {
        int y;
        int x;
        int gravity; // 아래방향 0, 위에방향 1
        int count;

        public Node(int y, int x, int gravity, int count) {
            this.y = y;
            this.x = x;
            this.gravity = gravity;
            this.count = count;
        }

        @Override
        public int compareTo(Node other) {
            return this.count - other.count;
        }
    }

    public static int moveOfGravity(int y, int x, int gravity) {
        if (gravity == 0) {        //중력 방향 ↓
            for (int i = y; i < n; i++) {
                if (arr[i][x] == '#') { //차단된 셀을 만날 때
                    return i - 1;
                } else if (arr[i][x] == 'D') { //버팔로 만날 때
                    return -1;
                }
            }
        } else {        //중력 방향 ↑
            for (int i = y; i >= 0; i--) {
                if (arr[i][x] == '#') { //차단된 셀을 만날 때
                    return i + 1;
                } else if (arr[i][x] == 'D') { //버팔로 만날 때
                    return -1;
                }
            }
        }
        return Integer.MIN_VALUE; //우주로 날아갈 때
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new char[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = str.charAt(j);
                if (arr[i][j] == 'C') {
                    start = new int[]{i, j};
                }
            }
        }
        start[0] = moveOfGravity(start[0], start[1], 0);
        if (start[0] == -1) { //끝
            System.out.println("0");
        } else if (start[0] == Integer.MIN_VALUE) {
            System.out.println("-1");
        } else {
            System.out.println(bfs());
        }
    }

    private static int bfs() {
        PriorityQueue<Node> que = new PriorityQueue<>();
        boolean[][][] visit = new boolean[n][m][2];
        que.offer(new Node(start[0], start[1], 0, 0));
        visit[start[0]][start[1]][0] = true;
        while (!que.isEmpty()) {
            Node current = que.poll();
            int currentY = current.y;
            int currentX = current.x;
            int currentCount = current.count;
            int currentG = current.gravity;
            for (int i = 0; i < 2; i++) {
                int tempX = currentX + dx[i];
                if (tempX >= 0 && tempX < m) {
                    if (arr[currentY][tempX] != '#') {
                        int tempY = moveOfGravity(currentY, tempX, currentG); //중력 적용
                        if (tempY == -1) {
                            return currentCount;
                        }
                        if (tempY != Integer.MIN_VALUE && !visit[tempY][tempX][currentG]) {
                            visit[tempY][tempX][currentG] = true;
                            que.offer(new Node(tempY, tempX, currentG, currentCount));
                        }
                    }
                }
            }
            int tempGravity = (currentG + 1) % 2;
            int tempY = moveOfGravity(currentY, currentX, tempGravity);
            if (tempY == -1) {
                return currentCount + 1;
            }
            if (tempY != Integer.MIN_VALUE && !visit[tempY][currentX][tempGravity]) {
                visit[tempY][currentX][tempGravity] = true;
                que.offer(new Node(tempY, currentX, tempGravity, currentCount + 1));
            }
        }
        return -1;
    }
}
