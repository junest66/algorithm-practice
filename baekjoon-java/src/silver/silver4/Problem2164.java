package silver.silver4;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem2164 {
    static int n;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        Queue<Integer> que = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            que.add(i);
        }
        while (que.size() > 1) {
            que.poll();
            que.add(que.poll());
        }
        System.out.println(que.poll());
    }
}
