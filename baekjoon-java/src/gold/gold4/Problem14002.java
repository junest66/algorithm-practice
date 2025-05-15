package gold.gold4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Problem14002 {
    static int n;
    static int[] arr;
    static List<Integer> list = new ArrayList<>();
    static int[] idx;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        idx = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < n; i++) {
            int index = lowerIdx(arr[i]);
            if (index == list.size()) {
                list.add(arr[i]);
            } else {
                list.set(index, arr[i]);
            }
            idx[i] = index;
        }
        System.out.println(list.size());
        int len = list.size() - 1;
        Deque<Integer> stk = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            if (len == idx[i]) {
                stk.push(arr[i]);
                len--;
            }
        }
        while (!stk.isEmpty()) {
            System.out.print(stk.pop() + " ");
        }

    }

    private static int lowerIdx(int value) {
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
