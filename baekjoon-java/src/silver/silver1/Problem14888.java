package silver.silver1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Problem14888 {
    public static int totalK = 0;
    public static int answerMax = Integer.MIN_VALUE;
    public static int answerMin = Integer.MAX_VALUE;
    public static int[] arr;
    public static char[] temp;
    public static boolean[] visit;
    public static List<Character> use = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        int[] operator = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
            totalK += operator[i];
        }

        char[] op = {'+', '-', '*', '/'};
        for (int i = 0; i < operator.length; i++) {
            for (int j = 0; j < operator[i]; j++) {
                use.add(op[i]);
            }
        }
        visit = new boolean[totalK];
        temp = new char[totalK];
        func(0);
        System.out.println(answerMax);
        System.out.println(answerMin);
    }

    public static void func(int k) {
        if (totalK == k) {
            int sum = calculate(arr[0], arr[1], temp[0]);
            for(int i = 2; i < arr.length; i++) {
                sum = calculate(sum, arr[i], temp[i-1]);
            }
            if(sum > answerMax) {
                answerMax = sum;
            }
            if(sum < answerMin) {
                answerMin = sum;
            }
            return;
        }
        char lastUsed = '0';
        for (int i = 0; i < totalK; i++) {
            if (!visit[i] && use.get(i) != lastUsed) {
                visit[i] = true;
                temp[k] = use.get(i);
                func(k + 1);
                visit[i] = false;
                lastUsed = use.get(i);
            }
        }
    }

    private static int calculate(int a, int b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        } else if (op == '/') {
            if (a < 0) {
                a *= -1;
                return (a / b) * -1;
            } else {
                return a / b;
            }
        }
        return 0;
    }
}
