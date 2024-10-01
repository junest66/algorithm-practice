package gold.gold5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem2011 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String str = st.nextToken();
        solution(str);
    }

    private static void solution(String num) {
        long[] dp = new long[num.length() + 1];
        long[] array = Arrays.stream(num.split("")).mapToLong(i -> Integer.parseInt(i)).toArray();
        dp[0] = 1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                if (i != 0 && (array[i - 1] == 1 || array[i - 1] == 2)) {
                    dp[i + 1] += dp[i - 1];
                    dp[i + 1] %= 1000000;
                } else {
                    System.out.println(0);
                    return;
                }
            } else if ((array[i] >= 1 && array[i] <= 6)) {
                dp[i + 1] += dp[i];
                dp[i + 1] %= 1000000;
                if (i != 0 && ((array[i - 1] == 1) || (array[i - 1] == 2))) {
                    dp[i + 1] += dp[i - 1];
                    dp[i + 1] %= 1000000;
                }
            } else {
                dp[i + 1] += dp[i];
                dp[i + 1] %= 1000000;
                if (i != 0 && (array[i - 1] == 1)) {
                    dp[i + 1] += dp[i - 1];
                    dp[i + 1] %= 1000000;
                }
            }
        }
        System.out.println(dp[num.length()]);
    }
}
