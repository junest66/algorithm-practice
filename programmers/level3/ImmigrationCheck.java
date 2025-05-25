import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long left = 1;
        long right = (long) Arrays.stream(times).max().getAsInt() * n;
        Arrays.sort(times);
        
        long answer = 0;
        while(left < right) {
            long mid = (left + right) / 2;
            long count = 0;
            for(int time: times) {
                count += mid / time;
            }
            if(count >= n) { //줄여봐야함
                answer = mid;
                right = mid;
            } else { //count < n 늘려야함 time을
                left = mid + 1;
            }
        }
        return answer;
    }
}
