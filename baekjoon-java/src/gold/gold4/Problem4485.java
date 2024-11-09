package gold.gold4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem4485 {
    // 시작부터 목적지까지 최소한의 가중치의 크기를 구하는 문제
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        while (true) {
            count++;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) {
                break;
            }
            int[][] arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int minDist = dijkstra(arr, n);
            System.out.println("Problem " + count + ": " + minDist);
        }
    }

    private static class Node implements Comparable<Node> {
        int dist;
        int x;
        int y;

        public Node(int dist, int y, int x) {
            this.dist = dist;
            this.y = y;
            this.x = x;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(dist, other.dist);
        }
    }

    private static int dijkstra(int[][] arr, int n) {
        int[][] d = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(d[i], Integer.MAX_VALUE);
        }
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        pq.offer(new Node(arr[0][0], 0, 0));
        d[0][0] = arr[0][0];
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            if (d[current.y][current.x] != current.dist) {
                continue;
            }
            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                    continue;
                }
                if (d[ny][nx] > d[current.y][current.x] + arr[ny][nx]) {
                    d[ny][nx] = d[current.y][current.x] + arr[ny][nx];
                    pq.offer(new Node(d[ny][nx], ny, nx));
                }
            }
        }
        return d[n - 1][n - 1];
    }
}
