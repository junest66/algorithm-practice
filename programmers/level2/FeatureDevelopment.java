import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Deque<Integer> que = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < progresses.length; i++) {
            int count = (int) Math.ceil((double)(100 - progresses[i]) / (double) speeds[i]);
            que.addLast(count);
        }
        while(!que.isEmpty()) {
            int count = 1;
            int first = que.pollFirst();
            while(!que.isEmpty() && first >= que.peekFirst()) {
                int a = que.pollFirst();
                count++;
            }
            list.add(count);
        }

        return list.stream().mapToInt(i -> i).toArray();
    }
}
