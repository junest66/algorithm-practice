import java.util.*;

class Solution {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] dist;
    static int n, m;
    static int[] start = new int[2];
    static int[] end = new int[2];
    static int[] labu = new int[2];
    static String[] str;
    static int answer1, answer2;

    public int solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        str = maps;
        dist = new int[n][m];

        for(int i = 0; i < maps.length; i++) {
            for(int j = 0; j < maps[i].length(); j++) {
                if(maps[i].charAt(j) == 'S') {
                    start[0] = i;
                    start[1] = j;
                } else if(maps[i].charAt(j) == 'L') {
                    labu[0] = i;
                    labu[1] = j;
                } else if(maps[i].charAt(j) == 'E') {
                    end[0] = i;
                    end[1] = j;
                }
            }
        }
        bfs(start, labu);
        if(answer1 == 0) {
            return -1;
        }
        bfs(labu, end);

        return answer2 == 0 ? -1 : answer1 + answer2;
    }

    private void init(int y, int x) {
        for(int i = 0; i < n; i++) {
            Arrays.fill(dist[i], -1);
        }
        dist[y][x] = 0;
    }

    private void bfs(int[] st, int[] goal) {
        Deque<int[]> que = new ArrayDeque<>();
        que.offer(st);
        init(st[0], st[1]);
        while(!que.isEmpty()) {
            int[] current = que.poll();
            if(current[0] == goal[0] && current[1] == goal[1]) {
                if(answer1 == 0) {
                    answer1 = dist[current[0]][current[1]];
                } else {
                    answer2 = dist[current[0]][current[1]];
                }
                break;
            }
            for(int i = 0; i < 4; i++) {
                int ny = dy[i] + current[0];
                int nx = dx[i] + current[1];
                if(ny < 0 || nx < 0 || ny >= n || nx >=m || str[ny].charAt(nx) == 'X' || dist[ny][nx] != -1) {
                    continue;
                }
                dist[ny][nx] = dist[current[0]][current[1]] + 1;
                que.offer(new int[]{ny, nx});
            }
        }
    }
}
