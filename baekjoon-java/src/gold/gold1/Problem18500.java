package gold.gold1;

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

public class Problem18500 {
    static char[][] board;
    static int r;
    static int c;
    static int n;
    static int[] dx = {-1, 1, 0, 0}; //오른쪽, 왼쪽, 위쪽, 아래쪽
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visit;
    static Queue<Position> que = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        board = new char[r][c];
        visit = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < chars.length; j++) {
                board[i][j] = chars[j];
            }
        }
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = r - Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) { //짝수면 왼쪽에서
                func(0, arr[i]);
            } else { //홀수면 오른쪽에서
                func(1, arr[i]);
            }
        }
        print();
    }

    private static void print() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    private static void func(int direction, int num) { //방향, 번호
        int x = -1;
        int y = num;
        if (direction == 0) { //왼쪽에서부터
            for (int i = 0; i < c; i++) {
                if (board[y][i] == 'x') { //미네랄이면
                    x = i;
                    break;
                }
            }
        } else { //오른쪽에서부터
            for (int i = c - 1; i >= 0; i--) {
                if (board[y][i] == 'x') { //미네랄이면
                    x = i;
                    break;
                }
            }
        }
        if (x == -1) {
            return;
        }
        //해당 위치에서의 왼쪽 오른쪽 위쪽에서 연결된 클러스터가 공중에 떠있는지 ??
        board[y][x] = '.';
        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if (nx >= 0 && ny >= 0 && nx < c && ny < r && board[ny][nx] == 'x') {
                bfs(new Position(ny, nx));
            }
        }
    }

    private static void bfs(Position position) {
        List<Position> list = new ArrayList<>();
        for (int i = 0; i < r; i++) {
            Arrays.fill(visit[i], false);
        }
        que.clear();
        list.add(position);
        visit[position.y][position.x] = true;
        que.offer(position);
        while (!que.isEmpty()) {
            Position cur = que.poll();
            if (cur.y == r - 1) { //땅에 있을때
                return;
            }
            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];
                Position next = new Position(ny, nx);
                if (ny < 0 || nx < 0 || ny >= r || nx >= c) {
                    continue;
                }
                if (visit[ny][nx] || board[ny][nx] == '.') {
                    continue;
                }
                visit[ny][nx] = true;
                que.offer(next);
                list.add(next);
            }
        }
        // '.'으로 치환
        for (Position pos : list) {
            board[pos.y][pos.x] = '.';
        }
        // 하나라도 땅에 닿거나 다른 미네랄이 닿을 때까지 내려가기
        boolean end = false;
        while (!end) {
            for (int i = 0; i < list.size(); i++) {
                int x = list.get(i).x;
                int y = list.get(i).y + 1;
                if (y == r || board[y][x] == 'x') {
                    end = true;
                }
                list.set(i, new Position(y, x));
            }
        }
        for (Position pos : list) {
            board[pos.y - 1][pos.x] = 'x';
        }
    }

    static class Position {
        int y;
        int x;

        public Position(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
