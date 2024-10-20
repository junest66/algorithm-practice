package gold.gold5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Problem20437 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            solution(str, num);
        }
    }

    private static void solution(String str, int num) {
        int answerMin = 10005;
        int answerMax = -1;
        Map<Character, List<Integer>> map = new HashMap<>();
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            List<Integer> list = map.getOrDefault(charArray[i], new ArrayList<>());
            list.add(i);
            map.put(charArray[i], list);
            if (list.size() == num) {
                int value = list.get(list.size() - 1) - list.get(0) + 1;
                answerMin = Math.min(answerMin, value);
                answerMax = Math.max(answerMax, value);
                list.remove(0);
                map.put(charArray[i], list);
            }
        }
        if (answerMin == 10005 && answerMax == -1) {
            System.out.println("-1");
        } else {
            System.out.println(answerMin + " " + answerMax);
        }
    }
}
