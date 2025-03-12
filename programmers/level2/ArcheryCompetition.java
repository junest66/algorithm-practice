import java.util.*;

class Solution {
    static int N;
    static int[] apeach;
    static int max = 0;
    static int[] answer;

    public int[] solution(int n, int[] info) {
        apeach = info;
        backtrack(n, 0, new int[11]);
        return max == 0 ? new int[]{-1} : answer;
    }

    private void backtrack(int n, int index, int[] ryan) {
        if(n == 0) { //남은 화살이 없는경우
            calc(ryan);
            return;
        }
        for(int i = index; i <= 10; i++) {
            int cnt = Math.min(n, apeach[i] + 1);
            ryan[i] = cnt;
            backtrack(n - cnt, i + 1, ryan);
            ryan[i] = 0;
        }
    }

    private void calc(int[] ryan) {
        int score = getScore(ryan);
        if(max < score) {
            max = score;
            answer = ryan.clone();
        } else if (max > 0 && max == score) {
            for(int i = 10; i >= 0; i--) {
                if(answer[i] != ryan[i]) {
                    if(answer[i] < ryan[i]) {
                        answer = ryan.clone();
                    }
                    break;
                }
            }
        }
    }

    private int getScore(int[] ryan) {
        int score = 0;
        for(int i = 0; i <= 10; i++) {
            if(ryan[i] + apeach[i] > 0) {
                score += ryan[i] > apeach[i] ? (10 - i) : -(10 - i);
            }
        }
        return score;
    }
}
