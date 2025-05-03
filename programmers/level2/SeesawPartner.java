import java.util.*;

class Solution {
    public long solution(int[] weights) {
        Map<Double, Integer> weightCount = new HashMap<>();
        long answer = 0;
        Arrays.sort(weights);

        for (int weight : weights) {

            // 현재 몸무게와 비율이 맞는 짝이 기존에 있었는지 확인
            answer += weightCount.getOrDefault(weight * 1.0, 0);
            answer += weightCount.getOrDefault(weight * 2.0 / 3.0, 0);  // 2:3 비율
            answer += weightCount.getOrDefault(weight / 2.0, 0);      // 1:2 비율
            answer += weightCount.getOrDefault(weight * 3.0 / 4, 0);  // 3:4 비율

            // 현재 몸무게를 Map에 저장
            weightCount.put(weight * 1.0, weightCount.getOrDefault(weight * 1.0, 0) + 1);
        }

        return answer;
    }
}
