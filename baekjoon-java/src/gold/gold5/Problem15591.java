package gold.gold5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem15591 {
    static int[][] arr;
    static List<Node>[] nodes;
    static int n;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        nodes = new ArrayList[n + 1];
        arr = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(arr[i], -1);
            arr[i][i] = 0;
        }
        for (int i = 1; i <= n; i++) {
            nodes[i] = new ArrayList<>();
        }
        //1. 정점과 간선 채움
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            nodes[p].add(new Node(k, r));
            nodes[k].add(new Node(p, r));
            arr[p][k] = r;
            arr[k][p] = r;
        }
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int count = 0;
            func(k);
            for (int j = 1; j <= n; j++) {
                if (arr[k][j] != 0 && arr[k][j] >= p) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    private static void func(int i) {
        Queue<Node> que = new LinkedList<>();
        for (Node node : nodes[i]) {
            que.add(new Node(node.index, node.dist));
        }
        int[] visit = new int[n + 1];
        visit[i] = 1;
        while (!que.isEmpty()) {
            Node current = que.poll();
            if (arr[i][current.index] == -1) {
                arr[i][current.index] = current.dist;
                arr[current.index][i] = current.dist;
                que.offer(new Node(current.index, current.dist));
                continue;
            }
            for (Node next : nodes[current.index]) {
                if (visit[next.index] == 1) {
                    continue;
                }
                que.offer(new Node(next.index, Math.min(current.dist, next.dist)));
                visit[next.index] = 1;
            }
        }
    }

    static class Node {
        int index;
        int dist;

        public Node(int index, int dist) {
            this.index = index;
            this.dist = dist;
        }
    }
}
