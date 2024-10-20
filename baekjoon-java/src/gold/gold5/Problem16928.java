package gold.gold5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem16928 {
    public static class Node {
        int currentIndex;
        int count;

        public Node(int currentIndex, int count) {
            this.currentIndex = currentIndex;
            this.count = count;
        }
    }
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<Integer, Integer> sada = new HashMap<>();
        int answer = 200;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sada.put(start, end);
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sada.put(start, end);
        }
        Queue<Node> que = new LinkedList<>();
        que.offer(new Node(1, 0));
        while (!que.isEmpty()) {
            Node current = que.poll();
            if (current.count >= answer) {
                continue;
            }
            if (current.currentIndex == 100) {
                answer = Math.min(answer, current.count);
                continue;
            }
            boolean b = false;
            for (int i = 6; i >= 1; i--) {
                int next = current.currentIndex + i;
                if (sada.containsKey(next)) {
                    next = sada.get(next);
                    que.offer(new Node(next, current.count + 1));
                } else if (!b && next <= 100) {
                    b = true;
                    que.offer(new Node(next, current.count + 1));
                }
            }
        }
        System.out.println(answer);

    }
}
