package gold.gold2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem12015 {
    static List<Integer> lis = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        // 입력
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            int insertIndex = lowerBound(arr[i]);
            if (insertIndex == lis.size()) { // 리스트의 끝에 추가해야한다면
                lis.add(arr[i]);
            } else {
                lis.set(insertIndex, arr[i]); // 교체
            }
        }
        System.out.println(lis.size());
    }

    private static int lowerBound(int value) {
        int st = 0;
        int en = lis.size();
        while (st < en) {
            int mid = (st + en) / 2;
            if (lis.get(mid) >= value) {
                en = mid;
            } else {
                st = mid + 1;
            }
        }
        return st;
    }
}
