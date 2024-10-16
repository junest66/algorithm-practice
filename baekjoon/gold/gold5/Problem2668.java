package gold.gold5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem2668 {
    public static boolean[] visited;
    public static int[] arr;
    public static List<Integer> list = new ArrayList<>();

    public static void dfs(int init, int n) {
        if (init == n && visited[n]) {
            list.add(init);
        } else if (!visited[n]){
            visited[n] = true;
            dfs(init, arr[n]);
        }
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        arr = new int[n+1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            arr[i] = k;
        }
        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            dfs(i, i);
        }
        System.out.println(list.size());
        for (Integer i : list) {
            System.out.println(i);
        }
    }
}
