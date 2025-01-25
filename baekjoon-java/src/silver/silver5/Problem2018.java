package silver.silver5;

import java.io.IOException;
import java.util.Scanner;

public class Problem2018 {
    static int n;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int start = 1;
        int end = 1;
        int count = 1;
        int sum = 1;
        while (end != n) {
            if (sum == n) {
                count++;
                end++;
                sum += end;
            } else if (sum < n) {
                end++;
                sum += end;
            } else {
                sum -= start;
                start++;
            }
        }
        System.out.println(count);

    }
}
