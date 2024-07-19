import java.util.*;

class Solution {
    public int solution(String word) {
        int answer = 0;
        String[] arr = {"U", "O", "I", "E", "A"};
        int number = 0;
        Stack<String> stk = new Stack<>();
        stk.push("");
        while(!stk.isEmpty()) {
            String current = stk.pop();
            if(current.length() > 5) continue;
            if(current.equals(word)) {
                return answer;
            }
            answer++;
            for(String s: arr) {
                stk.push(current + s);
            }
        }
        return answer;
    }
}
