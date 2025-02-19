import java.util.*;

class Solution {
    static Map<Integer, HashMap<String, Integer>> map = new TreeMap<>();

    public String[] solution(String[] orders, int[] course) {
        for(int x : course) {
            map.put(x, new HashMap<>());
        }

        for(String x: orders) {
            char[] chars = x.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);
            combi(0, "", sortedStr);
        }
        List<String> answer = new ArrayList<>();
        for(HashMap<String, Integer> a : map.values()) {
            List<Map.Entry<String, Integer>> list = new ArrayList<>(a.entrySet());
            list.sort((o1, o2) -> o2.getValue() - o1.getValue());
            int max = 0;
            if(list.size() == 0) {
                continue;
            } else {
                max = list.get(0).getValue();
                if(max < 2) {
                    continue;
                }
            }

            for(Map.Entry<String, Integer> x: list) {
                if(max == x.getValue()) {
                    answer.add(x.getKey());
                } else {
                    break;
                }
            }
        }
        return answer.stream().sorted().toArray(String[]::new);
    }

    public void combi(int index, String sb, String str) {
        if(map.containsKey(sb.length())) {
            HashMap<String, Integer> score = map.get(sb.length());
            score.put(sb, score.getOrDefault(sb, 0) + 1);
        }

        for(int i = index; i < str.length(); i++) {
            combi(i+1, sb + str.charAt(i), str);
        }
    }
}
