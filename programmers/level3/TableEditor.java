import java.util.*;

class Solution {
    static int[] prev;
    static int[] next;
    static int current;
    static Deque<Integer> stk = new ArrayDeque<>();
    static int N;
    static StringBuilder sb;


    public String solution(int n, int k, String[] cmd) {
        N = n;
        prev = new int[n];
        next = new int[n];

        sb = new StringBuilder("O".repeat(n));
        //초기화
        for(int i = 0; i < n; i++) {
            prev[i] = i-1;
            next[i] = i+1;
        }
        next[n-1] = -1;

        current = k;
        for(String str: cmd) {
            func(str);
        }
        return sb.toString();
    }

    static void func(String str) {
        if(str.startsWith("U")) {
            int x = Integer.parseInt(str.substring(2));
            while(x-- > 0) {
                current = prev[current];
            }
        } else if(str.startsWith("D")) {
            int x = Integer.parseInt(str.substring(2));
            while(x-- > 0) {
                current = next[current];
            }
        } else if(str.startsWith("C")) {
            stk.push(current);
            if(prev[current] != -1) {
                next[prev[current]] = next[current];
            }
            if(next[current] != -1) {
                prev[next[current]] = prev[current];
            }
            sb.setCharAt(current, 'X');
            if(next[current] == -1) {
                current = prev[current];
            } else {
                current = next[current];
            }
        } else { //Z
            int x = stk.pop();
            if(prev[x] != -1) {
                next[prev[x]] = x;
            }
            if(next[x] != -1) {
                prev[next[x]] = x;
            }
            sb.setCharAt(x, 'O');
        }
    }
}
