package gold.gold5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Problem2565 {
    static int n;
    static int[][] arr;
    static int[] dp;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][2];
        dp = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0]);

//        for (int i = 0; i < n; i++) { //dp
//            dp[i] = 1;
//            for (int j = 0; j < i; j++) {
//                if (arr[i][1] > arr[j][1]) {
//                    dp[i] = Math.max(dp[i], dp[j] + 1);
//                }
//            }
//        }
//        System.out.println(n - Arrays.stream(dp).max().getAsInt());
        //이분탐색
        list.add(arr[0][1]);
        for (int i = 1; i < n; i++) {
            int idx = lowerBound(arr[i][1]);
            if (idx == list.size()) {
                list.add(arr[i][1]);
            } else {
                list.set(idx, arr[i][1]);
            }
        }
        System.out.println(n - list.size());
    }

    private static int lowerBound(int value) {
        int st = 0;
        int en = list.size();
        while (st < en) {
            int mid = (st + en) / 2;
            if (list.get(mid) >= value) {
                en = mid;
            } else {
                st = mid + 1;
            }
        }
        return st;
    }
}
