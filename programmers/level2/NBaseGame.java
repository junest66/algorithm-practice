import java.util.ArrayList;
import java.util.List;

public class NBaseGame {
    public String solution(int n, int t, int m, int p) {
        int totalLength = t * m;
        List<String> list = new ArrayList<>();
        for (int i = 0; ; i++) {
            if (list.size() >= totalLength) {
                break;
            }
            String s = Integer.toString(i, n);
            for (char c : s.toCharArray()) {
                list.add(String.valueOf(c).toUpperCase());
            }
        }
        StringBuilder answer = new StringBuilder();
        for (int i = p - 1; i < list.size(); i += m) {
            answer.append(list.get(i));
        }
        return answer.toString();
    }
}
