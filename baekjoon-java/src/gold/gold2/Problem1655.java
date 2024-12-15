package gold.gold2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Problem1655 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue maxPq = new PriorityQueue(Collections.reverseOrder());
        PriorityQueue minPq = new PriorityQueue();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (maxPq.size() == minPq.size()) {
                maxPq.offer(num);
            } else {
                minPq.offer(num);
            }
            if (!maxPq.isEmpty() && !minPq.isEmpty() && (int) maxPq.peek() > (int) minPq.peek()) {
                int max = (int) maxPq.poll();
                int min = (int) minPq.poll();
                maxPq.offer(min);
                minPq.offer(max);
            }
            System.out.println(maxPq.peek());
        }
    }
}
