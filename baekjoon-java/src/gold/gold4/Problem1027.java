package gold.gold4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1027 {
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int answer = 0;
        for (int i = 0; i < n; i++) {
            int temp = 0;
            temp += left(i);
            temp += right(i);
            answer = Math.max(answer, temp);
        }
        System.out.println(answer);
    }

    private static int right(int i) {
        double rightHigh = 0;
        int count = 0;
        for (int j = i + 1; j < arr.length; j++) {
            double temp = (double) (arr[j] - arr[i]) / (j - i);
            if (j == i + 1 || temp > rightHigh) {
                count++;
                rightHigh = temp;
            }
        }
        return count;
    }

    private static int left(int i) {
        double leftHigh = 0;
        int count = 0;
        for (int j = i - 1; j >= 0; j--) {
            double temp = (double) (arr[i] - arr[j]) / (i - j);
            if (j == i - 1 || leftHigh > temp) {
                count++;
                leftHigh = temp;
            }
        }
        return count;
    }
}
