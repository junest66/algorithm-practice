import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        for(String x: participant) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        for(String x: completion) {
            map.put(x, map.get(x) - 1);
        }
        String answer = "";
        for (Map.Entry<String, Integer> m : map.entrySet()) {
            if (m.getValue() != 0) {
                answer = m.getKey();
                break;
            }
        }
        return answer;
    }
}
