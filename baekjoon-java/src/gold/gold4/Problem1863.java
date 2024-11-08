package gold.gold4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Problem1863 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        Stack<Integer> stk = new Stack<>();
        int answer = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            while (!stk.isEmpty() && stk.peek() > y) { // y값이 작아지면 해당 건물보다 큰것들 다 지움
                answer++;
                stk.pop();
            }
            if (!stk.isEmpty() && stk.peek() == y) {
                continue;
            }
            stk.push(y);
        }
        while (!stk.isEmpty()) {
            if (stk.peek() > 0) {
                answer++;
            }
            stk.pop();
        }
        System.out.println(answer);
    }
}
