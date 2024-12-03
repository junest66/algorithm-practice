package gold.gold3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Problem10021 {
    static int[] parent;
    static int n;
    static int c;
    static List<Node> nodeList = new ArrayList<>();
    static List<int[]> list = new ArrayList<>();

    public static void init() {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i; //자기자신
        }
    }

    public static int find(int n) {
        if (n == parent[n]) {
            return n;
        }
        return parent[n] = find(parent[n]);
    }

    public static boolean union(int v1, int v2) {
        int parentV1 = find(v1);
        int parentV2 = find(v2);
        if (parentV1 == parentV2) {
            return false;
        }
        if (parentV1 < parentV2) {
            parent[parentV2] = parentV1;
        } else {
            parent[parentV1] = parentV2;
        }
        return true;
    }

    static class Node implements Comparable<Node> {
        int start;
        int end;
        int dist;

        public Node(int start, int end, int dist) {
            this.start = start;
            this.end = end;
            this.dist = dist;
        }

        public int compareTo(Node other) {
            return Integer.compare(dist, other.dist);
        }
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        init();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new int[]{a, b});
        }
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                register(i, j);
            }
        }
        Collections.sort(nodeList);
        long answer = 0;
        int cnt = 0;
        for (int i = 0; i < nodeList.size(); i++) {
            Node currentNode = nodeList.get(i);
            if (!union(currentNode.start, currentNode.end)) {
                continue;
            }
            answer += currentNode.dist;
            cnt++;
            if (cnt == n - 1) {
                break;
            }
        }
        if (cnt != n - 1) {
            System.out.println("-1");
        } else {
            System.out.println(answer);
        }
    }

    private static void register(int i, int j) {
        int[] node1 = list.get(i);
        int[] node2 = list.get(j);
        int dist = (int) (Math.pow(node1[0] - node2[0], 2) + Math.pow(node1[1] - node2[1], 2));
        if (dist >= c) {
            nodeList.add(new Node(i, j, dist));
            nodeList.add(new Node(j, i, dist));
        }
    }
}
