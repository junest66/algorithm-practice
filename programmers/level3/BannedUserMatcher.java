import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    static int N;
    static Map<String, Set<String>> map = new HashMap<>();  // banned, 몇개가 맞는지
    static Set<Set<String>> answer = new HashSet<>();
    static String[] ban;

    public int solution(String[] user_id, String[] banned_id) {
        N = banned_id.length;
        ban = banned_id;

        for (String x : banned_id) {
            map.computeIfAbsent(x, k -> new HashSet<>());
            for (String y : user_id) {
                if (equals(y, x)) {
                    map.get(x).add(y);
                }
            }
        }
        dfs(new HashSet<>());

        return answer.size();
    }

    private boolean equals(String str, String ban) {
        if (str.length() != ban.length()) {
            return false;
        }
        for (int i = 0; i < ban.length(); i++) {
            if (ban.charAt(i) == '*') {
                continue;
            } else if (ban.charAt(i) != str.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private void dfs(Set<String> used) {
        int depth = used.size();
        if (depth == N) { //현재 모두 사용했으면
            answer.add(new HashSet<>(used));
            return;
        }
        String str = ban[depth]; //해당 번호의 금지 문자열

        for (String x : map.get(str)) {
            if (!used.contains(x)) { //지금까지 사용했던거에서 사용안했다면
                Set<String> newSet = new HashSet<>(used);
                newSet.add(x);
                dfs(newSet);
            }
        }
    }
}
