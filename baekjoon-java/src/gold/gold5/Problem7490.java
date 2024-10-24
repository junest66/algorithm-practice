package gold.gold5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem7490 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int value = Integer.parseInt(st.nextToken());
            solution(value);
            System.out.println();
        }

    }

    private static void solution(int value) {
        int[] arr = new int[value - 1];
        dfs(arr, 0);
    }

    private static void dfs(int[] arr, int index) {
        if (index == arr.length) {
            func(arr);
            return;
        }
        for (int i = 0; i < 3; i++) {
            arr[index] = i;
            dfs(arr, index + 1);
        }
    }

    private static void func(int[] arr) {
        List<Integer> list = new ArrayList<>();
        StringBuilder answer = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        sb.append("1");
        int index = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                sb.append(" ");
                sb.append(++index); //공백
            } else if (arr[i] == 1) {
                answer.append(sb.toString());
                list.add(Integer.parseInt(sb.toString().replace(" ", ""))); // +
                sb = new StringBuilder();
                sb.append("+");
                sb.append(++index);
            } else { // -
                answer.append(sb.toString());
                list.add(Integer.parseInt(sb.toString().replace(" ", "")));
                sb = new StringBuilder();
                sb.append("-");
                sb.append(++index);
            }
        }
        answer.append(sb.toString());
        list.add(Integer.parseInt(sb.toString().replace(" ", "")));
        if (list.stream().mapToLong(Integer::intValue).sum() == 0) {
            System.out.println(answer);
        }
    }
}
