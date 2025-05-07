import java.util.*;

class Solution {
    static boolean[][] visited;
    static char[][] arr;
    static List<Integer> list;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    static int N;
    static int M;

    public int[] solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();
        visited = new boolean[N][M];
        arr = new char[N][M];
        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = maps[i].charAt(j);
            }
        }
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(visited[i][j] == false && arr[i][j] != 'X') {
                    list.add(dfs(i,j));
                }
            }
        }
        if (list.isEmpty()) return new int[]{-1};

        return list.stream().sorted().mapToInt(i -> i).toArray();
    }

    private int dfs(int y, int x) {
        visited[y][x] = true;
        int sum = arr[y][x] - '0';
        for(int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(isValid(ny, nx)) {
                sum += dfs(ny, nx);
            }
        }
        return sum;
    }

    private boolean isValid(int y, int x) {
        return y >= 0 && x >= 0 && y < N && x < M && !visited[y][x] && arr[y][x] != 'X';
    }
}
