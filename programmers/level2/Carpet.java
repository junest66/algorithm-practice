import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};

        int maxValue = (int)Math.sqrt(brown + yellow);
        int a = 0;
        for(int b = 3; b <= maxValue; b++) {
            if((brown + 4) % 2 != 0) {
                continue;
            }
            a = (brown + 4 - (2 * b)) / 2;
            if(a * b != brown + yellow) {
                continue;
            }
            answer = new int[]{a, b};
            break;
        }
        return answer;
    }
}
