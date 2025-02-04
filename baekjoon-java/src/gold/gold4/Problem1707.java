package gold.gold4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Problem1707 {
    static List<Integer>[] node;
    static int[] check;
    static boolean[] visited;
    static boolean answer;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int z = 0; z < t; z++) {
            String[] s = br.readLine().split(" ");
            int v = Integer.parseInt(s[0]);
            int e = Integer.parseInt(s[1]);
            node = new List[v + 1];
            check = new int[v + 1];
            visited = new boolean[v + 1];
            answer = true;

            for (int i = 1; i <= v; i++) {
                node[i] = new ArrayList<>();
            }
            for (int i = 0; i < e; i++) {
                s = br.readLine().split(" ");
                int start = Integer.parseInt(s[0]);
                int end = Integer.parseInt(s[1]);
                node[start].add(end);
                node[end].add(start);
            }
            for (int i = 1; i <= v; i++) {
                if (answer) {
                    dfs(i);
                } else {
                    break;
                }
            }
            if (answer) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static void dfs(int n) {
        visited[n] = true;
        for (int i : node[n]) {
            if (!visited[i]) {
                check[i] = check[n] ^ 1;
                dfs(i);
            } else if (check[n] == check[i]) {
                answer = false;
            }
        }
    }
}
