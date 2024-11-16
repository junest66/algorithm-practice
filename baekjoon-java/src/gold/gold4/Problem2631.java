package gold.gold4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Problem2631 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        List<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        for (int i = 1; i < n; i++) {
            int lowerIdx = lowerBound(list, arr[i]);
            if (lowerIdx == list.size()) {
                list.add(arr[i]);
            } else {
                list.set(lowerIdx, arr[i]);
            }
        }
        System.out.println(list);
    }

    private static int lowerBound(List<Integer> list, int value) {
        int left = 0;
        int right = list.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid) >= value) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
