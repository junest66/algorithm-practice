import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Deque<String> que1 = new ArrayDeque<>(Arrays.asList(cards1));
        Deque<String> que2 = new ArrayDeque<>(Arrays.asList(cards2));
        int current = 0;
        while((!que1.isEmpty() && que1.peekFirst().equals(goal[current])) || (!que2.isEmpty() && que2.peekFirst().equals(goal[current]))) {
            if(!que1.isEmpty() && que1.peekFirst().equals(goal[current])) {
                que1.pollFirst();
            } else if(!que2.isEmpty() && que2.peekFirst().equals(goal[current])) {
                que2.pollFirst();
            }
            current++;
            if(current == goal.length) {
                break;
            }
        }
        if(current != goal.length) {
            return "No";
        }
        return "Yes";
    }
}

