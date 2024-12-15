package gold.gold5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem21315 {
    static int n;
    static int[] arr;
    static List<Integer> list = new ArrayList<>();
    static List<Integer> list1 = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= 9; i++) {
            boolean answer = false;
            int temp = (int) Math.pow(2, i);
            if (temp > n) {
                break;
            }
            init();
            func1(i, n-1, 1);
            for (int j = 1; j <= 9; j++) {
                list1 = new ArrayList<>(list);
                int temp1 = (int) Math.pow(2, j);
                if (temp1 > n) {
                    break;
                }
                func2(j, n - 1, 1);
                if (checkAnswer()) {
                    answer = true;
                    System.out.println(i + " " + j);
                    break;
                }
            }
            if (answer) {
                break;
            }
        }
    }

    private static void init() {
        list.clear();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
    }

    public static void func1(int k, int n, int num) {
        if (k - num + 1 < 0) {
            return;
        }
        int temp = -1;
        if (num == 1) {
            temp = (int) Math.pow(2, k);
        } else {
            temp = (int) Math.pow(2, k - num + 1);
        }
        for (int i = 0; i < temp; i++) {
            Integer remove = list.remove(n);
            list.add(0, remove);
        }
        func1(k, temp-1, num + 1);
    }

    public static void func2(int k, int n, int num) {
        if (k - num + 1 < 0) {
            return;
        }
        int temp = -1;
        if (num == 1) {
            temp = (int) Math.pow(2, k);
        } else {
            temp = (int) Math.pow(2, k - num + 1);
        }
        for (int i = 0; i < temp; i++) {
            Integer remove = list1.remove(n);
            list1.add(0, remove);
        }
        func2(k, temp-1, num + 1);
    }

    public static boolean check(int temp) {
        int i = n - 1;
        boolean check = true;
        while (temp != 0) {
            if (list1.get(i) != arr[i]) {
                check = false;
                break;
            }
            i--;
        }
        return check;
    }

    public static boolean checkAnswer() {
        boolean answer = true;
        for (int i = 0; i < list1.size(); i++) {
            if (arr[i] != list1.get(i)) {
                answer = false;
                break;
            }
        }
        return answer;
    }
}
