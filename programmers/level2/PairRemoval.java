import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = 0;

        Deque<Character> stk = new ArrayDeque<>();
        for(Character c : s.toCharArray()) {
            if(stk.isEmpty() || stk.peek() != c) {
                stk.push(c);
            } else if(stk.peek() == c) {
                stk.pop();
            }
        }
        if(stk.isEmpty()) {
            answer = 1;
        }

        return answer;
    }
}
