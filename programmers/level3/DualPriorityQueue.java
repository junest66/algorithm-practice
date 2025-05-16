import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
        Map<Integer, Integer> countMap = new HashMap<>();

        for(String x : operations) {
            String[] str = x.split(" ");
            String c = str[0];
            String number = str[1];
            Integer a = Integer.parseInt(number);
            if(c.equals("I")) {
                minPq.offer(a);
                maxPq.offer(a);
                countMap.merge(a, 1, Integer::sum);
            } else {
                if (countMap.isEmpty()) continue;
                PriorityQueue<Integer> target = a == 1 ? maxPq : minPq;
                while (!target.isEmpty()) {
                    int cur = target.poll();
                    if (!countMap.containsKey(cur)) continue; //이미 삭제 된것임
                    if (countMap.get(cur) == 1) {
                        countMap.remove(cur);
                    } else {
                        countMap.put(cur, countMap.get(cur) - 1);
                    }
                    break;
                }
            }
        }
        // 이미 삭제된것 처리
        while (!maxPq.isEmpty() && !countMap.containsKey(maxPq.peek())) {
            maxPq.poll();
        }
        while (!minPq.isEmpty() && !countMap.containsKey(minPq.peek())) {
            minPq.poll();
        }
        if (countMap.isEmpty()) {
            return new int[]{0, 0};
        } else {
            return new int[]{maxPq.peek(), minPq.peek()};
        }
    }
}
