import java.util.*;
import java.util.stream.*;

class Solution {
    int n;
    boolean[][] visited;
    List<List<int[]>> tableBlocks = new ArrayList<>();
    List<List<int[]>> emptySpaces = new ArrayList<>();
    int answer;

    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};

    public int solution(int[][] game_board, int[][] table) {
        n = table.length;
        visited = new boolean[n][n];

        // 1. 테이블에서 퍼즐 조각 추출
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(table[i][j] == 1 && !visited[i][j]) {
                    List<int[]> block = new ArrayList<>();
                    dfs(i, j, table, block, 1);
                    tableBlocks.add(normalize(block));
                }
            }
        }

        // 2. game_board에서 빈 공간 추출 (0으로 된 영역)
        visited = new boolean[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(game_board[i][j] == 0 && !visited[i][j]) {
                    List<int[]> space = new ArrayList<>();
                    dfs(i, j, game_board, space, 0);
                    emptySpaces.add(normalize(space));
                }
            }
        }

        // 3. 퍼즐 조각을 4번 회전하면서 빈공간과 비교
        for(List<int[]> empty : emptySpaces) {
            boolean matched = false;

            for(int i = tableBlocks.size() - 1; i >= 0; i--) {
                List<int[]> puzzle = tableBlocks.get(i);

                for(int r = 0; r < 4; r++) {
                    if(isSame(empty, puzzle)) {
                        answer += puzzle.size();
                        tableBlocks.remove(i);
                        matched = true;
                        break;
                    }
                    puzzle = rotate(puzzle);
                }
                if(matched) break;
            }
        }
        return answer;
    }

    private void dfs(int y, int x, int[][] board, List<int[]> block, int target) {
        visited[y][x] = true;
        block.add(new int[]{y, x});

        for(int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny < 0 || nx < 0 || ny >= n || nx >= n || visited[ny][nx] || board[ny][nx] != target) {
                continue;
            }
            dfs(ny, nx, board, block, target);
        }
    }

    // 좌표를 (0, 0) 기준으로 변환
    private List<int[]> normalize(List<int[]> block) {
        List<int[]> result = new ArrayList<>();

        int minY = Integer.MAX_VALUE;
        int minX = Integer.MAX_VALUE;

        // 1. 가장 왼쪽 위 좌표(minX, minY)를 찾음
        for(int[] pos: block) {
            minY = Math.min(minY, pos[0]);
            minX = Math.min(minX, pos[1]);
        }

        // 2. (0,0)을 기준으로 좌표 이동
        for (int[] pos : block) {
            result.add(new int[]{pos[0] - minY, pos[1] - minX});
        }


        // 3. 정렬 (0,0) 부터
        result.sort(Comparator.comparingInt((int[] arr) -> arr[0]).thenComparing(arr -> arr[1]));
        return result;
    }

    // 리스트 비교함수
    private boolean isSame(List<int[]> a, List<int[]> b) {
        if (a.size() != b.size()) return false;

        for (int i = 0; i < a.size(); i++) {
            int[] p1 = a.get(i);
            int[] p2 = b.get(i);
            if (p1[0] != p2[0] || p1[1] != p2[1]) return false;
        }

        return true;
    }

    // 회전 함수
    private List<int[]> rotate(List<int[]> block) {
        List<int[]> rotated = new ArrayList<>();

        for (int[] pos : block) {
            int y = pos[0];
            int x = pos[1];
            rotated.add(new int[]{-x, y});  // 90도 회전
        }

        return normalize(rotated);  // 회전 후 정렬 및 좌상단 기준 정렬
    }
}
