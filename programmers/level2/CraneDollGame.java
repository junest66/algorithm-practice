import java.util.*;

class Solution {
    static Deque<Integer> stk = new ArrayDeque<>();
    static int[][] arr;
    static int answer;

    public int solution(int[][] board, int[] moves) {
        arr = board;
        for(int x : moves) {
            catchDoll(x-1);
        }
        return answer;
    }

    public void catchDoll(int number) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i][number] != 0) {
                pushBasket(arr[i][number]);
                arr[i][number] = 0;
                break;
            }
        }
    }

    public void pushBasket(int a) {
        if(stk.isEmpty() || stk.peek() != a) {
            stk.push(a);
        } else {
            stk.pop();
            answer += 2;
        }
    }
}
