import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public static class Node implements Comparable<Node> {
        int y, x, cost;
        int direction; // 0 - 상 , 1 - 하 , 2 - 좌 , 3 - 우

        public Node(int y, int x, int cost, int direction) {
            this.y = y;
            this.x = x;
            this.cost = cost;
            this.direction = direction;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(cost, other.cost);
        }
    }

    static int n, m;
    static int answer = Integer.MAX_VALUE;
    static int[] dy = {-1, 1, 0, 0}; //상, 하, 좌. 우
    static int[] dx = {0, 0, -1, 1};
    static int[][][] dist;

    public int solution(int[][] board) {
        n = board.length;
        m = board[0].length;
        dist = new int[n][m][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(dist[i][j], Integer.MAX_VALUE);  // 최대값으로 초기화
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int d = 0; d < 4; d++) {
            dist[0][0][d] = 0;
            pq.offer(new Node(0, 0, 0, d));
        }

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int cy = current.y;
            int cx = current.x;
            int ccost = current.cost;
            int cdir = current.direction;

            if (cy == n - 1 && cx == m - 1) {
                answer = Math.min(answer, ccost);
                continue;
            }

            if (dist[cy][cx][cdir] < ccost) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int ny = current.y + dy[i];
                int nx = current.x + dx[i];
                if (ny < 0 || nx < 0 || ny >= n || nx >= m || board[ny][nx] == 1) {
                    continue;
                }
                int nextCost = ccost + 100;
                if (isCorner(cdir, i)) {
                    nextCost += 500;
                }
                if (dist[ny][nx][i] > nextCost) { //처음 가거나 이미 갔지만 가는게 이득인경우
                    dist[ny][nx][i] = nextCost;
                    pq.offer(new Node(ny, nx, nextCost, i));
                }
            }
        }

        return answer;
    }


    public boolean isCorner(int current, int next) {
        if (current == -1) {
            return false;
        }
        if (current == 0 || current == 1) { //상,하
            return next == 2 || next == 3;
        } else { //좌,우
            return next == 0 || next == 1;
        }
    }
}
