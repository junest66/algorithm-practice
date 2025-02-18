import java.util.*;

class Solution {
    static Map<String, Integer> map = new HashMap<>();
    static Map<String, Integer> wantMap = new HashMap<>();
    public int solution(String[] want, int[] number, String[] discount) {
        for(int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }
        int i = 0;
        int answer = 0;

        for(; i < discount.length && i < 10; i++) {
            map.put(discount[i], map.getOrDefault(discount[i], 0) + 1);
        }
        if(possible()) {
            answer++;
        }

        for(; i < discount.length; i++) {
            //10일전꺼 감소, 다음 날꺼 추가
            map.put(discount[i-10], map.get(discount[i-10]) - 1);
            map.put(discount[i], map.getOrDefault(discount[i], 0) + 1);
            if(possible()) {
                answer++;
            }
        }

        return answer;
    }

    public boolean possible() {
        for(Map.Entry<String,Integer> x : wantMap.entrySet()) {
            if(!map.containsKey(x.getKey()) || x.getValue() > map.get(x.getKey())) {
                return false;
            }
        }
        return true;
    }
}
