import java.util.*;
import java.util.stream.*;

class Solution {
    public long solution(long n) {
        // String str = String.valueOf(n);
        // String[] arr = str.split("");
        // Arrays.sort(arr, Comparator.reverseOrder());
        // String s = String.join("", arr);
        // long answer = (long)Long.valueOf(s);
        // return answer;
        return Long.parseLong(
                String.valueOf(n).chars()
                        .mapToObj(c -> String.valueOf((char) c))
                        .sorted(Comparator.reverseOrder())
                        .collect(Collectors.joining())
        );
    }
}
