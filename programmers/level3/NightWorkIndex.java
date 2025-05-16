import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        int totalWork = Arrays.stream(works).sum();
        if (totalWork <= n) return 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int x : works) {
            pq.offer(x);
        }
        while (n-- > 0) {
            pq.offer(pq.poll() - 1);
        }
        long answer = 0;
        while(!pq.isEmpty()) {
            answer += Math.pow(pq.poll(), 2);
        }
        return answer;
    }
}
