import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String[] gems) {
        Set<String> gemSet = new HashSet<>(Arrays.asList(gems));
        int totalKinds = gemSet.size();
        Map<String, Integer> map = new HashMap<>();
        int start = 0, end = 0;
        int minLen = Integer.MAX_VALUE;
        int[] answer = new int[2];

        while(end < gems.length) {
            map.merge(gems[end++], 1, Integer::sum);

            while(map.size() == totalKinds) {
                if(end - start < minLen) {
                    minLen = end - start;
                    answer[0] = start + 1; //1 -based
                    answer[1] = end; // 1 -based
                }
                map.put(gems[start], map.get(gems[start]) - 1);
                if (map.get(gems[start]) == 0) {
                    map.remove(gems[start]);
                }
                start++;
            }
        }
        return answer;
    }
}
