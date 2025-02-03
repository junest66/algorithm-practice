package silver.silver4;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Problem1920 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int answer = 0;
            int target = sc.nextInt();
            int start = 0;
            int end = arr.length - 1;
            while (start <= end) {
                int mid = (start + end) / 2;
                int midValue = arr[mid];
                if (target < midValue) {
                    end = mid - 1;
                } else if (target > midValue) {
                    start = mid + 1;
                } else {
                    answer = 1;
                    break;
                }
            }
            System.out.println(answer);
        }
    }
}
