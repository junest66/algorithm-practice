package gold.gold5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem5972 {
    static public int d[];

    public static void main(String[] args) throws IOException {
        class Node implements Comparable<Node> {
            int index, dist;

            public Node(int index, int dist) {
                this.index = index;
                this.dist = dist;
            }

            @Override
            public int compareTo(Node other) {
                return this.dist - other.dist;
            }

        }
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        List<Node>[] arr = new ArrayList[v + 1];
        for (int i = 1; i <= v; i++) {
            arr[i] = new ArrayList<>();
        }
        d = new int[v + 1];
        Arrays.fill(d, Integer.MAX_VALUE);
        for (int i = 1; i <= e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[a].add(new Node(b, c));
            arr[b].add(new Node(a, c));
        }
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));
        d[1] = 0;
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            if (d[current.index] != current.dist) {
                continue;
            }
            for (Node next : arr[current.index]) {
                if (d[next.index] > d[current.index] + next.dist) {
                    d[next.index] = d[current.index] + next.dist;
                    pq.offer(new Node(next.index, d[next.index]));
                }
            }
        }
        System.out.println(d[v]);
    }
}
