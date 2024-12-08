package gold.gold1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem1800 {
    static int n;
    static int p;
    static int k;
    static List<Node>[] list;
    static int[] dist;

    static class Node implements Comparable<Node> {
        int index;
        int dist;

        public Node(int index, int dist) {
            this.index = index;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node other) {
            return dist - other.dist;
        }
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        list = new ArrayList[n + 1];
        dist = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        int end = 0;
        for (int i = 1; i <= p; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int last = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            list[start].add(new Node(last, dist));
            list[last].add(new Node(start, dist));
            end = Math.max(end, dist);
        }
        int start = 0;
        int answer = Integer.MIN_VALUE;

        while (start <= end) {
            int mid = (start + end)  / 2;
            if (func(mid)) {
                answer = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        if (answer == Integer.MIN_VALUE) {
            System.out.println("-1");
        } else {
            System.out.println(answer);
        }

    }

    private static boolean func(int mid) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        pq.offer(new Node(1, 0));
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            if (dist[current.index] < current.dist) {
                continue;
            }
            for (Node next : list[current.index]) {
                int nextCost = current.dist;
                if (next.dist > mid) {
                    nextCost++;
                }
                if (nextCost < dist[next.index]) {
                    dist[next.index] = nextCost;
                    pq.offer(new Node(next.index, dist[next.index]));
                }
            }
        }
        return dist[n] <= k;
    }
}
