package gold.gold4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Problem12886 {
    static boolean[][] visited;
    static int sum = 0;
    static boolean answer;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[3];
        visited = new boolean[501][501];
        for (int i = 0; i < 3; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        sum = Arrays.stream(arr).sum();
        if (sum != 0) {
            System.out.println(0);
        } else {
            func(arr[0], arr[1]);
        }

    }

    private static void func(int a, int b) {
        int c = sum - a - b;
        if (visited[a][b]) {
            return;
        }
        visited[a][b] = true;
        if ((a + b + c) % 3 == 0) {
            answer = true;
            return;
        }
        for (int[] next : nextFunc(a, b, c)) {
            if (!visited[next[0]][next[1]]) {
                func(next[0], next[1]);
            }
        }
    }

    private static List<int[]> nextFunc(int a, int b, int c) {
        List<int[]> nextStates = new ArrayList<>();
        int[] arr = new int[]{a, b, c};
        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < 3; j++) {
                if (arr[i] == arr[j]) {
                    continue;
                }

                int[] temp = arr.clone();
                int x = arr[i];
                int y = arr[j];

                int nx = x + x;
                int ny = y - x;

                if (x < y) {
                    temp[i] = nx;
                    temp[j] = ny;
                } else {
                    temp[i] = x - y;
                    temp[j] = y + y;
                }

                nextStates.add(temp);
            }
        }
        return nextStates;
    }
}
