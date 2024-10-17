package gold.gold5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem12919 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String s = st.nextToken();
        st = new StringTokenizer(br.readLine());
        String t = st.nextToken();
        Queue<StringBuilder> que = new LinkedList<>();
        que.offer(new StringBuilder(t));
        while (!que.isEmpty()) {
            StringBuilder current = que.poll();
            if (current.toString().equals(s)) {
                System.out.println("1");
                return;
            }
            if (current.length() != s.length()) {
                StringBuilder sb1 = new StringBuilder(current).reverse();
                if (current.charAt(current.length() - 1) == 'A') {
                    que.offer(new StringBuilder(current).deleteCharAt(current.length() - 1));
                }
                if (sb1.charAt(current.length() - 1) == 'B') {
                    que.offer(new StringBuilder(sb1).deleteCharAt(current.length() - 1));
                }
            }
        }
        System.out.println("0");
    }
}
