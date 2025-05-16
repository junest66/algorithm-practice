package gold.gold3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Problem2143 {
    static int t;
    static int n;
    static int[] arr;
    static int m;
    static int[] brr;
    static int[] sumA;
    static int[] sumB;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        sumA = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sumA[i] = arr[i] + sumA[i - 1];
        }
        m = Integer.parseInt(br.readLine());
        brr = new int[m + 1];
        sumB = new int[m + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= m; i++) {
            brr[i] = Integer.parseInt(st.nextToken());
            sumB[i] = brr[i] + sumB[i - 1];
        }
        Map<Integer, Long> a = new HashMap<>();
        Map<Integer, Long> b = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                a.merge(sumA[j] - sumA[i - 1], 1L, Long::sum);
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = i; j <= m; j++) {
                b.merge(sumB[j] - sumB[i - 1], 1L, Long::sum);
            }
        }

        long answer = 0;
        for (Map.Entry<Integer, Long> map : a.entrySet()) {
            int key = map.getKey();
            long value = map.getValue();
            if (b.containsKey(t - key)) {
                answer += value * b.get(t - key);
            }
        }

        System.out.println(answer);
    }
}
