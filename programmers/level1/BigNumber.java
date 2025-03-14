import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(int[] numbers) {
        String result = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .sorted((o1, o2) -> (o2 + o1).compareTo(o1 + o2))
                .collect(Collectors.joining());

        return result.startsWith("0") ? "0" : result;
    }
}
