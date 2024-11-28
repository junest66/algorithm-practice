package gold.gold2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem3687 {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[]{6, 2, 5, 5, 4, 5, 6, 3, 7, 6};
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.print(minValue(n) + " ");
            System.out.println(maxValue(n));
        }

    }

    private static String minValue(int n) {
        int copyN = n;
        int total = n % 7 == 0 ? n / 7 : n / 7 + 1;
        int current = 0;
        int index = 0;
        StringBuilder sb = new StringBuilder();
        while (index != total) {
            int start = index == 0 ? 1 : 0;
            if (index + 1 == total) {
                for (; start <= 9; start++) {
                    if (arr[start] + current == n) {
                        sb.append(start);
                        break;
                    }
                }
                break;
            }
            while ((total - index - 1) * 7 < copyN - arr[start]) {
                start++;
            }
            sb.append(start);
            copyN -= arr[start];
            current += arr[start];
            index++;
        }
        return sb.toString();
    }

    private static String maxValue(int n) {
        StringBuilder sb = new StringBuilder();
        int use = 0;
        if (n % 2 == 0) {
            use += arr[1];
            sb.append("1");
        } else {
            use += arr[7];
            sb.append("7");
        }
        while (use != n) {
            sb.append("1");
            use += arr[1];
        }
        return sb.toString();
    }
}
