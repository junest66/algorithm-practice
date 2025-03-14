import java.util.*;

class Solution {
    public int[] solution(String s) {
        Map<Integer, Integer> map = new HashMap<>(); // 해당 숫자, 빈도 수
        String[] arr = s.replaceAll("[{}]", "").split(",");
        Arrays.stream(arr)
                .map(Integer::parseInt)
                .forEach(i -> map.merge(i, 1, Integer::sum));
        return map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
