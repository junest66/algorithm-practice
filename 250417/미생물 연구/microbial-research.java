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

        // for(int i = 0; i < N; i++) {
        //     System.out.println(Arrays.toString(board[i]));
        // }
        // System.out.println("end ---");

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
        for(int i = 0; i < N; i++) {
            Arrays.fill(visit[i], false);
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(board[i][j] != 0 && !visit[i][j]) { //탐색
                    // System.out.println("i : " + i + " j: " + j);
                    bfs(i, j);
                }
            }
        }
        Set<Integer> st = IntStream.range(1, Q+1)
        .filter(i -> cnt[i] >= 2)
        .boxed()
        .collect(Collectors.toSet());
        // System.out.println("num :" + num);
        // System.out.println(Arrays.toString(cnt));
        // System.out.println(st);

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
        // for(Map.Entry<Integer, List<int[]>> x : sorted) {
        //     System.out.println(x.getKey());
        //     for(int[] a: x.getValue()) {
        //         System.out.println(a[0] + " " + a[1]);
        //     }
        //     System.out.println(x.getValue().size());
        // }
        // System.out.println(" ");

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
            List<int[]> pos = x.getValue();
            Collections.sort(pos, (a, b) -> {
                if(b[1] == a[1]) {
                    return a[0] - b[0];
                }
                return a[1] - b[1];
            });

            for(int j = 0; j < N; j++) {
                boolean pass = false;
                for(int i = 0; i < N; i++) {
                    List<int[]> transList = transForm(pos, i, j);
                    if(validRange(transList, newBoard)) {
                        // System.out.println("getKey()" + x.getKey());
                        // System.out.println("i " + i + " j : " +j);
                        // for(int[] abc : transList) {
                        //     System.out.println("i " + abc[0] + " j : " +abc[1]);
                        // }
                        for(int[] arr : transList) {
                            // System.out.println("arr :" + arr[0] + " " + arr[1]);
                            newBoard[arr[0]][arr[1]] = x.getKey();
                        }
                        // for(int z = 0; z < N; z++) {
                        //     System.out.println(Arrays.toString(newBoard[z]));
                        // }
                        // System.out.println();
                        pass = true;
                        break;
                    }
                }

                if(pass) {
                    break;
                }
            }
        }

        // for(int i = 0; i < N; i++) {
        //     System.out.println(Arrays.toString(newBoard[i]));
        // }
        // System.out.println("end ---");
        board = newBoard;
    }

    private static List<int[]> transForm(List<int[]> list, int i, int j) {
        int[] start = list.get(0);
        int y = i - start[0]; // 0 - 3  // -3
        int x = j - start[1]; // 0 - 0 // 0

        return list.stream()
                .map(a -> new int[]{a[0] + y, a[1] + x})
                .collect(Collectors.toList());
    }

    private static boolean validRange(List<int[]> list, int[][] board) {
        return list.stream()
        .filter(x -> x[0] < 0 || x[1] < 0 || x[0] >= N || x[1] >= N || board[x[0]][x[1]] != 0)
        .count() > 0 ? false : true;
    }

    private static int calc() {
        int answer = 0;
        int[] c = new int[Q+1];
        Map<Integer, Set<Integer>> map = new TreeMap<>();

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(board[i][j] != 0) {
                    c[board[i][j]]++;
                }
                for(int d = 0; d < 4; d++) {
                    int ny = i + dy[d];
                    int nx = j + dx[d];
                    if(ny < 0 || nx < 0 || ny >= N || nx >= N || board[ny][nx] ==0 || board[ny][nx] == board[i][j]) {
                        continue;
                    }
                    map.computeIfAbsent(board[i][j], k -> new HashSet<>()).add(board[ny][nx]);
                }
            }
        }

        for(Map.Entry<Integer, Set<Integer>> x : map.entrySet()) {
            for(Integer y : x.getValue()) {
                if(x.getKey() < y) {
                    answer += (c[x.getKey()] * c[y]);
                }
            }
        }
        return answer;
    }
}