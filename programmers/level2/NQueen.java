class Solution {
    static int answer = 0;
    static boolean[][] visited;
    static int N;

    public int solution(int n) {
        visited = new boolean[n][n];
        N = n;
        dfs(0);
        return answer;
    }

    private void dfs(int y) {
        if (y == N) {
            answer++;
            return;
        }

        for (int i = 0; i < N; i++) {
            //세로로 혹은 대각선으로 방문했으면 패스
            if (!sero(y, i) || !diagonal(y, i)) {
                continue;
            }
            visited[y][i] = true;
            dfs(y + 1);
            visited[y][i] = false;
        }
    }

    private boolean sero(int y, int x) {
        for (int j = 0; j < y; j++) {
            if (visited[j][x]) {
                return false;
            }
        }
        return true;
    }

    private boolean diagonal(int y, int x) {

        //왼쪽 대각선
        for (int i = 1; y - i >= 0 && x - i >= 0; i++) {
            if (visited[y - i][x - i]) {
                return false;
            }
        }

        //오른쪽 대각선
        for (int i = 1; y - i >= 0 && x + i < N; i++) {
            if (visited[y - i][x + i]) {
                return false;
            }
        }
        return true;
    }
}
