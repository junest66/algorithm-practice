package gold.gold5;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem1717 {
    static int[] parent;

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        parent = new int[n + 1];
        for (int i = 0; i < n + 1; i++) { // init
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            int question = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (question == 0) { // union
                union(a, b);
            } else { // same
                if (checkSum(a, b)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }

    }

    private static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa != pb) {
            parent[pb] = pa;
        }
    }

    private static int find(int n) { //경로 압축
        if (n != parent[n]) {
            parent[n] = find(parent[n]);
        }
        return parent[n];
    }

    private static boolean checkSum(int a, int b) {
        return find(a) == find(b);
    }
}
