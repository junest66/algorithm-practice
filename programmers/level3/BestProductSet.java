import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        //최대 자연수 갯수 만개로 최대 1억 합계를 만드는 조합 중 원소의 곱이 최대가 되는 집합 구하기
        int[] answer = new int[n];
        int value = s / n;
        int a = s % n;
        if(value == 0) {
            return new int[]{-1};
        }

        Arrays.fill(answer, value);
        for (int i = n - 1; i >= n - a; i--) {
            answer[i]++;
        }

        return answer;
    }
}
