package gold.gold5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Problem2493 {
    public static int n;
    public static int[] k;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            k[i] = Integer.parseInt(st.nextToken());
        }
        int[] solution = solution(n, k);
        System.out.println("solution = " + Arrays.toString(solution));
    }

    public static int[] solution(int n, int[] k) {
        Stack<Integer> stkIn = new Stack<>();
        Stack<Integer> stkOut = new Stack<>();
        List<Integer> answer = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            stkIn.push(i);
        }
        while (!stkIn.isEmpty()) {
            Integer value = stkIn.pop();
            if (stkOut.isEmpty()) {
                stkOut.push(value);
            } else {
                if(k[stkOut.peek()] > k[value]) {
                    stkOut.push(value);
                } else {
                    while (!stkOut.isEmpty() && k[stkOut.peek()] <= k[value]) {
                        Integer pop = stkOut.pop();
                        answer.add(value);
                    }
                }
            }
        }
        String str = "123";
        for (Character ch : str.toCharArray()) {

        }

        while (!stkOut.isEmpty()) {
            stkOut.pop();
            answer.add(0);
        }
        Collections.reverse(answer);

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

}
