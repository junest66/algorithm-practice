import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int cnt = 1 + 2 * w;
        int answer = 0;
        int start = 1;

        for(int i = 0; i < stations.length; i++) {
            int a = stations[i];
            int left = a - w;
            int right = a + w;
            if(start < left) { //커버하지 못하는 부분이 존재
                int count = left - start;
                answer += (int) Math.ceil((double)count / cnt);
            }
            start = (right + 1);
        }

        if(n >= start) {
            int count = n+1 - start;
            answer += (int) Math.ceil((double)count / cnt);
        }

        return answer;
    }
}
