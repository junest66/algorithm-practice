package silver.silver1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem12101 {
    static int n;
    static int k;
    static int count = 1;
    static String answer = "-1";

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("baekjoon-java/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        dfs(0, new ArrayList<>());
        System.out.println(answer);
    }

    private static void dfs(int sum, List<String> list) {
        if (!answer.equals("-1")) {
            return;
        }
        if (sum == n) {
            if (count == k) {
                answer = String.join("+", list);
            }
            count++;
            return;
        } else if (sum > n) {
            return;
        }

        for (int i = 1; i <= 3; i++) {
            list.add(String.valueOf(i));
            dfs(sum + i, list);
            list.remove(list.size() - 1);
        }
    }
}
