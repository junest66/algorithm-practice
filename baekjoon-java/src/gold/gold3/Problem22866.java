package gold.gold3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Problem22866 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n + 1];
        int[] cnt = new int[n + 1];
        int[] near = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            near[i] = -100000;
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i <= n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            cnt[i] = stack.size();
            if (cnt[i] > 0) {
                near[i] = stack.peek();
            }
            stack.push(i);
        }
        stack = new Stack<>();
        for (int i = n; i > 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            int a = stack.size();
            cnt[i] += a;
            if (a > 0 && stack.peek() -i < i - near[i]) {
                near[i] = stack.peek();
            }
            stack.push(i);
        }
        for (int i = 1; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(cnt[i] + " ");
            if (cnt[i] > 0) {
                sb.append(near[i]);
            }
            sb.append("\n");
            System.out.print(sb);
        }
    }
}
