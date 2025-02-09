package gold.gold1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Problem2213 {
    static int n;
    static int[] w;
    static List<Integer>[] list;
    static List<Integer> answer = new ArrayList<>();
    static boolean[] visited;
    static int[][] dp;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        w = new int[n + 1];
        check = new boolean[n + 1];
        visited = new boolean[n + 1];
        list = new ArrayList[n + 1];
        dp = new int[n + 1][2];
        for (int i = 1; i <= n; i++) {
            w[i] = Integer.parseInt(st.nextToken());
            list[i] = new ArrayList<>();
        }
        while (true) {
            String s = br.readLine();
            if (s == null) {
                break;
            }
            st = new StringTokenizer(s);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        dfs(1);
        if (dp[1][0] < dp[1][1]) {
            System.out.println(dp[1][1]);
            trace(1, true);
        } else {
            System.out.println(dp[1][0]);
            trace(1, false);
        }
        Collections.sort(answer);
        for (Integer x : answer) {
            System.out.print(x + " ");
        }
    }

    private static void dfs(int cur) {
        dp[cur][0] = 0;
        dp[cur][1] = w[cur];
        visited[cur] = true;

        for (Integer x : list[cur]) {
            if (!visited[x]) {
                dfs(x);
                dp[cur][0] += Math.max(dp[x][0], dp[x][1]); // 현재 정점을 선택안하면 다음 정점을 선택하거나 선택안해도됌
                dp[cur][1] += dp[x][0]; //현재 정점을 선택하려면 다음 정점을 선택안해야함
            }
        }
    }

    private static void trace(int i, boolean attend) {
        check[i] = true;
        if (attend) {
            answer.add(i);
            for (Integer x : list[i]) {
                if (!check[x]) {
                    trace(x, false);
                }
            }

        } else {
            for (Integer x : list[i]) {
                if (!check[x]) {
                    if (dp[x][1] > dp[x][0]) {
                        trace(x, true);
                    } else {
                        trace(x, false);
                    }
                }
            }
        }
    }
}
