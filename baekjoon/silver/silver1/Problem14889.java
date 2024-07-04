package silver.silver1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem14889 {
    public static int[][] arr;
    public static int n;
    public static int[] temp;
    public static int[] cur;
    public static boolean[] visit;
    public static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        temp = new int[n];
        cur = new int[n / 2];
        visit = new boolean[n];
        for (int i = 0; i < n; i++) {
            temp[i] = i;
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        func(0, 0);
        System.out.println(answer);
    }

    private static void func(int start, int k) {
        if (k == n / 2) {
            //점수 계산 후 최솟 값 계산
            int sumA = 0;
            int sumB = 0;
            //b팀 계산
            for (int i = 0; i < visit.length - 1; i++) {
                for (int j = i + 1; j < visit.length; j++) {
                    if (visit[i] && visit[j]) {
                        sumA += (arr[i][j] + arr[j][i]);
                    } else if (!visit[i] && !visit[j]) {
                        sumB += (arr[i][j] + arr[j][i]);
                    }
                }
            }
            int c = Math.abs(sumA - sumB);
            answer = Math.min(c, answer);
            return;
        }
        for (int i = start; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                cur[k] = temp[i];
                func(i + 1, k + 1);
                visit[i] = false;
            }
        }
    }
}
