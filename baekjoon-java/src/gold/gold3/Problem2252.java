package gold.gold3;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Problem2252 {
    static int n;
    static int k;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Integer>[] arr = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            arr[i] = new ArrayList<>();
        }
        int[] inDegree = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            arr[s].add(e);
            inDegree[e]++;
        }
        Queue<Integer> que = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                que.offer(i);
            }
        }
        while (!que.isEmpty()) {
            int now = que.poll();
            System.out.print(now + " ");
            for (int next : arr[now]) {
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    que.offer(next);
                }
            }
        }
    }
}
