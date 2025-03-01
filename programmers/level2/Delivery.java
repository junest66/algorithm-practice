import java.util.*;

class Solution {
    static int[] dist;
    static List<Node>[] adjList;

    static class Node implements Comparable<Node> {
        int index;
        int weight;

        Node(int index, int weight) {
            this.index = index;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(weight, other.weight);
        }
    }
    public int solution(int N, int[][] road, int K) {
        dist = new int[N+1]; // 1부터 시작
        Arrays.fill(dist, Integer.MAX_VALUE);
        adjList = new ArrayList[N+1]; // 인접 리스트 선언
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for(int i = 0; i < road.length; i++) {
            adjList[road[i][0]].add(new Node(road[i][1], road[i][2]));
            adjList[road[i][1]].add(new Node(road[i][0], road[i][2]));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));
        dist[1] = 0;
        while(!pq.isEmpty()) {
            Node current = pq.poll();
            if(current.weight > dist[current.index]) {
                continue;
            }
            for(Node next: adjList[current.index]) {
                if(dist[next.index] > next.weight + dist[current.index]) {
                    dist[next.index] = next.weight + dist[current.index];
                    pq.offer(next);
                }
            }
        }
        return (int)Arrays.stream(dist).filter(n -> n <= K ).count();
    }
}
