package gold.gold5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Problem2294 {
    static int n;
    static int k;
    static List<Integer> coins = new ArrayList<>();
    static int[] arr;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer((br.readLine()));
            coins.add(Integer.parseInt(st.nextToken()));
        }
        arr = new int[k + 1];
        Arrays.fill(arr, Integer.MAX_VALUE - 1);
        Collections.sort(coins);
        arr[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = coins.get(i); j <= k; j++) {
                arr[j] = Math.min(arr[j], arr[j - coins.get(i)] + 1);
            }
        }
        int answer = arr[k] == Integer.MAX_VALUE - 1 ? -1 : arr[k];
        System.out.println(answer);
    }
}
