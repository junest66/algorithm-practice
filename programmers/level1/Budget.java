import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int count = 0;
        for(int i = 0; i < d.length; i++) {
            if(budget >= d[i]) {
                count++;
                budget -= d[i];
            } else {
                break;
            }
        }
        return count;
    }
}
