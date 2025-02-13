import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(String s) {
        List<Character> list = s.chars().mapToObj(c -> (char) c).collect(Collectors.toList());

        int answer = 0;
        for(int i = 0; i < s.length(); i++) {
            if(i != 0) {
                list.add(0, list.remove(list.size() - 1));
            }
            if(func(list)) {
                answer++;
            }
        }
        return answer;
    }

    public boolean func(List<Character> list) {
        Deque<Character> stk = new ArrayDeque<>();
        for(Character c : list) {
            if(isOpenCharacter(c)) {
                stk.push(c);
            } else {
                if(stk.isEmpty() || !isIssue(stk.pop(), c)) {
                    return false;
                }
            }
        }
        return stk.isEmpty();
    }

    public boolean isOpenCharacter(Character c) {
        return c == '[' || c =='(' || c =='{';
    }

    public boolean isIssue(Character c1, Character c2) {
        if(c2 == ']' && c1 != '[') {
            return false;
        }
        if(c2 == '}' && c1 != '{') {
            return false;
        }
        if(c2 == ')' && c1 != '(') {
            return false;
        }
        return true;
    }
}
