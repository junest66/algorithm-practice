import java.util.*;

class Solution {
    int[] dx = {0, 0, -1 , 1};
    int[] dy = {-1, 1, 0, 0};
    int n,m;
    boolean[][] vis = new boolean[5][5];
    int[][] block = new int[5][5];

    public boolean checkRange(int y, int x) {
        return x < 0 || y < 0 || y >= n || x >= m;
    }

    public int solution(int[][] board, int[] aloc, int[] bloc) {
        n = board.length;
        m = board[0].length;

        for(int i = 0; i < n ; i++) {
            for(int j = 0; j < m; j++) {
                block[i][j] = board[i][j];
            }
        }
        return solve(aloc[0], aloc[1], bloc[0], bloc[1]);
    }

    public int solve(int cury, int curx, int opy, int opx) {
        if(vis[cury][curx]) { //현재 플레이어가 밟고 있는 발판이 사라졌을때
            return 0;
        }

        int ret = 0;

        for(int i = 0; i < 4; i++) {
            int ny = cury + dy[i];
            int nx = curx + dx[i];

            if(checkRange(ny, nx) || vis[ny][nx] || block[ny][nx] == 0) {
                continue;
            }

            vis[cury][curx] = true; // 현재 플레이어가 있는 곳에 방문 표시

            int val = solve(opy, opx, ny, nx) + 1;

            vis[cury][curx] = false;

            if(ret % 2 == 0 && val % 2 == 1) { //현재 저장된 턴은 패배 & 새로 계산된 턴은 승리
                ret = val;
            } else if(ret % 2 == 0 && val % 2 == 0) { //모두 패배
                ret = Math.max(ret, val); // 최대한 늦게 지는것
            } else if(ret % 2 == 1 && val % 2 == 1) { //모두 승리
                ret = Math.min(ret, val); //빨리 이기는 것
            }
        }
        return ret;
    }
}
