import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, Set<String>> map = new LinkedHashMap<>();
        Map<String, Integer> singo = new HashMap<>();
        for(String x: id_list) {
            map.put(x, new HashSet<>());
            singo.put(x, 0);
        }
        for(String x: report) {
            String[] arr = x.split(" ");
            if(!map.get(arr[0]).contains(arr[1])) {
                map.get(arr[0]).add(arr[1]);
                singo.put(arr[1], singo.getOrDefault(arr[1], 0) + 1);
            }
        }

        int i = 0;
        for(Map.Entry<String, Set<String>> x : map.entrySet()) {
            Set<String> set = x.getValue();
            for(String a: set) {
                if(singo.get(a) >= k) {
                    answer[i]++;
                }
            }
            i++;
        }

        return answer;
    }
}
