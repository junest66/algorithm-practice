package gold.gold4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Problem11657 {
    static class Edge {
        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    static int n;
    static int m;
    static List<Edge> edges = new ArrayList<>();
    static long[] arr;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new long[n + 1];
        Arrays.fill(arr, Integer.MAX_VALUE);
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edges.add(new Edge(start, end, weight));
        }
        arr[1] = 0;
        for (int i = 1; i < n; i++) {
            for (Edge edge : edges) {
                if (arr[edge.start] != Integer.MAX_VALUE && arr[edge.start] + edge.weight < arr[edge.end]) {
                    arr[edge.end] = arr[edge.start] + edge.weight;
                }
            }
        }

        for (Edge edge : edges) {
            if (arr[edge.start] != Integer.MAX_VALUE && arr[edge.start] + edge.weight < arr[edge.end]) {
                System.out.println(-1);
                return;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= n; i++) {
            if (arr[i] == Integer.MAX_VALUE) {
                sb.append("-1\n");
            } else {
                sb.append(arr[i] + "\n");
            }
        }
        System.out.print(sb.toString());
    }
}
