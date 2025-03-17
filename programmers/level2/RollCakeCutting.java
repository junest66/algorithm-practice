import java.util.*;

class Solution {
    public int solution(int[] topping) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < topping.length; i++) {
            map.merge(topping[i], 1, Integer::sum);
        }
        int rightSize = map.size();

        int answer = 0;
        Set<Integer> left = new HashSet<>();
        for (int t : topping) {
            if (map.get(t) == 1) {
                map.remove(t);
                rightSize--;
            } else {
                map.put(t, map.get(t) - 1);
            }

            left.add(t);
            if (left.size() == rightSize) {
                answer++;
            }
        }
        return answer;
    }
}
