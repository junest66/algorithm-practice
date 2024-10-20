package silver.silver5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem10815 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] check = new int[m];
        for (int i = 0; i < m; i++) {
            check[i] = Integer.parseInt(st.nextToken());
        }
        solution(n, arr, m, check);
    }

    private static void solution(int n, int[] arr, int m, int[] check) {
        Arrays.sort(arr);
        for (int i = 0; i < check.length; i++) {
            if (Arrays.binarySearch(arr, check[i]) >= 0) {
                System.out.print(1);
                System.out.print(" ");
            } else {
                System.out.print(0);
                System.out.print(" ");
            }
        }
    }

    public int solution(int[] A) {
        // Implement your solution here
        // dp[i] = A[i] + (MAX(dp[i-1,i-2, i-3, i-4, i-5, i-6]))
        int[] dp = new int[A.length];
        dp[0] = A[0];
        for(int i = 1; i < A.length; i++) {
            if(i <= 6) {
                dp[i] = Math.max(dp[i-1] + A[i], A[i]);
            } else {
                int[] copy = Arrays.copyOfRange(dp, i-6, i);
                Arrays.stream(copy).max().orElse(0);
            }
        }
        return 0;
    }
}
