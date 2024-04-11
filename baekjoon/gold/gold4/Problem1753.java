package gold.gold4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem1753 {
    static int[] d;

    static class Node implements Comparable<Node> {
        int index;
        int dist;

        Node(int index, int dist) {
            this.index = index;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return this.dist - o.dist;
        }

    }

    public static String solution(int v, int e, int start, int[][] arr) {
        d = new int[v+1];
        List<Node>[] edgesList = new ArrayList[v+1];
        for(int i = 1; i <= v; i++) {
            edgesList[i] = new ArrayList<>();
        }
        for(int i = 0; i < arr.length; i++) {
                edgesList[arr[i][0]].add(new Node(arr[i][1], arr[i][2]));
        }

        Arrays.fill(d, Integer.MAX_VALUE);

        PriorityQueue<Node> que = new PriorityQueue<>();
        que.add(new Node(start, 0));
        d[start] = 0;

        while (!que.isEmpty()) {
            Node node = que.poll();
            if(node.dist != d[node.index]) {
                continue;
            }
            for(Node nx : edgesList[node.index]) {
                if(d[nx.index] <= d[node.index] + nx.dist) {
                    continue;
                }
                d[nx.index] = d[node.index] + nx.dist;
                que.offer(new Node(nx.index, d[nx.index]));
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= v; i++) {
            if(Integer.MAX_VALUE == d[i]) {
                sb.append("INF\n");
            } else {
                sb.append(d[i] + "\n");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());
        int[][] arr = new int[e][3];
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken()); // 노드1
            arr[i][1] = Integer.parseInt(st.nextToken()); // 노드2
            arr[i][2] = Integer.parseInt(st.nextToken()); // 비용
        }

        String str = solution(v, e, start, arr);
        System.out.println(str);
    }
}


