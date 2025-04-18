import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Main {
    static int[][] board;
    static int[] dy = {1, -1 , 0, 0};
    static int[] dx = {0, 0, 1, -1};
    static int N;
    static int Q;
    static int[] cnt;
    static boolean[][] visit;

    public static void main(String[] args) throws Exception {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        board = new int[N][N];
        cnt = new int[Q+1];
        visit = new boolean[N][N];

        for(int i = 1; i <= Q; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            List<Map.Entry<Integer, List<int[]>>> list = addFunc(x1, y1, x2, y2, i);
            moveFunc(list);
            System.out.println(calc());
        }
    }

    private static List<Map.Entry<Integer, List<int[]>>> addFunc(int x1, int y1, int x2, int y2, int num) {
        // 추가
        for(int i = y1; i < y2; i++) {
            for(int j = x1; j < x2; j++) {
                board[i][j] = num;
            }
        }

        // 둘 이상의 영역으로 나눠진 경우 미생물 사라짐
        Arrays.fill(cnt, 0);
        visit = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(board[i][j] != 0 && !visit[i][j]) { //탐색
                    bfs(i, j);
                }
            }
        }
        Set<Integer> st = IntStream.range(1, Q+1)
        .filter(i -> cnt[i] >= 2)
        .boxed()
        .collect(Collectors.toSet());

        Map<Integer, List<int[]>> map = new HashMap<>();

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(st.contains(board[i][j])) {
                    board[i][j] = 0;
                } else if(board[i][j] != 0) {
                    map.computeIfAbsent(board[i][j], k -> new ArrayList<>()).add(new int[]{i, j});
                }
            }
        }

        List<Map.Entry<Integer, List<int[]>>> sorted = map.entrySet().stream()
            .sorted(Comparator.comparing((Map.Entry<Integer, List<int[]>> e) -> e.getValue().size())
            .reversed()
            .thenComparing(Map.Entry::getKey))
            .collect(Collectors.toList());

        return sorted;
    }

    private static void bfs(int i, int j) {
        Deque<int[]> que = new ArrayDeque<>();
        que.offer(new int[]{i, j});
        cnt[board[i][j]]++;
        visit[i][j] = true;

        while(!que.isEmpty()) {
            int[] current = que.poll();
            for(int k = 0; k < 4; k++) {
                int ny = current[0] + dy[k];
                int nx = current[1] + dx[k];

                if(ny < 0 || nx < 0 || ny >= N || nx >= N || board[ny][nx] != board[i][j] || visit[ny][nx]) {
                    continue;
                }
                visit[ny][nx] = true;
                que.offer(new int[]{ny, nx});
            }
        }
    }

    private static void moveFunc(List<Map.Entry<Integer, List<int[]>>> list) {
        // x좌표가 최대한 작게하면서, 그런 위치가 둘이면 Y좌표가 작은 위치로
        int[][] newBoard = new int[N][N];

        for(Map.Entry<Integer, List<int[]>> x : list) {
            int id = x.getKey();
            List<int[]> pos = x.getValue();
            int[] origin = pos.get(0);

            // 1. 상대 좌표 구하기
            List<int[]> offsetList = new ArrayList<>();
            for(int[] p: pos) {
                offsetList.add(new int[]{p[0] - origin[0], p[1] - origin[1]});
            }

            // 2. 가능 한 위치 찾기 (0,0)
            outer:
            for(int j = 0; j < N; j++) {
                for(int i = 0; i < N; i++) {
                    boolean canPlace = true;

                    for(int[] offset : offsetList) {
                        int ny = i + offset[0];
                        int nx = j + offset[1];
                        if (ny < 0 || ny >= N || nx < 0 || nx >= N || newBoard[ny][nx] != 0) {
                            canPlace = false;
                            break;
                        }
                    }
                    if(canPlace) {
                        for (int[] offset : offsetList) {
                            int ny = i + offset[0];
                            int nx = j + offset[1];
                            newBoard[ny][nx] = id;
                        }
                        break outer;
                    }
                }
            }
        }
        board = newBoard;
    }

    private static int calc() {
        int answer = 0;
        int[] c = new int[Q+1];
        boolean[][] interacted = new boolean[Q + 1][Q + 1];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(board[i][j] != 0) {
                    c[board[i][j]]++;
                }
                for(int d = 0; d < 4; d++) {
                    int ny = i + dy[d];
                    int nx = j + dx[d];
                    if(ny < 0 || nx < 0 || ny >= N || nx >= N || board[ny][nx] == 0 || board[ny][nx] == board[i][j]) {
                        continue;
                    }
                    interacted[board[i][j]][board[ny][nx]] = true;
                }
            }
        }

        for (int i = 1; i <= Q; i++) {
            for (int j = i + 1; j <= Q; j++) {
                if (interacted[i][j]) {
                    answer += c[i] * c[j];
                }
            }
        }

        return answer;
    }
}