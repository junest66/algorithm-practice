package silver.silver2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Problem1874 {
    static int n;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int start = 1;
        boolean end = true;
        for (int i = 0; i < n; i++) {
            int num = arr[i];
            if (num >= start) {
                while (num >= start) {
                    stack.push(start++);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            } else {
                Integer a = stack.pop();
                if (a > num) {
                    System.out.println("NO");
                    end = false;
                    break;
                } else {
                    sb.append("-\n");
                }
            }
        }
        if (end) {
            System.out.println(sb);
        }
    }
}
