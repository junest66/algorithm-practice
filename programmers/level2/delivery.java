import java.util.*;

class Solution {
    public class Node implements Comparable<Node> {
        int dist;
        int index;

        public Node(int dist, int index) {
            this.dist = dist;
            this.index = index;
        }

        @Override
        public int compareTo(Node onode) {
            return this.dist - onode.dist;
        }
    }
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        List<List<Node>> list = new ArrayList<>();
        for(int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }
        for(int[] x : road) {
            list.get(x[0]).add(new Node(x[2], x[1]));
            list.get(x[1]).add(new Node(x[2], x[0]));
        }
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, 1));
        while(!pq.isEmpty()) {
            Node current = pq.poll();

            if(current.dist > dist[current.index]) {
                continue;
            }
            for(Node x: list.get(current.index)) {
                if(dist[x.index] > dist[current.index] + x.dist) {
                    dist[x.index] = dist[current.index] + x.dist;
                    pq.offer(new Node(dist[x.index], x.index));
                }
            }
        }
        return (int) Arrays.stream(dist)
                .filter(d -> d <= K)
                .count();
    }
}
