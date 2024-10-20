package gold.gold3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem1941 {
    public static String[][] arr = new String[5][5];
    public static boolean[][] visit = new boolean[5][5];
    public static int[] current = new int[7];
    public static int answer;
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static int cq = 0;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String[] board = new String[5];
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            board[i] = st.nextToken();
        }
        solution(board);

    }

    // 1. 25개중에 7개를 선택
    // 2. 7개중 4명이상 이다솜파
    // 3. bfs로 가로세로 연결돼 있어야함
    private static void solution(String[] board) {
        for (int i = 0; i < board.length; i++) {
            String str = board[i];
            String[] split = str.split("");
            for (int j = 0; j < split.length; j++) {
                arr[i][j] = split[j];
            }
        }
        backtracking(0, 0);
        System.out.println(answer);
    }

    private static void backtracking(int depth, int start) {
        if (depth == 7) {
            cq++;
            //func
            checkAnswer();
            return;
        }
        for(int i = start; i < 25; i++) {
            visit[i / 5][i % 5] = true;
            current[depth] = i;
            backtracking(depth+1, i+1);
            visit[i / 5][i % 5] = false;
        }
    }

    private static void checkAnswer() {
        // 2. 7개중 4명이상 이다솜파
        long count = Arrays.stream(current)
                .filter(a -> arr[a/5][a%5].equals("S"))
                .count();
        if(count < 4) {
            return;
        }
        isConnected();
    }

    private static void isConnected() {
        // 3. bfs로 가로세로 연결돼 있어야함
        boolean[] visited = new boolean[7];
        Queue<Integer> que = new LinkedList<>();
        que.offer(current[0]);
        visited[0] = true;
        int c = 1;
        while (!que.isEmpty()) {
            Integer poll = que.poll();
            int x = poll % 5;
            int y = poll / 5;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5) {
                    continue;
                }
                int nt = ny * 5 + nx;
                for (int next = 1; next < 7; next++) {
                    if (!visited[next] && current[next] == nt) {
                        que.offer(nt);
                        visited[next] = true;
                        c++;
                    }
                }
            }
        }
        if (c == 7) {
            answer++;
        }
    }
}
