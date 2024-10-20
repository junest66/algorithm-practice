package gold.gold4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ProblemPrim1197 {

    private static List<int[]>[] list;
    private static int n,m;
    private static int answer = 0;
    private static int cnt = 0;
    private static boolean[] checked;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n+1];
        checked = new boolean[n+1];
        for(int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            list[start].add(new int[]{dist, end});
            list[end].add(new int[]{dist, start});
        }

        checked[1] = true;
        PriorityQueue<int[]> pr = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        for (int[] ints : list[1]) {
            pr.offer(new int[]{ints[0], 1, ints[1]});
        }
        while(cnt < n-1) {
            int[] current = pr.poll();
            int dist = current[0];
            int end = current[2];
            if(checked[end]) {
                continue;
            }
            System.out.println(Arrays.toString(current));
            cnt++;
            checked[end] = true;
            answer += dist;
            for(int[] x : list[end]) {
                if(!checked[x[1]]) {
                    pr.offer(new int[]{x[0], end, x[1]});
                }
            }
        }

        System.out.println(answer);

    }
}
