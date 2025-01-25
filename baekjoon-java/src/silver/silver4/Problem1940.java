package silver.silver4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem1940 {
    static int n;
    static int k;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int count = 0;
        Arrays.sort(arr);
        int start = 0;
        int end = n - 1;
        while (start < end) {
            if (arr[start] + arr[end] == k) {
                count++;
                start++;
                end--;
            } else if (arr[start] + arr[end] > k) {
                end--;
            } else {
                start++;
            }
        }
        System.out.println(count);
    }
}
