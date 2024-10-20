package gold.gold2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Problem19237 {
    static int n, m, k;
    static int[][][] priorityDir;
    static int[][] board;
    static int[][] smell;
    static int currentShark;
    static int time = 0;
    static List<Shark> list = new ArrayList<>();
    static int[] dx = {0, 0, 0, -1, 1};
    static int[] dy = {0, -1, 1, 0, 0};

    static public class Shark {
        int number;
        int dir;
        int x;
        int y;

        public Shark(int number, int x, int y) {
            this.number = number;
            this.x = x;
            this.y = y;
        }

        public void move() {
            List<Integer> clean = new ArrayList<>();
            List<Integer> selfDir = new ArrayList<>();
            for (int i = 1; i <= 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 1 || ny < 1 || nx > n || ny > n) {
                    continue;
                }
                if (smell[ny][nx] == 0) {
                    clean.add(i);
                }
                if (board[ny][nx] == number) {
                    selfDir.add(i);
                }
            }
            int nextDir;
            if (clean.size() == 1) {
                nextDir = clean.get(0);
            } else if (clean.size() == 0) {
                nextDir = priorityDirValue(selfDir, number, dir);
            } else {
                nextDir = priorityDirValue(clean, number, dir);
            }
            dir = nextDir;
            x += dx[nextDir];
            y += dy[nextDir];
        }
    }

    static public int priorityDirValue(List<Integer> list, int fishNumber, int dir) {
        for (int i = 1; i <= 4; i++) {
            if (list.contains(priorityDir[fishNumber][dir][i])) {
                return priorityDir[fishNumber][dir][i];
            }
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        currentShark = m;
        priorityDir = new int[m + 1][5][5];
        board = new int[n + 1][n + 1];
        smell = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int a = Integer.parseInt(st.nextToken());
                if (a != 0) {
                    list.add(new Shark(a, j, i));
                    smell[i][j] = k;
                }
                board[i][j] = a;
            }
        }
        st = new StringTokenizer(br.readLine());
        list.sort((o1, o2) -> o1.number - o2.number);
        for (int i = 0; i < m; i++) {
            list.get(i).dir = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= 4; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 1; k <= 4; k++) {
                    priorityDir[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

        while (list.size() != 1) {
            time++;
            if (time > 1000) {
                time = -1;
                break;
            }
            for (int i = 0; i < list.size(); i++) {
                Shark shark = list.get(i);
                shark.move();
            }
            decreaseSmell(); //기존 냄새 -1
            checkDuplicateShark(); //겹친 상어 작은상어 제외
            //이동한데 냄새 뿌리고 위치저장
            for (Shark shark : list) {
                smell[shark.y][shark.x] = k;
                board[shark.y][shark.x] = shark.number;
            }

        }

        System.out.println(time);
    }

    private static void checkDuplicateShark() {
        Map<String, Shark> map = new HashMap<>();
        for (Shark shark : list) {
            String key = shark.x + "-" + shark.y;
            if (!map.containsKey(key) || map.get(key).number > shark.number) {
                map.put(key, shark);
            }
        }
        list.clear();
        for (Shark shark : map.values()) {
            list.add(shark);
        }
    }

    private static void decreaseSmell() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (smell[i][j] != 0) {
                    smell[i][j]--;
                    if (smell[i][j] == 0) {
                        board[i][j] = 0;
                    }
                }
            }
        }
    }

}
        
