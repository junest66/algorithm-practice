package platinum.platinum5;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Problem14003 {
    static List<Integer> lis = new ArrayList<>();
    static int[] idx;

    public static void main(String[] args) throws IOException {
        // 입력
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        idx = new int[n];

        for (int i = 0; i < n; i++) {
            int insertIndex = lowerBound(arr[i]);
            if (insertIndex == lis.size()) { // 리스트의 끝에 추가해야한다면
                lis.add(arr[i]);
            } else {
                lis.set(insertIndex, arr[i]); // 교체
            }
            idx[i] = insertIndex; // 현재 원소가 LIS의 몇 번째 위치인지 저장
        }
        int len = lis.size() - 1;
        StringBuilder sb = new StringBuilder();
        Stack<Integer> s = new Stack<>();

        // 뒤에서부터 LIS를 역추적하여 스택에 저장
        for (int i = n - 1; i >= 0; i--) {
            if (idx[i] == len) { // LIS의 현재 길이(len)에 해당하는 값 찾기
                s.push(arr[i]);  // LIS 원소 저장
                len--;  // 다음 원소 찾기 위해 감소
            }
        }

        // 스택에서 꺼내며 LIS를 순서대로 출력
        while (!s.isEmpty()) {
            sb.append(s.pop()).append(" ");
        }

        System.out.println(lis.size()); // LIS 길이 출력
        System.out.println(sb);
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
