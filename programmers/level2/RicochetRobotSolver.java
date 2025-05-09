import java.util.*;

class Solution {
    static int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static char[][] arr;
    static int[][] visited;
    static int n,m;

    static class Node {
        int y, x;

        Node(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;                      // 동일 참조
            if (obj == null || getClass() != obj.getClass()) return false;

            Node node = (Node) obj;
            return y == node.y && x == node.x;                 // 값 비교
        }

        @Override
        public int hashCode() {
            return Objects.hash(y, x);
        }

        @Override
        public String toString() {
            return "y : " + y + " x : " + x;
        }
    }

    static Node end;

    public int solution(String[] board) {
        n = board.length;
        m = board[0].length();
        arr = new char[n][m];
        visited = new int[n][m];
        Node start = null;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length(); j++) {
                arr[i][j] = board[i].charAt(j);
                visited[i][j] = -1;
                if(arr[i][j] == 'R') {
                    start = new Node(i, j);
                } else if(arr[i][j] == 'G') {
                    end = new Node(i, j);
                }
            }
        }
        Deque<Node> que = new ArrayDeque<>();
        que.offer(new Node(start.y, start.x));
        visited[start.y][start.x] = 0;
        int answer = -1;
        while(!que.isEmpty()) {
            Node current = que.poll();
            if(current.equals(end)) {
                answer = visited[current.y][current.x];
                break;
            }

            for (int[] dir : DIRS) {
                Node nextNode = move(current, dir[0], dir[1]);
                if(nextNode.equals(current)) {
                    continue;
                }
                int nextCost = visited[current.y][current.x] + 1;
                if (visited[nextNode.y][nextNode.x] != -1 && visited[nextNode.y][nextNode.x] <= nextCost) continue;

                visited[nextNode.y][nextNode.x] = visited[current.y][current.x] + 1;
                que.offer(nextNode);
            }
        }

        return answer;
    }

    private Node move(Node current, int dy, int dx) {
        int ny = current.y;
        int nx = current.x;

        while (true) {
            int nextY = ny + dy;
            int nextX = nx + dx;

            if (nextY < 0 || nextX < 0 || nextY >= n || nextX >= m) break;
            if (arr[nextY][nextX] == 'D') break;

            ny = nextY;
            nx = nextX;
        }

        return new Node(ny, nx);
    }
}
