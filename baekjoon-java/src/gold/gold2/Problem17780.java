package gold.gold2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Problem17780 {
    static int n;
    static int k;
    static int[][] board;
    static List<Node>[][] current;
    static List<Node> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        board = new int[n][n];
        current = new ArrayList[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                current[i][j] = new ArrayList<>();
            }
        }

        for (int i = 1; i <= k; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());
            Node node = new Node(i, x-1, y-1, direction);
            current[y-1][x-1].add(0, node);
            list.add(node);
        }
        int turn = 1;
        while (true) {
            if (turn > 1000) {
                break;
            }
            //1. 1번말부터 n번말까지 시작
            boolean end = false;
            for (Node node : list) {
                List<Node> nodeList = current[node.y][node.x];
                if (nodeList.get(0).num != node.num) { //젤 밑에가 아니면 건너뛰기
                    continue;
                }
                int[] arr = node.nextPosition();
                int nextX = arr[0];
                int nextY = arr[1];
                int nextColor = arr[2];
                int size = go(node, nextColor, nextX, nextY);
                if (size >= 4) {
                    end = true;
                    break;
                }
            }
            if (end) {
                break;
            }
            turn++;
        }
        if (turn > 1000) {
            System.out.println("-1");
        } else {
            System.out.println(turn);
        }
    }

    private static int go(Node node, int nextColor, int nextX, int nextY) {
        List<Node> nodeList = current[node.y][node.x];
        //이동하려는 칸이 무슨색?
        if (nextColor == 0) { //흰색
            current[node.y][node.x] = new ArrayList<>();
            for (Node n : nodeList) { //x, y 변경
                n.move(nextX, nextY);
            }
            List<Node> nextList = current[nextY][nextX];
            nextList.addAll(nodeList);
            return nextList.size();
        } else if (nextColor == 1) { // 빨간색
            current[node.y][node.x] = new ArrayList<>();
            for (Node n : nodeList) { //x, y 변경
                n.move(nextX, nextY);
            }
            List<Node> nextList = current[nextY][nextX];
            Collections.reverse(nodeList);
            nextList.addAll(nodeList);
            return nextList.size();
        } else { // 파란색
            node.reverseDirection();
            int[] nextedPosition = node.nextPosition();
            int color = nextedPosition[2];
            if (color != 2) {
                return go(node, color, nextedPosition[0], nextedPosition[1]);
            }
            return nodeList.size();
        }
    }

    public static class Node {
        int num, x, y, direction;

        public Node(int num, int x, int y, int direction) {
            this.num = num;
            this.x = x;
            this.y = y;
            this.direction = direction;
        }

        public int[] nextPosition() {
            int nextX = 0;
            int nextY = 0;
            if (direction == 1) {
                nextX = x + 1;
                nextY = y;
            } else if (direction == 2) {
                nextX = x - 1;
                nextY = y;
            } else if (direction == 3) {
                nextX = x;
                nextY = y - 1;
            } else {
                nextX = x;
                nextY = y + 1;
            }
            if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= n) {
                return new int[]{x, y, 2}; //파란색
            } else {
                return new int[]{nextX, nextY, board[nextY][nextX]};
            }
        }

        void move(int x, int y) {
            this.x = x;
            this.y = y;
        }

        void reverseDirection() {
            if (direction == 1) {
                this.direction = 2;
            } else if (direction == 2) {
                this.direction = 1;
            } else if (direction == 3) {
                this.direction = 4;
            } else {
                this.direction = 3;
            }
        }
    }
}
