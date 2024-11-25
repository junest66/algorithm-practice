package gold.gold3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem24337 {
    static int n, a, b;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = sc.nextInt();
        b = sc.nextInt();

        List<Integer> li = new ArrayList<>();

        if (a + b > n + 1) {
            System.out.print(-1);
            return;
        }

        for (int i = 1; i < a; i++) {
            li.add(i);
        }
        li.add(Math.max(a, b));

        for (int i = b - 1; i >= 1; i--) {
            li.add(i);
        }

        if (a == 1) {
            while (li.size() < n) {
                li.add(1, 1);
            }
        } else {
            while (li.size() < n) {
                li.add(0, 1);
            }
        }
        for (int i : li) {
            System.out.print(i + " ");
        }
    }

}
