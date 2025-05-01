import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Deque<Character> stk = new ArrayDeque<>();

        for (char digit : number.toCharArray()) {
            while (!stk.isEmpty() && k > 0 && stk.peek() < digit) {
                stk.pop();
                k--;
            }
            stk.push(digit);
        }

        while (k-- > 0) {
            stk.pop();
        }

        StringBuilder sb = new StringBuilder();
        for (char c : stk) {
            sb.append(c);
        }

        return sb.reverse().toString();
    }
}
