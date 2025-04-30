import java.util.*;

class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for(int i = 0; i < numbers.length; i++) {
            answer[i] = func(numbers[i]);
        }
        return answer;
    }

    private long func(long a) {
        //짝수면
        if(a % 2 == 0) {
            return a+1;
        }
        long bit = 1;
        while((a & bit) != 0) {
            bit <<= 1;
        }
        return a + (bit >> 1);
    }
}
