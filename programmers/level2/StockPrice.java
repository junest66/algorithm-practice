import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Deque<Integer> stk = new ArrayDeque<>();
        stk.push(0);
        for(int i = 1; i < prices.length; i++) {
            while(!stk.isEmpty() && prices[i] < prices[stk.peek()]) {
                int j = stk.pop();
                answer[j] = i - j;
            }
            stk.push(i);
        }
        while(!stk.isEmpty()) {
            int a = stk.pop();
            answer[a] = prices.length-1-a;
        }
        return answer;
    }
}
