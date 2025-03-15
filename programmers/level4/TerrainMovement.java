import java.util.*;

class Solution {
    int[] dy = {0, 0, 1, -1};
    int[] dx = {1, -1, 0, 0};
    int total = 0;
    boolean[][] visited;

    public class Node {
        int y, x, dist;

        public Node(int y, int x, int dist) {
            this.y = y;
            this.x = x;
            this.dist = dist;
        }

        public int getDist() {
            return this.dist;
        }
    }

    public int solution(int[][] land, int height) {
        int N = land.length;
        int M = land[0].length;
        visited = new boolean[land.length][land[0].length];
        PriorityQueue<Node> que = new PriorityQueue<>(Comparator.comparingInt(Node::getDist));
        que.offer(new Node(0, 0, 0)); //초기
        while(!que.isEmpty()) { // 제일 바깥 bfs
            Node current = que.poll();
            if(visited[current.y][current.x]) continue;
            total += current.dist;
            visited[current.y][current.x] = true;
            int curY = current.y;
            int curX = current.x;
            for(int i = 0; i < 4; i++) {
                int ny = curY + dy[i];
                int nx = curX + dx[i];
                if(ny < 0 || nx <0 || ny >= N || nx >= M) continue;
                if(visited[ny][nx]) continue;
                int q = land[curY][curX] - land[ny][nx];
                int absQ = Math.abs(q);
                if(absQ > height) {
                    que.offer(new Node(ny, nx, absQ)); // 사다리 필요
                } else {
                    que.offer(new Node(ny, nx, 0)); // 사다리 필요 없음
                }
            }
        }
        return total;
    }
}
