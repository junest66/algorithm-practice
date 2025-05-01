import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Deque<Integer> que = new ArrayDeque<>();
        for(int i = 0; i < bridge_length; i++) {
            que.offer(0);
        }

        int index = 0;
        int total = 0;

        while (index < truck_weights.length) {
            answer++;
            total -= que.poll();

            if (total + truck_weights[index] <= weight) {
                que.offer(truck_weights[index]);
                total += truck_weights[index];
                index++;
            } else {
                que.offer(0);
            }
        }

        while(total != 0) {
            answer++;
            total -= que.poll();
        }

        //  0 | 0
        //  0 | 7 - 1
        //  7 | 0 - 2
        //  0 | 4 - 3
        //  4 | 5 - 4
        //  5 | 0 - 5
        //  0 | 6 - 6
        //  6 | 0 - 7
        //  0 | 0 - 8

        return answer;
    }
}
