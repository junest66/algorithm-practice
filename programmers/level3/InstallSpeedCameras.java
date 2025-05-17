import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, Comparator.comparingInt(a -> a[1]));
        int st = Integer.MIN_VALUE;
        int answer = 0;
        for (int[] route : routes) {
            if (route[0] > st) {
                st = route[1];
                answer++;
            }
        }
        return answer;
    }
}
