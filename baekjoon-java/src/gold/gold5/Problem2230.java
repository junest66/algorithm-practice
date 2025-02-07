package gold.gold5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem2230 {
    static int n;
    static int k;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stToken = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stToken.nextToken());
        k = Integer.parseInt(stToken.nextToken());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int answer = Integer.MAX_VALUE;
        int en = 0;
        for (int st = 0; st < n; st++) {
            while (en < n && arr[en] - arr[st] < k) {
                en++;
            }
            if (en == n) {
                break;
            }
            answer = Math.min(answer, arr[en] - arr[st]);
//            int target = k + arr[i];
//            if (target > arr[n - 1]) {
//                break;
//            }
//            int index = lowerBound(i);
//            if (index != arr.length) {
//                answer = Math.min(answer, arr[index] - arr[i]);
//            }
//            if (answer == k) {
//                break;
//            }
        }
        System.out.println(answer);
    }

    private static int lowerBound(int start) {
        int st = start;
        int en = arr.length;
        while (st < en) {
            int mid = (st + en) / 2;
            if (arr[mid] - arr[start] >= k) {
                en = mid;
            } else {
                st = mid + 1;
            }
        }
        return st;
    }
}
