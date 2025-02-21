import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> set = new HashSet<>();
        char post = words[0].charAt(0);
        int[] answer = new int[2];
        for(int i = 0; i < words.length; i++) {
            // 3으로 나눴을때 나머지가 자기 순번 (마지막에 +1), 몫이 차례 (1번부터니깐 마지막에 +1 해야함)
            // 1. 이미 나왔던거 확인
            // 2. 전 끝과 첫글자가 같은지
            if(set.contains(words[i])) {
                answer[0] = (i % n) + 1;
                answer[1] = (i / n) + 1;
                break;
            }
            if(words[i].charAt(0) != post) {
                answer[0] = (i % n) + 1;
                answer[1] = (i / n) + 1;
                break;
            }
            set.add(words[i]);
            post = words[i].charAt(words[i].length() - 1);
        }
        return answer;
    }
}
