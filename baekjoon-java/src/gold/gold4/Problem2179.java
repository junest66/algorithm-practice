package gold.gold4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem2179 {
    public static List<String> name = new ArrayList<>();
    public static int maxValue = -1;
    public static String answer1;
    public static String answer2;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            name.add(br.readLine());
        }
        for (int i = 0; i < n - 1; i++) {
            if (name.get(i).length() <= maxValue) {
                continue;
            }
            for (int j = i + 1; j < n; j++) {
                func(i, j);
            }
        }
        System.out.println(answer1);
        System.out.println(answer2);
    }

    private static void func(int i, int j) {
        String s1 = name.get(i);
        String s2 = name.get(j);
        if ((s1.charAt(0) != s2.charAt(0)) || s1.equals(s2) || s2.length() <= maxValue) {
            return;
        }
        int count = getMatchLength(name.get(i), name.get(j));
        if (count > maxValue) {
            answer1 = s1;
            answer2 = s2;
            maxValue = count;
        }
    }

    private static int getMatchLength(String s1, String s2) {
        int count = 0;
        int minLength = Math.min(s1.length(), s2.length());
        for (int i = 0; i < minLength; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                break;
            }
            count++;
        }
        return count;
    }
}
