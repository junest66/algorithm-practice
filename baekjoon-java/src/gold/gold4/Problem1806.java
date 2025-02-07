package gold.gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1806 {
    static int n, s;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = Integer.MAX_VALUE;
        int sum = 0;
        int end = 0;

        for (int start = 0; start < n; start++) {
            while (end < n && sum < s) {
                sum += arr[end];
                end++;
            }
            if (sum >= s) {
                answer = Math.min(answer, end - start);
            }
            sum -= arr[start];
        }

        System.out.println(answer == Integer.MAX_VALUE ? 0 : answer);
    }
}
