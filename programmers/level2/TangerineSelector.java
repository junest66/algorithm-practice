import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Long> map = Arrays.stream(tangerine)
                .boxed()
                .collect(Collectors.groupingBy(
                        i -> i,
                        Collectors.counting()
                ));

        List<Map.Entry<Integer, Long>> list = map.entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .collect(Collectors.toList());

        int count = 0;
        for(Map.Entry<Integer, Long> x : list) {
            long value = x.getValue();
            if(k <= 0) break;
            if(value <= k) {
                k -= value;
            } else {
                k = 0;
            }
            count++;
        }
        return count;
    }
}
